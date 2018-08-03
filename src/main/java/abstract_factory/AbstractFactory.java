package abstract_factory;

/**
 * DateTime 2018-04-22 17:20
 *
 * @author db
 **/
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
