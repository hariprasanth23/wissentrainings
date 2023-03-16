package gs;

import java.util.*;

public class UglyNumbersII {

    public int nthUglyNumber(int n) {
        if(n<=0){ return 0; }
        int twoFactor = 0 , threeFactor = 0 , fiveFactor = 0;
        List<Integer> factorList = new ArrayList<Integer>();
        factorList.add(1);

        while(factorList.size()<n){
            int minvalue = Math.min(factorList.get(twoFactor)*2,Math.min(factorList.get(threeFactor)*3,factorList.get(fiveFactor)*5));
            factorList.add(minvalue);
            if((factorList.get(twoFactor)*2) == minvalue){
                twoFactor++;
            }
            if((factorList.get(threeFactor)*3) == minvalue){
                threeFactor++;
            }
            if((factorList.get(fiveFactor)*5) == minvalue){
                fiveFactor++;
            }
        }

        return factorList.get(factorList.size()-1);

    }

    public static void main(String[] args){
        int n = 12;

        System.out.println(new UglyNumbersII().nthUglyNumber(n));
    }
}
