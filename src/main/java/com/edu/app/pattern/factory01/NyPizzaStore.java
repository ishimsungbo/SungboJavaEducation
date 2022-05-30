package com.edu.app.pattern.factory01;

public class NyPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String pizzaName) {

        if (pizzaName.equals("뉴욕 A피자")) {
            return new NyStyle_A_Pizza();
        } else if (pizzaName.equals("뉴욕 B피자")) {
            return new NyStyle_B_Pizza();
        } else if (pizzaName.equals("") || pizzaName == ""){
            System.out.println("피자 명을 적지 않으셨어요");
        }else{
            System.out.println("주문하신 피자는 없어요!");
        }
        return null;
    }



}
