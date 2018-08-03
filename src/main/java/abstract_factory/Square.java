package abstract_factory;

/**
 * DateTime 2018-04-22 17:15
 *
 * @author db
 **/
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
