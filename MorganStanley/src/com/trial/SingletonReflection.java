package com.trial;

import java.lang.reflect.Constructor;

public class SingletonReflection {

    private static SingletonReflection instance ;

    private SingletonReflection(){
        if(instance!=null){
            throw new RuntimeException();
        }
    }

    public synchronized static SingletonReflection getInstance() {
        if(instance == null){
            instance = new SingletonReflection();
        }
        return instance;
    }


}


final class Item{

    private final int id;
    private final String name;

    public Item(int id,String name){
        this.id = id;
        this.name = name;
    }

    //getters

    public static int search(int key){
        int low =1;
        int high = key;

        while(low <= high){
            int midPosition = (low + high) /2 ;
            int midValue = midPosition * midPosition;

            if(midValue == key){
                return midPosition;
            }

            if(midValue < key)
            {
                low = midPosition + 1;
            }else{
                high = midPosition - 1;
            }
        }
        return high;

    }

    public static void main(String[] args){

        System.out.println(search(168));

    }
}
