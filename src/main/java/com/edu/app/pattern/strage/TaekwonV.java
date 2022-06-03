package com.edu.app.pattern.strage;

public class TaekwonV extends Robot{

    public TaekwonV(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("(태권 브이)미사일 펀치 공격을 합니다.");
    }

    @Override
    public void move() {
        System.out.println("(태권 브이)저는 움직입니다.");
    }
}
