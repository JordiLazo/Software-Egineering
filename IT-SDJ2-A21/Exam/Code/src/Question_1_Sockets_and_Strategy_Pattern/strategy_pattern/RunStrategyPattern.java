package Question_1_Sockets_and_Strategy_Pattern.strategy_pattern;

public class RunStrategyPattern {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10,5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10,5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10,5));
    }
}
