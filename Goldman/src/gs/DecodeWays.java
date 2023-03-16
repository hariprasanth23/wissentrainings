package gs;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)=='0')return 0;
        if(s.length()==1) return 1;

        int count1=1,count2=1;
        for(int i=1;i<s.length();++i){
            int d = s.charAt(i)-'0';
            int dd= (s.charAt(i-1)-'0')*10+d;
            System.out.println("d :"+d+" --- dd :"+dd);
            int count=0;
            if(d>0){
                count = count + count2;
            }
            System.out.println("if d>0 "+ count);
            if(dd>=10 && dd<=26){
                count = count+count1;
            }
            System.out.println("if d>10 "+count);
            System.out.println("count== "+count +" --- count 1 == "+ count1 +" --- count 2 =="+count2);
            count1 = count2;
            count2=count;
            System.out.println("count== "+count +" --- count 1 == "+ count1 +" --- count 2 =="+count2);

        }

        return count2;
    }

    public static void main(String[] args){

        System.out.println(new DecodeWays().numDecodings("1422311"));

    }
}
