package com.trial;

public class Outer {
    int i=5;
    static int j =6;
   class inner{
       public void methodOne() {
           System.out.println(i);
           System.out.println(j);
       }
   }
    public static void main(String[] args){
        new Outer().new inner().methodOne();
    }
}
