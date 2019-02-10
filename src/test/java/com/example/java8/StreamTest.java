package com.example.java8;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class StreamTest {

    /*
    Stream으로 정렬 전 코드
    */
    @Test
    public void streamTest1() {
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Arrays.sort(strArr);
        Collections.sort(strList);

        for(String str : strArr) System.out.println(str);
        for(String str : strList) System.out.println(str);
    }

    /*
    Stream으로 정렬 후 코드
     */
    @Test
    public void streamTest2() {
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Stream<String> strStream1 = strList.stream();       //스트림을 생성
        Stream<String> strStream2 = Arrays.stream(strArr);  //스트림을 생성

        strStream1.sorted().forEach(System.out::println);
        strStream2.sorted().forEach(System.out::println);
    }

    /*
    스트림은 데이터 소스를 변경하지 않음.
    읽기만 함.
    */
    @Test
    public void streamTest3() {

        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Stream<String> strStream1 = strList.stream();       //스트림을 생성
        Stream<String> strStream2 = Arrays.stream(strArr);  //스트림을 생성

        // 정렬된 결과를 새로운 List에 담아서 반환한다.
        List<String> sortedList = strStream2.sorted().collect(Collectors.toList());
    }

    /*
    */
    @Test
    public void streamTest4() {}

    /*
     */
    @Test
    public void streamTest5() {}

    /*
     */
    @Test
    public void streamTest6() {}

    /*
     */
    @Test
    public void streamTest7() {}

    /*
     */
    @Test
    public void streamTest8() {}

    /*
     */
    @Test
    public void streamTest9() {}

    /*
     */
    @Test
    public void streamTest10() {}

    /*
     */
    @Test
    public void streamTest11() {}

    /*
     */
    @Test
    public void streamTest12() {}

    /*
     */
    @Test
    public void streamTest13() {}

    /*
     */
    @Test
    public void streamTest14() {}

    /*
     */
    @Test
    public void streamTest15() {}
}