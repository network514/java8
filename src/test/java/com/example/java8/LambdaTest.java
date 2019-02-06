package com.example.java8;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class LambdaTest {

    @Test
    public void lambdaExpression() {
        int[] arr = new int[5];
        Arrays.setAll(arr, (i) -> (int) (Math.random()*5)+1);

        /*
        public int noLambdaExpression() {
            return (int) (Math.random()*5)+1;
        }
        */
    }

    @Test
    public void lambdaExpression2() {
        // (int a, int b) -> a > b ? a : b;

    }

}
