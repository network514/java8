package com.example.java8;

import com.example.java8.lambda.Example;
import com.example.java8.lambda.MyFunction;
import com.example.java8.lambda.MyFunction2;
import com.example.java8.lambda.MyFunction3;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };
    }

    @Test
    public void lambdaExpresstion3() {
        MyFunction myFunction = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int big = myFunction.max(5, 3);
    }

    @Test
    public void lambdaExpresstion4() {
        List<String> list1 = Arrays.asList("abc","def","ghi","jkl","abc");
        Collections.sort(list1, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        List<String> list2 = Arrays.asList("abc","def","ghi","jkl","abc");
        Collections.sort(list2, (s1, s2) -> s2.compareTo(s1));
    }

    @Test
    public void lambdaExpresstion5() {
        MyFunction2 f = () -> System.out.printf("myMehod()"); // 람다식을 매개변수로 지정
        aMethod(f);
    }

    void aMethod(MyFunction2 f) {
        f.myMethod();
    }

    @Test
    public void lambdaExpresstion6() {
        // 람다식으로 MyFunction3의 run을 구현
        MyFunction3 f1 = () -> System.out.println("f1.run");

        MyFunction3 f2 = new MyFunction3() {
            @Override
            public void run() { // public을 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };

        Example ex = new Example();

        MyFunction3 f3 = ex.getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        ex.execute(f1);
        ex.execute(() -> System.out.println("run ()"));

    }

}
