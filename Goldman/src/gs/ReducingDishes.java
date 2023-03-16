package gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {

//        List<Integer> satisfactionList = Arrays.stream(satisfaction).boxed().filter(i->i>=-1).sorted().collect(Collectors.toList());
//        int result =0;
//        if(satisfactionList.contains(-1) && satisfactionList.size()==1){
//            return 0;
//        }
//
//
//        for(int satisfactionItem=0;satisfactionItem<satisfactionList.size();satisfactionItem++){
//            int temp = (satisfactionList.get(satisfactionItem)) * (satisfactionItem + 1) ;
//            result = result + temp;
//        }
//        System.out.println(satisfactionList);
//        System.out.println(result);
//
//        return 0;


//        Arrays.sort(satisfaction);
//        int result = 0;
//        int total =0;
//        int n= satisfaction.length;
//        for(int i=n-1; i>=0 && satisfaction[i] > -total; --i){
//            System.out.println("satisfaction-->"+satisfaction[i]);
//            total = total + satisfaction[i];
//            result = result + total ;
//            System.out.println("total-->"+total);
//            System.out.println("result-->"+result);
//        }
//
//        return result;

        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.sort(satisfaction);

        if(satisfaction[satisfaction.length-1]<0){
            return 0;
        }
        List<Integer> satisfactionList = Arrays.stream(satisfaction).boxed().collect(Collectors.toList());

        int result=0;
        int n= satisfaction.length;
        for(int i=0; i<n;i++){
            result = 0;
            int mul=1;
            List<Integer> sublist = satisfactionList.subList(i,n);
            for(int j=0;j< sublist.size();j++){
                int temp = sublist.get(j) * (mul);
                result = result + temp ;
                mul++;
            }
            arrayList.add(result);
        }
        System.out.println(arrayList);
        Collections.sort(arrayList);
        return arrayList.get(n-1);

    }
    public static void main(String[] args){

        System.out.println(new ReducingDishes().maxSatisfaction(new int[]{5,3,5,-2,3}));


    }
}
