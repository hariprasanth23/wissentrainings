package com.trial;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class trial3 {
    public static void main(String[] args){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        for(var a:list){
            list.add(15);
        }

//        Map<Integer,String> map = new ConcurrentHashMap<>();
//        map.put(1,"hari");
//        map.put(2,"prasanth");
//
//        Iterator iterator = map.entrySet().iterator();
//
//        while(iterator.hasNext()){
//            map.put(4,"new item");
//        }


    }
}
