package com.example.UMC_Spring.global.resolver;


import java.lang.annotation.ElementType;
import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidPage {
}
