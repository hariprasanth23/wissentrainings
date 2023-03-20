package com.singletonDesignPattern;

class MyClone implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class LazySingletonClone extends MyClone{

    private LazySingletonClone(){}
    private static LazySingletonClone instance;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }

    public static synchronized  LazySingletonClone getInstance(){
        if(instance == null){
            return instance = new LazySingletonClone();
        }else{
            return instance;
        }
    }
}

public class MyCloneDemo{
    public static void main(String[] args) throws CloneNotSupportedException {

        LazySingletonClone instance1 = LazySingletonClone.getInstance();

        LazySingletonClone instance2 = (LazySingletonClone) instance1.clone();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}

