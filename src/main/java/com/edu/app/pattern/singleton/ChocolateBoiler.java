package com.edu.app.pattern.singleton;

public class ChocolateBoiler {

    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler() {
        this.empty = true;
        this.boiled = false;
    }

    public static  ChocolateBoiler getInstance(){
        if(uniqueInstance == null){
            System.out.println("초콜렛 인스턴스를 만듭니다.");
            uniqueInstance = new ChocolateBoiler();
        }

        return uniqueInstance;
    }

    public void fill(){
        if(isEmpty()){
            System.out.println("채웁니다.");
            empty = false;
            boiled = false;
            // 보일러에 우유, 초콜렛을 혼합한 재료를 집어 넣음
        }
    }
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the contents to a boil
            boiled = true;
        }
    }
    public void drain(){
        if(!isEmpty() && isBoiled()){
            // 끓인 재료를 다음 단계로 넘김
            System.out.println("끓인 재료를 넘김");
            empty = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

}
