package org.skae.hackerRank.easy.streams;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberLineJump {

	public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));
        System.out.println(kangaroo(4523, 8092, 9419, 8076));

    }


    /*public static String kangaroo(int x1, int v1, int x2, int v2) {
        int x = x1;
        int y = x2;
        while (x <= 10000 && y <= 10000 && x1<x2) {
            if (x == y) {
                return "YES";
            }
            x += v1;
            y += v2;
        }
        return "NO";


    }*/

     public static String kangaroo(int x1, int v1, int x2, int v2) {
         // Write your code here
         //some test cases are failing!

        AtomicInteger x = new AtomicInteger(x1);
        AtomicInteger y = new AtomicInteger(x2);

         Map<Integer, Integer> createdMap = Stream.iterate(0, integer -> integer + 1)
                 .limit(1000000)
                 .map(integer -> {
                     x.set(x.get() + v1);
                     y.set(y.get() + v2);
                     return Map.entry(x.get(), y.get());
                 }).filter(integerIntegerEntry -> integerIntegerEntry.getKey().equals(integerIntegerEntry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
         System.out.println("Created Map:"+createdMap);

         return !createdMap.isEmpty()? "YES" : "NO";
    }





}
