package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class groupAnagrams {

    public List<List<String>> groupAnagram(String[] strings) {

        HashMap<String,List<String>> hashMap = new HashMap<>();

        for(String temp:strings){
            String keyValue = Arrays.stream(temp.split("")).sorted().collect(Collectors.joining(""));
            if(hashMap.containsKey(keyValue)){
                hashMap.get(keyValue).add(temp);
            }else{
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(temp);
                hashMap.put(keyValue,tempList);
            }
        }

        return hashMap.values().stream().collect(Collectors.toList());
    }



    public static void main(String[] args){

        String[] strings={"eat","tea","tan","ate","nat","bat"};
        new groupAnagrams().groupAnagram(strings).forEach(System.out::println);
    }


}
