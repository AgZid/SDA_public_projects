package productListAdvanced;

import java.util.*;

public class ProductMain {

    Scanner scanner = new Scanner(System.in);
    char selectedMenuCode;
    DaysOfTheWeek selectedDay;

    Map<DaysOfTheWeek, Set<Product>> productList = new HashMap<>();
    ProductServices productServices = new ProductServices();

    public static void main(String[] args) {

        ProductMain productMain = new ProductMain();

        Set<Product> productList1 = new HashSet<>();
        productList1.add(new Product("Obuoliai", 1.50,20));
        productList1.add(new Product("Kopustai", 0.30,10));
        productMain.productList.put(DaysOfTheWeek.MONDAY, productList1);

        Set<Product> productList2 = new HashSet<>();
        productList2.add(new Product("Obuoliai", 1.60,15));
        productList2.add(new Product("Morkos", 0.40,15));
        productList2.add(new Product("Burokai", 0.20,20));
        
        productMain.productList.put(DaysOfTheWeek.TUESDAY, productList2);

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

                selectedDay = enterDaysOfTheWeek();
                additionToTheList();

            } else if (selectedMenuCode == 'R') {

                selectedDay = enterDaysOfTheWeek();
                removalOfTheList();

            } else if (selectedMenuCode == 'C') {

                selectedDay = enterDaysOfTheWeek();
                System.out.println("Product to change");
                removalOfTheList();

                System.out.println("New product entities");
                additionToTheList();

            } else if(selectedMenuCode == 'S') {

                productServices.showProductList(productList);

            } else {

                System.out.println("Goodbye");

            }
        }
    }

    private void removalOfTheList() {

        String productToRemove = enterProductNameToRemove(selectedDay);
        productServices.removeProduct(selectedDay, productToRemove, productList);
    }

    private void additionToTheList() {
        String productName = enterProductName();
        double productPrice = enterProductPrice();
        int productQuantity = enterProductQuantity();

        productServices.addProduct(selectedDay, new Product(productName, productPrice, productQuantity), productList);
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

    public String enterProductNameToRemove(DaysOfTheWeek day) {
        System.out.println("Products list:");
        System.out.println(productList.get(day));
        return enterProductName();
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
        for (DaysOfTheWeek day : DaysOfTheWeek.values()) {
            System.out.println(day.dayNumber + " - " + day.name);
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
