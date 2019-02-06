package com.example.java8;

import com.example.java8.generics.Box;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenericsTest {

    @Test
    public  void boxTest() {
        Box<String> b = new Box<>();
        // 타입 T 대신, 실제 타입을 지정
        // b.setItem(new Object());
        // 에러. String 이외의 타입은 지정 불가
        b.setItem("ABC");
        String item = (String) b.getItem();
        String item2 = b.getItem();
        // 형변환이 필요엾음

        Box b2 = new Box();
        b2.setItem("ABC");
        String item3 = (String) b2.getItem();
        b2.setItem(new Object());

        Box<Object> b3 = new Box<>();
        b3.setItem("ABC");
        b3.setItem(new Object());

    }
}
