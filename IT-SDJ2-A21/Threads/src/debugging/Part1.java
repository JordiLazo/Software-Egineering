package debugging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Part1 {

    private static final Collection<Product> Products = new ArrayList<Product>(
            Arrays.asList  (new Product("Batteries", Category.Electronics, 2.50),
                            new Product("SD Card", Category.Electronics, 10),
                            new Product("T-shirt", Category.Electronics, 15),
                            new Product("Parmesan Cheese", Category.Grocery, 7.50),
                            new Product("Tomatoes", Category.Grocery, 2)) );

    public static void main(String[] args) {
        ShowPricesWithVat();
    }

    private static void ShowPricesWithVat() {
        System.out.println("Product prices incl. VAT:");

        for(Product product : Products)
        {
            double vat = Utils.calculateVat(product.getPrice(), product.getCategory());
            double priceWithVat = Math.round((product.getPrice() + vat)*100.0) / 100.0; // to get two decimals
            System.out.println(product.getName() + ": " + priceWithVat + " EUR");
        }
    }
}
