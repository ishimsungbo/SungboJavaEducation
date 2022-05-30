package com.edu.app.pattern.factory01;

public abstract class Pizza {
    public String name;

    public void bake(){
        System.out.println("기본 25분 350도에서 굽는다.");
    }

    public void box(){
        System.out.println( name + " 완료 되었습니다. 포장했습니다. 맛있게 드세요");
    }
}
