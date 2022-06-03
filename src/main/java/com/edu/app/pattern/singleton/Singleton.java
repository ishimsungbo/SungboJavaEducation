package com.edu.app.pattern.singleton;

public class Singleton {
    private static Singleton unqueInstance;

    /* 처음 객체를 인스턴스화 시킨다. 방법 2
    private static Singleton unqueInstance = new Singleton();
    public static Singleton getInstance(){
        return unqueInstance
    }
     */

    private Singleton(){}

    public static Singleton getInstance(){
        if(unqueInstance == null){
            unqueInstance = new Singleton();
        }
        return unqueInstance;
    }

    //동기화에 대한 댓가...속도가 느려진다.  synchronized
    /** 해결방법 3 가지
     *  1. 그냥 냅둔다. 메서드 동기화를 하면 100배 느려진다.
     *  2. 인스턴스를 처음부터 만들어 버진다.
     *  3. DCL를 사용 Double-checking Locking  volatile
     *  volatile 키워드를 사용하면 멀티스레딩을 쓰더라도
     *  unqueInstance 변수가 싱글톤 인스턴스를 초기화 되는 과정이 올바르게 진행된다.
     */
}
