package com.edu.app.pattern.singleton;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //ChocolateBoiler a = new ChocolateBoiler();

        Runnable run1 = new Runnable() {
            @Override
            public void run() {

                ChocolateBoiler boiler = ChocolateBoiler.getInstance();
                boiler.fill();
                boiler.boil();
                boiler.drain();
            }
        };


        System.out.println("=============");

        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
        boiler2.fill();
        Thread.sleep(5000);
        System.out.println("***");
        run1.run();
    }
}
