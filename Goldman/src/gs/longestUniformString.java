package gs;

import java.util.*;

public class longestUniformString {
    public static void main(String[] args) {
        String str="aaabbccccdddddeeeaaaaaa";

        char checkingCharacter = str.charAt(0);
        int Index=0;
       int lastIndex=0;
        int max=0;
        int count=0;
        for(int i=0;i<str.length();i++){
            if(checkingCharacter == str.charAt(i)){
                count++;
            }else{

                if(count>max){
                    max=count;
                    Index=i;
                }
                System.out.println("count-->"+count);
                checkingCharacter=str.charAt(i);
                count=1;
                Index=i;
            }
        }
        System.out.println("count-->"+count);
        if(count>max){
            max=count;
        }
        System.out.println("max-->"+max);
        System.out.println("index-->"+Index);

    }
}
