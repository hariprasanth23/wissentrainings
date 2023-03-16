package com.trial;

import java.util.*;
import java.util.stream.Collectors;

public class trail1 {

    public static List<Integer> sort(List<Integer> data) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : data) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Collections.sort(data,(v1,v2)->{
            int f1 = map.get(v1);
            int f2 = map.get(v2);
            if(f1 == f2){
                return v2-v1;
            }else{
                return f2-f1;
            }
        });

        System.out.println("data a-->"+data);

        return data;
    }

    public static void main(String[] args){

        List<Integer> sortList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 1, 4, 1));
        List<Integer> sortedList = sort(sortList).stream().distinct().collect(Collectors.toList());
        System.out.println(sortedList);

    }
}
