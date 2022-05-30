package com.edu.app.pattern.factory01;

public abstract class PizzaStore {

    abstract Pizza createPizza(String name);

    public Pizza orderPizza(String pizzaType){
        Pizza pizza = createPizza(pizzaType);
        System.out.println("--- making a " +pizza.name+" ---");
        pizza.bake();
        pizza.box();
        return pizza;
    }
}
