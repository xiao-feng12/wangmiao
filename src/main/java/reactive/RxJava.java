package reactive;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import rx.Observable;
import rx.Subscriber;


/**
 * reactive 数据驱动编程
 * DateTime 2018/8/3 14:30
 *
 * @author db
 **/
class RxJava {
    public static void hello(Integer... integers) {
        Observable<Integer> workflow = Observable.from(integers)
                .filter(i -> (i < 10) && (i > 0))
                .map(i -> i * 2);
        workflow.subscribe(i -> System.out.print(i + "! "));
    }

    public static void hello2(String... names) {
        Observable.from(names).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String strings) {
                System.out.println("same hello " + strings);
            }
        });
    }

    public static void hello3() {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        hello(-1, 4, 5, 0, 2, 19, 6);
        hello2("1", "2", "5", "4", "9", "7");
        hello3();

        TimeConsumingService ep = new TimeConsumingService();

        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
        ep.testAsyncCompositeJoin();
    }
}

