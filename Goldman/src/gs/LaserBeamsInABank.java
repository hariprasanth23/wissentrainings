package gs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LaserBeamsInABank {

    public int numberOfOnes(String temp){
        return (int)Arrays.stream(temp.split("")).map(e->Integer.parseInt(e)).filter(e->e==1).count();
    }

    public int numberOfBeams(String[] bank) {
        int total = 0;
        List<Integer> list = Arrays.stream(bank)
                .map(e->numberOfOnes(e)).filter(e->e!=0).collect(Collectors.toList());
        for(int i=0;i<list.size()-1;i++){
            total = total + (list.get(i)* list.get(i+1));
        }
        return total;
    }

    public static void main(String[] args){
        System.out.println(new LaserBeamsInABank().numberOfBeams(new String[]{"011001","000000","010100","001000"}));
    }
}
