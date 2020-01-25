package com.psi.common;

import lombok.experimental.UtilityClass;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static java.text.MessageFormat.format;

@UtilityClass
public class CommonUtil {

    public static Supplier<? extends RuntimeException> noEntityFoundById(Long id, Class clazz) {
        return () -> new NoSuchElementException(format("No Entity: {0} found with id: {1}", clazz.getName(), id));
    }
}
