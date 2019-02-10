package com.example.java8;

import com.example.java8.lambda.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

@SpringBootTest
public class LambdaTest {

    @Test
    public void lambdaExpression() {
        int[] arr = new int[5];
        Arrays.setAll(arr, (i) -> (int) (Math.random() * 5) + 1);

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
    public void lambda3() {
        MyFunction myFunction = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int big = myFunction.max(5, 3);
    }

    @Test
    public void lambda4() {
        List<String> list1 = Arrays.asList("abc", "def", "ghi", "jkl", "abc");
        Collections.sort(list1, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        List<String> list2 = Arrays.asList("abc", "def", "ghi", "jkl", "abc");
        Collections.sort(list2, (s1, s2) -> s2.compareTo(s1));
    }

    @Test
    public void lambda5() {
        MyFunction2 f = () -> System.out.printf("myMehod()"); // 람다식을 매개변수로 지정
        aMethod(f);
    }

    void aMethod(MyFunction2 f) {
        f.myMethod();
    }

    @Test
    public void lambda6() {
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

    @Test
    public void lambda7() {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }

    /*
    Runnable
    매개변수도 없고, 반환값도 없음.
    */
    @Test
    public void lambda8() {
        Runnable runnable = () -> {
            System.out.println("호우호우호우!");
        };

        runnable.run();
    }

    /*
    Supplier<T>
    매개변수는 없고, 반환값만 있음.
     */
    @Test
    public void lambd9() {
        Supplier<String> returnStr = () -> "호이호이 둘리는 초능력 내친구";
        System.out.println(returnStr.get());
    }

    /*
    Consumer<T>
    매개변수만 있고, 반환값이 없음.
     */
    @Test
    public void lambd10() {
        Consumer<String> consumer = (param) -> System.out.println("휘~파람 휘 : " + param);
        consumer.accept("파람 파람파람");
    }

    /*
    Function<T>
    일반적인 함수. 하나의 매개변수를 받아서 결과를 반환.
     */
    @Test
    public void lambd11() {
        Function<String, Integer> function = (param) -> param.length();
        int i = function.apply("휘파람~");
        System.out.println("문자열 길이 : " + i);
    }


    /*
    Predicate<T>
    조건식을 표현하는데 사용 됨.
    매개변수는 하나, 반환 타입은 boolean
     */
    @Test
    public void lambda12() {
        Predicate<String> isEmptyStr = s -> s.length() == 0;
        String s = "";

        if (isEmptyStr.test(s)) { // if(s.length()==0)
            System.out.println("This is an empty String.");
        }
    }

    // Bi 매개변수의 개수가 2개인 함수형 인터페이스 이름 앞에 접두가 'Bi'가 붙는다.

    /*
    BiConsumer<T,U>
    두개의 매개변수만 있고, 반환값이 없음.
     */
    @Test
    public void lambda13() {
        BiConsumer<Integer, String> consumer = (number, str) -> System.out.println(number + ". 문자열 : " + str);
        consumer.accept(1, "호우호우호우~");
    }

    /*
    BiPredicate<T,U>
    조건식을 표현하는데 사용됨.
    매개변수는 둘, 반환값은 boolean
     */
    @Test
    public void lambda14() {
        BiPredicate<Integer, Integer> predicate = (number1, number2) -> number1 != number2;
        if (predicate.test(1, 3)) {
            System.out.println("실행!!");
        }
    }

    /*
    BiFunction<T,U,R>
    두 개의 매개변수를 받아서 하나의 결과를 반환.
     */
    @Test
    public void lambda15() {
        BiFunction<Integer, Integer, Integer> function = (number1, number2) -> number1 * number2;
        System.out.println("곱한 결과 : " + function.apply(2, 3));
    }

    /*
    TriFunction<T,U,V,R>
    Custom interface
    세 개의 매개변수를 받아서 하나의 결과를 반환.
    */
    @Test
    public void lambda16() {
        TriFunction<Double, Integer, Integer, Double> function = (number1, number2, number3) -> number1 * number2 / number3;
        System.out.println("결과 값 : " + function.apply(1.0, 2, 3));
    }
}