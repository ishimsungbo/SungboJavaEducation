package com.edu.app.pattern.strage;

public class Client {
    public static void main(String[] args) {
        Robot taekwonV = new TaekwonV("태권브이");
        Robot atom = new Atom("아톰");

        System.out.println("저의 이름은 " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();
    }
}
