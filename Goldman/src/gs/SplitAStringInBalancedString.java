package gs;

import java.util.Stack;

public class SplitAStringInBalancedString {

    public int balancedSplitString(String s){

        int max=0;
        Stack<Character> stackR = new Stack<>();
        Stack<Character> stackL = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='R'){
                stackR.push(ch);
            }else if(ch == 'L'){
                stackL.push(ch);
            }
            if(stackR.size() == stackL.size()){
                max += 1;
            }
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(new SplitAStringInBalancedString().balancedSplitString("RLRRLLRLRL"));
        System.out.println(new SplitAStringInBalancedString().balancedSplitString("RLRRRLLRLL"));

    }
}
