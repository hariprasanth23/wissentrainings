package gs;

import java.util.*;

public class PartitionArrayToPivot {
    public int[] pivotArray(int[] arr, int pivot){

        ArrayList<Integer> arrayList = new ArrayList<>();
        int lessindex = 0 , equal = 0,equalIndex=0;
        for(int j : arr){
            if(j<pivot){
                arrayList.add(lessindex,j);
                lessindex++;
                equalIndex++;
            }else if(j==pivot){
                arrayList.add(equalIndex,j);
            }else{
                arrayList.add(j);
            }
        }
//        for(int i=0;i<equal;i++){
//            arrayList.add(lessindex,pivot);
//            lessindex++;
//        }

        int[] result = new int[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            result[i]=arrayList.get(i);
        }
        System.out.println(arrayList);


        return new int[]{};
    }
    public static void main(String[] args){
        int[] arr ={9,12,5,10,14,3,10};
        Arrays.stream(new PartitionArrayToPivot().pivotArray(arr,10)).forEach(System.out::println);
    }
}
