package gs;

import java.util.ArrayDeque;

public class BalancingParanthesis {
    public Boolean isbalance(String paranString){

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<paranString.length();i++){
            char ch = paranString.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }
            char ch1;
            switch (ch){

                case ')': ch1=stack.pop();
                    if(ch1 == '[' || ch1 == '{'){
                    return false;
                }
                break;
                case ']':ch1=stack.pop();
                    if(ch1 == '(' || ch1 == '{'){
                    return false;
                }
                break;
                case '}':ch1=stack.pop();
                    if(ch1 == '[' || ch1 == '('){
                    return false;
                }
                break;
            }

        }

        return stack.isEmpty();
    }


    public static void main(String[] args){

        String str = "{{}}(())";
        System.out.println(new BalancingParanthesis().isbalance(str));

    }
}
