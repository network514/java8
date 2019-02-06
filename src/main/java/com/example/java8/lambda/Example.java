package com.example.java8.lambda;

public class Example {
    public static void execute(MyFunction3 f) { // 매개변수의 타입이 MyFuntion3인 메서드
        f.run();
    }

    public MyFunction3 getMyFunction() { // 반환 타입이 MyFunction인 매서드
        MyFunction3 f = () -> System.out.println("f3.run()");
        return f;
    }
}
