package org.skae.hackerRank.easy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VeryBigSum {

    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        //return ar.stream().reduce(0L,(aLong, aLong2) -> aLong+aLong2) ;
        return ar.stream().collect(Collectors.summingLong(value -> value));
        //Both the above will work
    }

    public static void main(String[] args) {
        List<Long> listOfLongInputs = Arrays.asList(Long.valueOf(1000000001)   ,Long.valueOf(1000000002)   ,Long.valueOf(1000000003)   ,Long.valueOf(1000000004)   ,Long.valueOf(1000000005)  );
        System.out.println("Summation of Long List : "+aVeryBigSum(listOfLongInputs));
    }
}
