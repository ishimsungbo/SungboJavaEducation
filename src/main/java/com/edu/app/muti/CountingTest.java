package com.edu.app.muti;

/**
 * 스레드 안정성이 깨지는 상황의 예
 *
 * 100개의 쓰게드를 생성했고
 * 이러한 동작들 사이사이에 여러 스레드가 접근하게 되면 동시성 이슈가 발생할 수 있다.
 * 여러 스레드에서 동시에 count 변수에 접근한다면 동시에 1번 동작을 진행하여 같은
 * count 값을 조회할 것이고, 두 개의 스레드가 1을 더하는 조회 로직을 샐행단다고 해도 2가 더해지는 것이 아닌
 * 1만 더해지는 동작이 발생할 수 있다.
 * 암시적 lock :  synchronized
 * 명시적 Lock : count.getLock().lock();  count.getLock().unlock();
 * lock() : 다른 스레드가 해당 lock() 메서드 시작점에 접근하지 못하고 대기
 * unlock() : 다른 메서드가 lock을 획득할 수 있게 된다.
 */
public class CountingTest {
    public static void main(String[] args) {
        /*
        Count count = new Count();
        for(int i = 0; i < 100 ;i++){
            for(int j=0; j <  100;j++){
                System.out.println(count.view());
            }
        }
        */


        Count count = new Count();
        for(int i = 0; i < 100 ;i++){
            //System.out.println("==>" + i);
            new Thread(){
                @Override
                public void run() {
                    for(int j=0; j < 100 ;j++){
                        System.out.println(count.view());
                    }
                }
            }.start();
        }

        System.out.println("=====>> "+count.getCount());
    }
}

class Count{
    private int count;
    public int view(){
        return count++;
    }
    public int getCount(){
        return count;
    }
}
