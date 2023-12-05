package org.skae.hackerRank.easy.streams;

import java.util.List;

public class AppleAndOrange {
    public static void main(String[] args) {

countApplesAndOranges(7,10,4,12,List.of(2,3,-4),List.of(3,-2,-4));
    }


    /*public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int appleCount = 0;
        int orangeCount = 0;
        for (Integer apple : apples) {
            if (apple + a >= s && apple + a <= t) {
                appleCount++;
            }
        }
        for (Integer orange : oranges) {
            if (orange + b >= s && orange + b <= t) {
                orangeCount++;
            }
        }
        System.out.println(appleCount);

    }*/

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

        long countOfApples = apples.stream().map(integer -> a + integer)
                .filter(integer -> integer >= s && integer <= t)
                .count();
        long countOfOranges=oranges.stream().map(integer -> b+integer)
                .filter(integer -> integer>=s && integer<=t)
                .count();

        System.out.println(countOfApples);
        System.out.println(countOfOranges);

    }

    }
