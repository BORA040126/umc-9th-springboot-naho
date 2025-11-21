package com.example.UMC_Spring.global.annotation;

import com.example.UMC_Spring.global.validator.FoodExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = FoodExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER})
public @interface ExistFoods {
    String message() default "해당 음식이 존재하지 않습니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
