package com.others;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {


    public static List<Integer> sortByValue(HashMap<Integer,Integer> hashMap){
        List<Integer> list = new ArrayList<>( hashMap.values()).stream().distinct().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer Integer1, Integer Integer2) {
                return (Integer2).compareTo(Integer1);
            }
        });

        return list;
    }

    public static List<Integer> sort(List<Integer> data){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:data){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        System.out.println(map);

        List<Integer> finalAnswer = new ArrayList<>();

        for(int i:sortByValue(map)){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Map.Entry<Integer,Integer> sortedMap: map.entrySet()){
                if(i==sortedMap.getValue()){
                    temp.add(sortedMap.getKey());
                }
            }
            Collections.reverse(temp);
            finalAnswer.addAll(temp);
        }
        return finalAnswer;
    }


    public static void main(String[] args){

        List<Integer> sortList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 1, 4, 1));
        List<Integer> sortedList = sort(sortList);
        sortedList.forEach(System.out::println);


    }
}
