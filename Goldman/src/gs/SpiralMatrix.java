package gs;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if(matrix.length==0){
            return result;
        }

        int rowstart = 0;
        int rowend = matrix.length-1;
        int colstart = 0;
        int colend = matrix[0].length-1;

        while(rowstart <= rowend && colstart <= colend){

            for(int i=colstart; i <= colend;i++){
                result.add(matrix[rowstart][i]);
            }
            rowstart++;

            for(int i=rowstart ;i<= rowend ; i++){
                result.add(matrix[i][colend]);
            }
            colend--;

            if(rowstart<=rowend){
                for(int i=colend;i>=colstart;i--){
                    result.add(matrix[rowend][i]);
                }
            }
            rowend--;

            if(colstart<=colend){
                for(int i=rowend;i>=rowstart;i--){
                    result.add(matrix[i][colstart]);
                }
            }

            colstart++;

        }



        return result;
    }


    public static void main(String[] args){

        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        new SpiralMatrix().spiralOrder(arr).forEach(System.out::println);

    }
}
