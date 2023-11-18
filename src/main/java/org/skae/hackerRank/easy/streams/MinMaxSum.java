package org.skae.hackerRank.easy.streams;

import java.util.List;
import java.util.stream.Collectors;

public class MinMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        /**
         * Below code will give incorrect result for some test cases.
         *
        int minSum = arr.stream().sorted().limit(arr.size() - 1).mapToInt(value -> value).sum();
        int maxSum = arr.stream().sorted().skip(1).mapToInt(value -> value).sum();

        System.out.println(minSum + " " + maxSum);

        // Output: 1575456874 -1937029851
        */
        long minSumLong = arr.stream().sorted().limit(arr.size() - 1).mapToLong(value -> value).sum();
        long maxSumLong = arr.stream().sorted().skip(1).mapToLong(value -> value).sum();
        System.out.println(minSumLong + " " + maxSumLong);
    }
    public static void main(String[] args) {
        List<Integer> arr = List.of(3,4,1,2,5);
        miniMaxSum(arr);

        List<Integer> arr2 = List.of(140537896, 243908675, 670291834, 923018467, 520718469);
        miniMaxSum(arr2);
    }
}
