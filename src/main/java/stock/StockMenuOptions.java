package stock;

public enum StockMenuOptions {
    SHOW_PRODUCTS_IN_STOCK("Show all available goods", "SA"),
    SHOW_PRODUCTS_IN_CART("Show shopping cart", "SC"),
    ADD_PRODUCT("Add good to cart", "A"),
    REMOVE_PRODUCT("Remove good from cart", "R"),
    CHANGE_PRODUCT("Change good in cart", "C"),
    TOTAL_PRICE("Show total goods price", "T"),
    EXIT_APPLICATION("Exit", "E");

    String optionCode;
    String optionDescription;

    StockMenuOptions( String optionDescription, String optionCode) {
        this.optionCode = optionCode;
        this.optionDescription = optionDescription;
    }
}
