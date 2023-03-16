package gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

    public String longestComPref(String[] strs){
        if(strs.length == 1){
           return strs[0];
        }
        List<String> latestList = new ArrayList<>();
        for(int i=1;i<strs[0].length();i++){
            String temp = strs[0].substring(0,i);
            boolean result = Arrays.stream(strs).allMatch(e->e.startsWith(temp));
            if(result){
                latestList.add(temp);
            }
        }
        if(latestList.size()>1){
            return latestList.get(latestList.size()-1);
        }else{
            return "";
        }
    }
    public static void main(String[] args){
        String[] strings = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestComPref(strings));
    }
}
