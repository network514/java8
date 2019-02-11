package com.example.java8.algorithm;

public class Square {
    /*
    input = 7

    9 9 9 9 9 9 9
    9 9 0 0 0 9 9
    9 0 9 0 9 0 9
    9 0 0 9 0 0 9
    9 0 9 0 9 0 9
    9 9 0 0 0 9 9
    9 9 9 9 9 9 9

     */
    public int[][] method1(int input) {
        int[][] arr = new int[input][input];
        int inputArr = input-1;

        for(int i = 0 ; i < input ; i++) {
            for(int j = 0 ; j < input ; j++) {
                if(i==0 || i==inputArr || j==0 || j == inputArr) {
                    arr[i][j] = 9;
                } else if(i==j || inputArr-i==j) {
                    arr[i][j] = 9;
                } else {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

        return arr;
    }

    public int[][] method2(int input) {
        int[][] arr = new int[input][input];

        return arr;
    }
}
