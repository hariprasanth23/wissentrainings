package gs;

public class FirstindexFirstOccurence {

    public int strStr(String haystack, String needle){
        if(haystack.contains(needle))
            return haystack.indexOf(needle);
        return -1;
    }


    public static void main(String[] args){
        int firstIndex= new FirstindexFirstOccurence().strStr("sadbutsad","sad");
        System.out.println(firstIndex);
    }
}
