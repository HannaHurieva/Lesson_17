package kitchen.dish.impl;

import kitchen.dish.Dish;

public class FirstDishes extends Dish {
    private String value;

    public FirstDishes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
