package gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultantArrayRemovingAnagram {


    public Boolean anagramcheck(String str1, String str2){
        String str3= Arrays.stream(str1.split("")).sorted().collect(Collectors.joining());
        String str4=Arrays.stream(str2.split("")).sorted().collect(Collectors.joining());
        return str3.equals(str4);
    }


    public List<String> RemovingAnagram(String[] str){
        List<String> stringList = new ArrayList<>(Arrays.asList(str));
        List<String> finalList = new ArrayList<>();

        if(stringList.size()==1){
            return stringList;
        }
        finalList.add(stringList.get(0));
        for(int i=1;i<stringList.size();i++){
            if(!anagramcheck(finalList.get(finalList.size()-1),stringList.get(i))){
                finalList.add(stringList.get(i));
            }
        }
        return finalList;
    }

    public static void main(String[] args){

        String[] strings={"abba","baba","bbaa","cd","cd"};
        new ResultantArrayRemovingAnagram().RemovingAnagram(strings);
    }
}
