package coding;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationOfString {
    public static void main(String[] args){
        String str = "welcome";

        ArrayList<ArrayList<Character>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>());

        System.out.println(arrayList);

//        for(int i=0;i<str.length();i++){
//             ArrayList<Character> temp = new ArrayList<>();
//             for(List<Character> characterList:arrayList){
//                 temp.add(characterList);
//             }
//             arrayList.add(temp);
//             System.out.println(temp);
//        }

    }
}
