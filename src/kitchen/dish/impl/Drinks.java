package kitchen.dish.impl;

import kitchen.dish.Dish;

public class Drinks extends Dish {
    private String value;

    public Drinks(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
