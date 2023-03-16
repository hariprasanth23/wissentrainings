package com.wissen.ProducerConsumer.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class MarketTypeValidator implements ConstraintValidator <ValidateMarketType,String>{
    @Override
    public boolean isValid(String marketType, ConstraintValidatorContext context) {
        List<String> marketTypeList = Arrays.asList("USA","Indian");
        return marketTypeList.contains(marketType);
    }
}
