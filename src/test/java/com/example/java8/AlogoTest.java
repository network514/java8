package com.example.java8;

import com.example.java8.algorithm.Square;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlogoTest {

    @Test
    public void algorithm1() {
        Square square = new Square();
        square.method1(7);
    }
}