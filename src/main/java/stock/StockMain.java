package stock;

import java.util.Scanner;

public class StockMain {

    static Scanner scanner;
    public static void main(String[] args) throws Exception {

        scanner = new Scanner(System.in);
        StockMain stockMain = new StockMain();

        StockService stockService = new StockService();
        stockService.readStockGoodsJson();

        CartService cartService = new CartService(new Cart());

        stockMain.showMenu();
        String userSelectedMenuOption = "S";

        while (!userSelectedMenuOption.equalsIgnoreCase("E")) {

            userSelectedMenuOption = scanner.nextLine();
            if (stockMain.isUserInputIncorrect(userSelectedMenuOption)) {
                System.out.println("Incorrect input");

            } else if (userSelectedMenuOption.equalsIgnoreCase("SA")) {
                stockService.showGoodsInStock();

            } else if (userSelectedMenuOption.equalsIgnoreCase("SC")) {
                cartService.showGoodsInCart();

            } else if (userSelectedMenuOption.equalsIgnoreCase("A")) {
                stockMain.addingGoodToCart(stockService, cartService);

            } else if (userSelectedMenuOption.equalsIgnoreCase("R")) {
                String userEnteredGood = provideGoodName("Enter the name of the good to be removed");
                cartService.removeGoodsFromCart(userEnteredGood);

            } else if (userSelectedMenuOption.equalsIgnoreCase("T")) {
                cartService.previewTotalPrice();

            } else if (userSelectedMenuOption.equalsIgnoreCase("C")) {
                String userEnteredGoodToChange = provideGoodName("Enter the name of the good to be changed");

                if (stockService.isGoodInStock(userEnteredGoodToChange)) {
                    cartService.removeGoodsFromCart(userEnteredGoodToChange);
                    stockMain.addingGoodToCart(stockService, cartService);
                }

            }

            if (!userSelectedMenuOption.equalsIgnoreCase("E")) {
                stockMain.showMenu();
            }
        }

        cartService.printToPDF();

    }

    private void addingGoodToCart(StockService stockService, CartService cartService) throws Exception {
        String userEnteredGood = provideGoodName("Enter good name");

        if (!cartService.isGoodInCart(userEnteredGood)) {

            Integer userEnteredQuantity = provideGoodQuantity();

            int checkGood = stockService.checkGood(userEnteredGood, userEnteredQuantity);
            if (checkGood == 1) {
                cartService.addGoodsToCart(userEnteredGood, userEnteredQuantity, stockService.getGoodPrice(userEnteredGood));
            }
        } else {
        System.out.println(userEnteredGood +  " is already in the cart");
        }
    }

    private static Integer provideGoodQuantity() {
        System.out.println("Enter quantity");
        int userEnteredQuantity = 0;

        try {
            userEnteredQuantity = Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect quantity");
        }
        return userEnteredQuantity;
    }

    private static String provideGoodName(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }

    private void showMenu() {
        System.out.println("---------MENU-------------");
        System.out.println("Select one of the menu option:");
        for (StockMenuOptions option : StockMenuOptions.values()) {
            System.out.println(option.optionCode + " - " + option.optionDescription);
        }
    }

    private boolean isUserInputIncorrect(String userInput) {
        for (StockMenuOptions options : StockMenuOptions.values()) {
            if (options.optionCode.equalsIgnoreCase(userInput)) {
                return false;
            }
        }
        return true;
    }
}
