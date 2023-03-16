package com.singletonDesignPattern;

class DoubleCheckLazySingleton{

    private DoubleCheckLazySingleton(){}

    private static DoubleCheckLazySingleton instance;

    public static DoubleCheckLazySingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLazySingleton.class){
                if(instance == null){
                    return instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}

public class DoubleCheckLazySingletonDemo {
    public static void main(String[] args){

        DoubleCheckLazySingleton obj1 = DoubleCheckLazySingleton.getInstance();
        System.out.println(obj1.hashCode());

        DoubleCheckLazySingleton obj2 = DoubleCheckLazySingleton.getInstance();
        System.out.println(obj2.hashCode());

    }
}
