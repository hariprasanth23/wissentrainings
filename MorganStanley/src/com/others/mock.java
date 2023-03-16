package com.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class mock {

    public List<String> removeAdjacentValues(String[] strings){

        List<String> list = new ArrayList<>();
        for(String str:strings){
            Stack<Character> stack = new Stack<>();
            if(str.length()>0){
                stack.push(str.charAt(0));
            }
            for(int i=1;i<str.length();i++){
                if(stack.peek() == str.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(str.charAt(i));
                }
            }
            list.add(stack.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
        return list;
    }

    public static void main(String[] args){

        new mock().removeAdjacentValues(new String[]{"abbccdd","bccb","xwxx","xwxw"}).forEach(System.out::println);

    }
}
