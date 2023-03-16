package gfg;

import java.util.HashMap;
import java.util.Map;

public class Poobesh {
    public static void main(String[] args){
        String str = "aabbbcccccaaaaaa";
        int max;
        Map<Character,Integer> map = new HashMap<>();
        int count=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1) == str.charAt(i)){
               count++;
            }else{
                map.put(str.charAt(i-1),count);
                count=1;
            }

            if(i==str.length()-1){
                map.put(str.charAt(i-1),count);
            }
        }
        System.out.println(map);

        HashMap<Integer,Integer> hashMap= new HashMap<>();
    }
}
