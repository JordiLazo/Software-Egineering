package debugging;

public class Utils {

    private static final double vatGrocery = 0.07;
    private static final double vatNormal = 0.19;

    public static double calculateVat(double price, Category category)
    {
        double result;

        if (category == Category.Grocery)
            result = price * vatGrocery;
        else
            result = price * vatNormal;

        return result;
    }

    public static double calculatePriceWithVat(double price, Category category)
    {
        double priceVat = price + calculateVat(price, category);
        return priceVat;
    }
}
