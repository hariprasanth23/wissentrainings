package com.trial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {

    public static ImmutableClass instance;

//    private final int id;
//    private final List<String> brand;
//
//    ImmutableClass(int id, List<String> brand1){
//        this.id = id;
//        brand = new ArrayList<>();
//        for(String str: brand1){
//            brand.add(str);
//        }
//    }

    public ImmutableClass() {

    }


    public static ImmutableClass getInstance(){
        if(instance == null){
            return instance = new ImmutableClass();
        }else{
            return instance;
        }
    }

//    public List<String> getBrand() {
////        return Collections.unmodifiableList(brand);
//    }
}
