package javatraining;

import java.util.function.Predicate;

public class JavaStreamFeatures {

    public static void main(String[] args){
        Predicate<Integer> greaterThan = (i) ->i>10;
        Predicate<Integer> lesserThan = (i)->i<20;

        boolean result1 = greaterThan.and(lesserThan).negate().test(15);
        System.out.println(result1);

        boolean result2 = greaterThan.or(lesserThan).test(255);
        System.out.println(result2);


    }
}
