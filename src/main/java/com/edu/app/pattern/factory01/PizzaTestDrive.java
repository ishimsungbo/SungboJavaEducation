package com.edu.app.pattern.factory01;

public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NyPizzaStore();

        Pizza nyA_pizza = nyStore.orderPizza("ë´ì Aí¼ì");
    }

}
