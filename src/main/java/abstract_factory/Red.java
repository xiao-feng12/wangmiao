package abstract_factory;

/**
 * DateTime 2018-04-22 17:18
 *
 * @author db
 **/
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
