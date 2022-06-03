package com.edu.app.pattern.strage;

public class Atom  extends Robot{

    public Atom(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("(아톰)저는 강력한 펀치로 공격합니다");
    }

    @Override
    public void move() {
        System.out.println("(아톰)저는 날라다닙니다.");
    }
}
