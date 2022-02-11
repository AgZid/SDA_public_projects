package stock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StockService {

    List<GoodItem> goodsInStock = new ArrayList<>();

    public void readStockGoodsJson() {

        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/StockGoodsStartFile.json"));

            // convert JSON string to User object
            //Emp user = gson.fromJson(reader, Emp.class);
            goodsInStock = new Gson().fromJson(reader, new TypeToken<List<GoodItem>>() {
            }.getType());

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void showGoodsInStock() {
        System.out.println("Available goods in stock:");
        goodsInStock.forEach(goodItem -> System.out.println(goodItem.getName() + " "
                + goodItem.getPrice() + " EUR"));
    }

    public int checkGood(String goodName, Integer goodQuantity) {
        if (isGoodInStock(goodName) && isEnoughGoodInStock(goodName, goodQuantity)) {
            return 1;
        } else if (!isGoodInStock(goodName)) {
            System.out.println("Good is not in stock");
            return 0;
        } else {
            System.out.println("Not enough quantity in stock");
            return -1;
        }
    }

    public boolean isEnoughGoodInStock(String goodName, Integer goodQuantity) {
        return goodsInStock.stream()
                .filter(goodItem -> goodItem.getName().equalsIgnoreCase(goodName))
                .anyMatch(goodItem -> goodItem.getQuantity() >= goodQuantity);
    }

    public boolean isGoodInStock(String goodName) {
        return goodsInStock.stream()
                .anyMatch(goodItem -> goodItem.getName().equalsIgnoreCase(goodName));
    }

    public double getGoodPrice(String goodName) throws Exception {
        return goodsInStock.stream()
                .filter(goodItem -> goodItem.getName().equalsIgnoreCase(goodName))
                .map(GoodItem::getPrice)
                .findFirst()
                .orElseThrow(() -> new Exception("Price not found"));
    }
}
