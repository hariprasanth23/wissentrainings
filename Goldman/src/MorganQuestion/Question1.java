package MorganQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {
    public static void main(String[] args){
        List<List<Integer>> arrayList = new ArrayList<>();

        arrayList.add(new ArrayList<>(Arrays.asList(null,1,2,3)));
        arrayList.add(new ArrayList<>(Arrays.asList(null,4,5,3)));

        System.out.println(arrayList);

        System.out.println(arrayList instanceof List<List<Integer>>);

//        if(arrayList instanceof List<List<Integer>>){
//            arrayList.stream().map(e->e.removeAll(Arrays.asList(null))).collect(Collectors.toList());//.forEach(System.out::println);
//        }

        if(arrayList instanceof List<List<Integer>>){

            for(int i=0;i<arrayList.size();i++){
                
                arrayList.get(i).remove(Arrays.asList(null));
            }

        }

        System.out.println(arrayList);

    }
}
