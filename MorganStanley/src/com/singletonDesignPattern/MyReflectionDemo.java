package com.singletonDesignPattern;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class LazySingletonReflection extends MyClone{

    private static LazySingletonReflection instance;

    private LazySingletonReflection(){
//        if(instance != null){
//            throw new IllegalStateException(" Object cant be created");
//        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static LazySingletonReflection getInstance(){
        if(instance == null){
            return instance = new LazySingletonReflection();
        }else{
            return instance;
        }
    }
}

public class MyReflectionDemo{
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException {

        LazySingletonReflection instance1 = LazySingletonReflection.getInstance();
        System.out.println(instance1.hashCode());

        LazySingletonReflection reflectionInstance = null;

        Constructor[] constructors = LazySingletonReflection.class.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            constructor.setAccessible(true);
            reflectionInstance = (LazySingletonReflection) constructor.newInstance();
        }
        System.out.println(reflectionInstance.hashCode());

    }
}

