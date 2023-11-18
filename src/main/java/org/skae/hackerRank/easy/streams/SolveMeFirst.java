package org.skae.hackerRank.easy.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolveMeFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfInput = Arrays.asList(1,2);
        Integer reducedSummation = listOfInput.stream()
                .map(inputInt -> {
                    System.out.println("Integer "+inputInt+" :");
                    return Integer.parseInt(scanner.nextLine());
                }).filter(intNumber -> intNumber >= 1 && intNumber <=1000)
                .reduce(0, Integer::sum)
                ;
        System.out.println("Ouput : "+reducedSummation);
    }
}
