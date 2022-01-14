package Question_1_Sockets_and_Strategy_Pattern.strategy_pattern;

public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
