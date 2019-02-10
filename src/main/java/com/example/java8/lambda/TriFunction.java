package com.example.java8.lambda;

@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}
