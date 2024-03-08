package org.skae.hackerRank.easy.streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BreakingTheRecords {
    public static void main(String[] args) {
        List<Integer> scores1 = List.of(10, 5, 20, 20, 4, 5, 2, 25, 1);
        List<Integer> result1 = breakingRecords(scores1);
        System.out.println(result1);
        List<Integer> scores2 = List.of(3,4,21, 36, 10, 28, 35, 5, 24, 42);
        List<Integer> result2 = breakingRecords(scores2);
        System.out.println(result2);
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        AtomicInteger maxCounter = new AtomicInteger(0);
        AtomicInteger minCounter = new AtomicInteger(0);
        scores.stream()
                .reduce(scores.get(0), (a, b) -> {
                    if(b>a){
                        maxCounter.set(maxCounter.get()+1);
                        return b;
                    }else {
                        return a;
                    }
                });
        scores.stream()
                .reduce(scores.get(0), (a, b) -> {
                    if(b<a){
                        minCounter.set(minCounter.get()+1);
                        return b;
                    }else {
                        return a;
                    }

                        });
        System.out.println("Max Counter :: "+maxCounter);
        System.out.println("Min Counter :: "+minCounter);
        return List.of(maxCounter.get(), minCounter.get());
    }
}
