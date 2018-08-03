package reactive;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Callable;

/**
 * DateTime 2018/8/3 17:12
 *
 * @author db
 **/
public class TimeConsumingService implements Callable<String> {

    private String service_name;
    private int wait_ms;

    public TimeConsumingService() {
    }

    public TimeConsumingService(String name, Integer waiting, String[] depandencies) {
        this.service_name = name;
        this.wait_ms = waiting;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(wait_ms);
        return String.format("service %s exec time is: %d", service_name,wait_ms);
    }


    public void testAsyncCompositeJoin(){
        System.out.println("Prepare for execution：Async Composite Join");
        long startTime = System.currentTimeMillis(); //获取开始时间

        //task oa -> oc, both in the same thread 1
        Observable<String> oa = Observable.just("oa")
                .observeOn(Schedulers.io())
                .flatMap(soa ->
                        Observable.fromCallable(new TimeConsumingService("fa",1000,new String[]{}))
                );

        Observable<String> oc = oa.flatMap(
                (String res) -> {
                    System.out.println(res);
                    System.out.println("Executed At： " + (System.currentTimeMillis() - startTime) + "ms");
                    return Observable.fromCallable(new TimeConsumingService("fc",2000,new String[]{}));
                });

        //task ob -> (od,oe), ob od oe have special Thread 2,3,4
        Observable<String> ob = Observable.just("ob")
                .observeOn(Schedulers.io())
                .flatMap(sob ->
                        Observable.fromCallable(new TimeConsumingService("fb", 2000, new String[]{}))
                );

        Observable<String> od_oe = ob.flatMap(
                (String res) -> {
                    System.out.println(res);
                    System.out.println("Executed At:  " + (System.currentTimeMillis() - startTime) + "ms");

                    Observable<String> od = Observable.just("od")
                            .observeOn(Schedulers.io())
                            .flatMap(sod ->
                                    Observable.fromCallable(new TimeConsumingService("fd", 1000, new String[]{}))
                            );

                    Observable<String> oe = Observable.just("oe")
                            .observeOn(Schedulers.io())
                            .flatMap(soe ->
                                    Observable.fromCallable(new TimeConsumingService("fe", 1000, new String[]{}))
                            );
                    return Observable.merge(od, oe);
                });

        System.out.println("Observable build:  " + (System.currentTimeMillis() - startTime) + "ms");

        //task join oc,(od_oe) and subscribe
        Observable.merge(oc,od_oe).blockingSubscribe(
                (res) -> {
                    System.out.println(res);
                    System.out.println("Executed At:  " + (System.currentTimeMillis() - startTime) + "ms");
                });

        System.out.println("End Executed At:  " + (System.currentTimeMillis() - startTime) + "ms");
    }
}