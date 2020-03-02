package homework3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static homework3.Main.LOG;

public class Shop {
    private void purchaseConfirmation(Map<String, Double> products) {
        boolean isAlcohol = products.keySet().stream()
                .anyMatch(x -> x.equalsIgnoreCase("beer"));

        if (isAlcohol) {
            if (!ageChecker()) {
                LOG.error("Buyer doesn`t has 18 years.");
                System.out.println("You can`t buy alcohol! Your age is less than 18!");
            }
        } else {
            double sum = products.values().stream().mapToDouble(Double::doubleValue).sum();
            String message = String.format("Buy successfully completed! Sum = %f", sum);
            LOG.info(message);
            System.out.println("Success!");
        }
    }

    private boolean ageChecker() {
        System.out.println("Enter your age:");
        int age = new Scanner(System.in).nextInt();

        if (age >= 18) {
            return true;
        }

        return false;
    }

    public void productChoicer() {
        LOG.info("New buyer came to shop.");
        Map<String, Double> products = new LinkedHashMap<>();
        boolean isBuy = true;

        LOG.info("Buyer starts choice products.");
        do {
            productList();
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    LOG.info("Buyer chooses Milk with price 12.75");
                    products.put("Milk", 12.75);
                    break;

                case 2:
                    LOG.info("Buyer chooses Bread with price 8.1");
                    products.put("Bread", 8.1);
                    break;

                case 3:
                    LOG.info("Buyer chooses Chocolate with price 14.21");
                    products.put("Chocolate", 14.21);
                    break;

                case 4:
                    LOG.info("Buyer chooses Cookies with price 9.12");
                    products.put("Cookies", 9.12);
                    break;

                case 5:
                    LOG.info("Buyer chooses Beer with price 13.25");
                    products.put("Beer", 13.25);
                    break;

                case 6:
                    LOG.info("Buyer chooses Chips with price 11.22");
                    products.put("Chips", 11.22);
                    break;

                case 7:
                    LOG.info("Buyer wants to buy products");
                    isBuy = false;
                    break;

                default:
                    LOG.warn("Buyer chooses product with wrong id");
                    System.out.println("Product with this id is missing!");
                    break;
            }
        } while (isBuy);

        purchaseConfirmation(products);
    }

    private void productList() {
        System.out.println("========================================================================================");
        System.out.println("Products:");
        System.out.println("1.Milk | 12.75");
        System.out.println("2.Bread | 8.10");
        System.out.println("3.Chocolate | 14.21");
        System.out.println("4.Cookies | 9.12");
        System.out.println("5.Beer | 13.25");
        System.out.println("6.Chips | 11.22");
        System.out.println("7.Buy");
        System.out.println("========================================================================================");
    }

}
