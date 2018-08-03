package abstract_factory;

/**
 * DateTime 2018-04-22 17:14
 *
 * @author db
 **/
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
