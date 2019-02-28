package kitchen.dish.impl;

import kitchen.dish.Dish;

public class SecondDishes extends Dish {
    private String value;

    public SecondDishes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
