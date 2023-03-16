package gfg;

import java.util.Stack;

public class reverseUsingStack {
    public static void main(String[] args){

        Stack<Character> stack = new Stack<Character>();

        String str="mynameishari";

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            stack.push(ch);
        }


        for(int j=0;j<str.length();j++){
            char ch = stack.pop();
            System.out.print(ch);
        }

    }
}
