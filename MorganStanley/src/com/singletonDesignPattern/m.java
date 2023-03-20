package com.singletonDesignPattern;


class A{
    public void xyz(){
        System.out.println(" Class A");
    }
}
public class m extends A{
    public static void main(String[] args){

        A a = new m();
        a.xyz();

    }

    public void xyz(){
        System.out.println(" Class B");
    }
}
