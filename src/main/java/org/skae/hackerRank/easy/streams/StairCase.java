package org.skae.hackerRank.easy.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StairCase {

    public static void staircase(int n) {
        // Write your code here

         Stream.iterate(n, i-> i >0 ,i -> i - 1)
                //.limit(n)
                //.forEach(System.out::println);
                .map(integer -> {
                    int limit=integer-1;
                    String spaces = Stream.iterate(0,i-> i< limit , i -> i + 1)
                            //.limit(integer)
                            .map(i -> " ")
                            .collect(Collectors.joining(""));
                    int limit2=n-limit;
                    String hash = Stream.iterate(0 , j-> j< limit2, j-> j + 1)
                            //.limit(integer)
                            .map(i -> "#")
                            .collect(Collectors.joining(""));
                    return spaces + hash;
                })
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int n = 6;
        staircase(n);
    }
}
