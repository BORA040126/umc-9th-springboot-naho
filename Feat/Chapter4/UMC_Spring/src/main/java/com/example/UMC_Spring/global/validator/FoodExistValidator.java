package com.example.UMC_Spring.global.validator;

import com.example.UMC_Spring.domain.member.exception.code.FoodErrorCode;
import com.example.UMC_Spring.domain.member.repository.FoodRepo;
import com.example.UMC_Spring.global.annotation.ExistFoods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodExistValidator implements ConstraintValidator<ExistFoods, List<Long>> {

    private final FoodRepo foodRepo;
    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(foodRepo::existsById);
        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(FoodErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();

        }
        return isValid;
    }
}
