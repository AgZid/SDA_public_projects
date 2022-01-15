package productListAdvanced;

import java.util.*;

public class ProductServices {
    public void addProduct(DaysOfTheWeek daysOfTheWeek, Product product, Map<DaysOfTheWeek, Set<Product>> productList) {
        Set<Product> listTobeAdded =  productList.get(daysOfTheWeek);
        boolean isProductInTheList = false;

        for (Product productFromList : listTobeAdded) {
            if (productFromList.getName().equalsIgnoreCase(product.getName())) {
                System.out.println("Product already exits");
                System.out.println("New product " + product + " was not added for " + daysOfTheWeek);
                isProductInTheList = true;
            }
        }

        if (isProductInTheList = false) {
            if (listTobeAdded == null) {
                listTobeAdded = new HashSet<>();
                productList.put(daysOfTheWeek, listTobeAdded);
            }
            listTobeAdded.add(product);

            System.out.println("New product " + product + " was added for " + daysOfTheWeek);
        }
    }

    public void showProductList(Map<DaysOfTheWeek, Set<Product>> productList) {
        for (Map.Entry<DaysOfTheWeek, Set<Product>> day : productList.entrySet()) {
            System.out.println(day.getKey() + " - " + day.getValue());
        }
    }

    public void removeProduct(DaysOfTheWeek day, String productToRemove, Map<DaysOfTheWeek, Set<Product>> productList) {
        Set<Product> listOfProducts = productList.get(day);

        Iterator<Product> iterator = listOfProducts.iterator();

        while (iterator.hasNext()) {
            Product nextContact = iterator.next();
            if (productToRemove.equalsIgnoreCase(nextContact.getName())) {
                iterator.remove();
            }
        }

        if (listOfProducts.isEmpty()) {
            productList.remove(day);
        };
    }

}
