package productList;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ProductMain {

    Scanner scanner = new Scanner(System.in);
    char selectedMenuCode;

    Map<DaysOfTheWeek, Product> productList = new HashMap<>();
    ProductServices productServices = new ProductServices();

    public static void main(String[] args) {

        ProductMain productMain = new ProductMain();

        productMain.productList.put(DaysOfTheWeek.MONDAY, new Product("Obuoliai", 1.50,2));
        productMain.productList.put(DaysOfTheWeek.TUESDAY, new Product("Kopustai", 0.30,10));

        productMain.handleMenu();
    }

    private void handleMenu() {
        selectedMenuCode = 'A';

        while(selectedMenuCode != 'E') {

            System.out.println();
            showMenu();

            selectedMenuCode = scanner.next().charAt(0);
            while (!checkUserSelection(selectedMenuCode)) {
                showMenu();
                selectedMenuCode = scanner.next().charAt(0);
            }

            if (selectedMenuCode == 'A') {

                DaysOfTheWeek selectedDay = enterDaysOfTheWeek();
                String productName = enterProductName();
                double productPrice = enterProductPrice();
                int productQuantity = enterProductQuantity();

                productServices.addProduct(selectedDay, new Product(productName, productPrice, productQuantity), productList);

            } else if (selectedMenuCode == 'R') {

                DaysOfTheWeek selectedDay = enterDaysOfTheWeek();

                productServices.removeProduct(selectedDay, productList);

            } else if (selectedMenuCode == 'C') {

                DaysOfTheWeek selectedDay = enterDaysOfTheWeek();

                String productName = enterProductName();
                double productPrice = enterProductPrice();
                int productQuantity = enterProductQuantity();

                productServices.changeProductName(productName, productList.get(selectedDay));
                productServices.changeProductPrice(productPrice, productList.get(selectedDay));
                productServices.changeProductQuantity(productQuantity, productList.get(selectedDay));

            } else if(selectedMenuCode == 'S') {
                productServices.showProductList(productList);
            } else {
                System.out.println("Goodbye");
            }
        }
    }

    private String enterProductName() {
        System.out.println("Enter product name");
        String productName = scanner.next();
        return productName;
    }

    private double enterProductPrice() {
        System.out.println("Enter product price");
        double productPrice;
        try {
            productPrice = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Klaida " + e);
            return 1;
        }
        return productPrice;
    }

    private int enterProductQuantity() {
        System.out.println("Enter product quantity");
        int productQuantity;
        try {
            productQuantity = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Klaida " + e);
            return 1;
        }
        return productQuantity;
    }

    private DaysOfTheWeek enterDaysOfTheWeek() {
        System.out.println("Select a day of the week");
        showDaysOfTheWeek();

        int day = scanner.nextInt();
        DaysOfTheWeek selectedDay = checkSelectedDay(day);

        if (selectedDay == null) {
            showDaysOfTheWeek();

            day = scanner.nextInt();
            selectedDay = checkSelectedDay(day);
        }
        return selectedDay;
    }

    private void showMenu() {
        System.out.println("---------MENU-------------");
        System.out.println("Select one of the menu option:");
        for(MenuSelections selection: MenuSelections.values()) {
            System.out.println(selection.code + " - " + selection.name);
        }
    }

    private void showDaysOfTheWeek() {
        System.out.println("---------MENU-------------");
        for(DaysOfTheWeek day: DaysOfTheWeek.values()) {
            if (selectedMenuCode == 'R' || selectedMenuCode == 'C') {
                if (productList.containsKey(day)) {
                    System.out.println(day.dayNumber + " - " + day.name);
                }
            } else {
                if (!productList.containsKey(day)) {
                    System.out.println(day.dayNumber + " - " + day.name);
                }
            }
        }
    }

    private boolean checkUserSelection(char selectedMenuCode) {
        for(MenuSelections selection : MenuSelections.values()) {
            if (selection.code == selectedMenuCode) {
                return true;
            }
        }
        System.out.println("Incorrect input");
        return false;
    }

   private DaysOfTheWeek checkSelectedDay(int dayNumber) {
        for(DaysOfTheWeek selection : DaysOfTheWeek.values()) {
            if (selection.dayNumber == dayNumber) {
               return selection;
            }
        }
        System.out.println("Incorrect input");
        return null;
    }

}
