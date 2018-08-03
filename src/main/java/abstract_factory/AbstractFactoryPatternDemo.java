package abstract_factory;

import java.util.Scanner;

/**
 * DateTime 2018-04-22 17:33
 *
 * @author db
 **/
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {

        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取形状为 Square 的对象
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //获取颜色为 Red 的对象
        Color color1 = colorFactory.getColor("RED");

        //调用 Red 的 fill 方法
        color1.fill();

        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("Green");

        //调用 Green 的 fill 方法
        color2.fill();

        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("BLUE");

        //调用 Blue 的 fill 方法
        color3.fill();


        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String x = in.next();

            //获取形状为 Square 的对象
            Shape shape4 = shapeFactory.getShape(x);

            if (shape4 != null)
                shape4.draw();

            //获取颜色为 Blue 的对象
            Color color4 = colorFactory.getColor(x);

            //调用 Blue 的 fill 方法
            if (color4 != null)
                color4.fill();
        }
        in.close();
    }
}
