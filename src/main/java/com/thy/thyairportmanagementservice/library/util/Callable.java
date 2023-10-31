package com.thy.thyairportmanagementservice.library.util;

@FunctionalInterface
public interface Callable<T, R> {

    T call(R r);
}
