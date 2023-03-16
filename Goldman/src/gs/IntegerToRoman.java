package gs;

public class IntegerToRoman {

    public String toRoman(int numberToRoman){

        int[] integer = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] roman={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();
        for(int i=integer.length-1; i>=0 && numberToRoman>0 ;i-- ){
            while(numberToRoman>=integer[i]){
                numberToRoman -= integer[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        int numberToRoman = 1994;

        System.out.println (new IntegerToRoman().toRoman(numberToRoman) );
    }
}
