package gs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix){

        int[][] result = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix.length;j++){
                result[j][i]=matrix[i][j];
            }
        }

        return result;
    }


    public static void main(String[] args){

        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        for(int[] sub: arr){
            System.out.println(Arrays.stream(sub).boxed().collect(Collectors.toList()));
        }
        System.out.println("===========================================================");

        int[][] result = new TransposeMatrix().transpose(arr);

        for(int[] sub: result){
            System.out.println(Arrays.stream(sub).boxed().collect(Collectors.toList()));
        }

    }
}
