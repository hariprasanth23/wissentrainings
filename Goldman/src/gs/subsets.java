package gs;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    public List<List<Integer>> subsets(int[] S) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        for(int i:S){
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> sub: result){
                ArrayList<Integer> temp2= new ArrayList<>(sub);
                temp2.add(i);
                temp.add(temp2);
            }
            result.addAll(temp);
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println(new subsets().subsets(new int[]{1,2,3}));
    }
}
