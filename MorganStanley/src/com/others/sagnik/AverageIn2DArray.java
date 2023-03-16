package com.others.sagnik;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AverageIn2DArray {
    public static void main(String[] args){
        String[][] str = {{"Alpha","92"},{"Charlie","95"},{"Bravo", "98"},{"Charlie", "96"},{"Tango", "90"}};
        List<Integer> list = Stream.of(str).map(x->x[1]).map(x->Integer.parseInt(x)).collect(Collectors.toList());
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum/(list.size()));
    }
}
