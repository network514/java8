package com.example.java8.lambda;

public class Outer {
    int val = 10;

    public class Inner {
        int val = 20;

        public void method(int i) { // void method(final int i)
            int val = 30; // final int val = 30;
            i = 10; // 에러. 상수의 값을 변경 할 수 없음.

            // System.out.println("             i : " + ++i);

            MyFunction2 f = () -> {
                // System.out.println("             i : " + i);
                System.out.println("           val : " + val);
                System.out.println("      this.val : " + ++this.val);
                System.out.println("Outer.this.val : " + ++Outer.this.val);
            };

            f.myMethod();
        }
    }
}
