package productList;

public enum ChangeMenuSelection {

    CHANGE_ALL_PRODUCT("CA", "Change all product"),
    CHANGE_PRODUCT_NAME("CN", "Change product name"),
    CHANGE_PRODUCT_PRICE("CP", "Change product price"),
    CHANGE_PRODUCT_QUANTITY("CQ", "Change product quantity");

    String code;
    String name;

    ChangeMenuSelection(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
