package gs;

import java.util.ArrayList;

public class longestPalindrome {


    public int longestPalindrome(String s) {

        String[] str= s.split("");
        ArrayList<String> arrayList = new ArrayList<>();
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(arrayList.contains(str[i])){
                arrayList.remove(str[i]);
                sum=sum+2;
            }else{
                arrayList.add(str[i]);
            }
        }

        if(arrayList.size()>0){
            sum = sum+1;
        }

        return sum;
    }

    public static void main(String[] args){
        System.out.println(new longestPalindrome().longestPalindrome("abccccdd"));
        System.out.println(new longestPalindrome().longestPalindrome("a"));
    }
}
