package gasStation;

public class Gas {
    private String type;
    private double price;

    public Gas(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Gas(Gas gas) {

    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

}
