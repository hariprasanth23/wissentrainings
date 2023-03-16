package gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public String sortedString(String str){
        String sortedString= Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
        return sortedString;
    }


    public List<List<String>> groupAnagram(String[] str){

        List<String> stringList = new ArrayList<>(Arrays.asList(str));
        List<String> stringList2 = new ArrayList<>();
        List<List<String>> groupAnagramList = new ArrayList<>();

        for(int i=0;i<stringList.size();i++){
            String temp=sortedString(stringList.get(i));
            if(stringList2.contains(temp)){
                groupAnagramList.get(stringList2.indexOf(temp)).add(stringList.get(i));
            }else{
                stringList2.add(temp);
                List<String> temp2 = new ArrayList<>();
                temp2.add(stringList.get(i));
                groupAnagramList.add(temp2);
            }
        }
        return groupAnagramList;
    }

    public static void main(String[] args){

        String[] strings={"eat","tea","tan","ate","nat","bat"};
        new GroupAnagrams().groupAnagram(strings);
    }
}
