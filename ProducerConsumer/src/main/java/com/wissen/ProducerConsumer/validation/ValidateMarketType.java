package com.wissen.ProducerConsumer.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MarketTypeValidator.class)
public @interface ValidateMarketType {

    public String message() default "Invalid Market Type";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
