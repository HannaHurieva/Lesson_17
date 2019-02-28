package kitchen.dish.impl;

import kitchen.dish.Dish;

public class Desserts extends Dish {
    private String value;

    public Desserts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
