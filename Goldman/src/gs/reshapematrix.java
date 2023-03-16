package gs;

public class reshapematrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        if((rows*cols) != (r*c)){
            return mat;
        }

        int[][] result_matrix=new int[r][c];
        int result_row=0;
        int result_column=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                result_matrix[result_row][result_column] = mat[i][j];
                result_column++;

                if(result_column == c){
                    result_column = 0;
                    result_row++;
                }

            }
        }
        return result_matrix;
    }


    public static void main(String[] args){



    }
}
