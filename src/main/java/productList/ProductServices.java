package productList;

import java.util.Map;

public class ProductServices {
    public void addProduct(DaysOfTheWeek daysOfTheWeek, Product product, Map<DaysOfTheWeek, Product> productList) {
        if (!productList.containsKey(daysOfTheWeek)) {
            productList.put(daysOfTheWeek, product);
            System.out.println("New product " + product + " was added for " + daysOfTheWeek);
        } else {
            System.out.println("Product was not added, product for " +  daysOfTheWeek + " already exits");
        }
    }

    public void showProductList(Map<DaysOfTheWeek, Product> productList) {
        for (Map.Entry<DaysOfTheWeek, Product> day : productList.entrySet()) {
            System.out.println(day.getKey() + " - " + day.getValue());
        }
    }

    public void removeProduct(DaysOfTheWeek daysOfTheWeek, Map<DaysOfTheWeek, Product> productList) {
        productList.remove(daysOfTheWeek);
    }

//    public void editProduct(DaysOfTheWeek daysOfTheWeek, Map<DaysOfTheWeek, Product> productList) {
//        productList.replace(daysOfTheWeek, );
//    }

    public Product changeProductName(String name, Product product) {
        product.setName(name);
        return product;
    }

    public Product changeProductPrice(double price, Product product) {
        product.setPrice(price);
        return product;
    }

    public Product changeProductQuantity(int quantity, Product product) {
        product.setQuantity(quantity);
        return product;
    }

}
