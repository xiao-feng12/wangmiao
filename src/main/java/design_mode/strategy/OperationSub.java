package design_mode.strategy;

/**
 * DateTime 2018/8/6 18:05
 *
 * @author db
 **/
public class OperationSub implements Operation {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
