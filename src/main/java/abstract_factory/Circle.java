package abstract_factory;

/**
 * DateTime 2018-04-22 17:16
 *
 * @author db
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
