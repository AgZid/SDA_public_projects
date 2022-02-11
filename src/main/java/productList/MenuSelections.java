package productList;

public enum MenuSelections {
    SHOW_PRODUCTS("Show product list", 'S'),
    ADD_PRODUCT("Add product", 'A'),
    REMOVE_PRODUCT("Remove product", 'R'),
    CHANGE_PRODUCT("Change product entities", 'C'),
    EXIT_APPLICATION("Exit", 'E');

    String name;
    char code;

    MenuSelections(String name, char code) {
        this.name = name;
        this.code = code;
    }
}

