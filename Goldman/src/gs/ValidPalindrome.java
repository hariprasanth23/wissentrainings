package gs;

public class ValidPalindrome {
    public boolean isvalidpalindrome(String palindromeString){

        String temp = palindromeString.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        StringBuilder sb1= new StringBuilder();
        sb1.append(temp).reverse();

        return (temp.equals(sb1.toString()));
    }

    public static void main(String[] args){
        System.out.println(new ValidPalindrome().isvalidpalindrome("A man, a plan, a canal: Panama"));
    }
}
