package org.skae.hackerRank.easy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class SimpleArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Count:");
        int inputCount=Integer.parseInt(scanner.nextLine());
        Integer reducedSummation = Stream.iterate(0,i -> i+1)
                .limit(inputCount)
                .mapToInt(inputInt -> {
                    System.out.println("Integer "+inputInt+" :");
                    return Integer.parseInt(scanner.nextLine());
                }).reduce(0,Integer::sum);

        System.out.println( reducedSummation);
    }
}
