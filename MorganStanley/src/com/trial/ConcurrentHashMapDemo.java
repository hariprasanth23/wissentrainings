package com.trial;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args){

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1,"hari");
        map.put(2,"prasanth");


        new Thread(()->{ map.put(1,"h1"); }).start();
        new Thread(()->{ map.put(1,"h2"); }).start();
        new Thread(()->{ map.put(1,"h3"); }).start();
        new Thread(()->{ map.put(1,"h4"); }).start();
        new Thread(()->{ map.put(1,"h4"); }).start();

        System.out.println(map);
    }
}
