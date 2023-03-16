package gs;

public class reverseInteger {
    public int reverse(int x){
        int result = 0;
        while(x!=0){
            int tail = x%10;
            int newResult = tail + result*10;
            int lastResult = (newResult - tail)/10;
            if(lastResult!=result){
                return 0;
            }
            result = newResult;
            x=x/10;
        }
        return  result;
    }
    public static void main(String[] args){
        System.out.println(new reverseInteger().reverse(123));
    }
}
