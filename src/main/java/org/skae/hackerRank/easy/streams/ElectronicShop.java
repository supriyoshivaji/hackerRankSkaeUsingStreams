package org.skae.hackerRank.easy.streams;

import java.util.*;
import java.util.stream.Collectors;

public class ElectronicShop {

    public static void main(String[] args) {
        System.out.println(getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 10));
        System.out.println(getMoneySpent(new int[]{4}, new int[]{5}, 5));
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        Map<Integer, Integer> calculatedMap = Arrays.stream(keyboards)
                .mapToObj(keyboardVal -> {
                    OptionalInt maxDrivesVal = Arrays.stream(drives)
                            .filter(drivesVal -> drivesVal + keyboardVal <= b)
                            .distinct().max();
                    return new int[]{keyboardVal, maxDrivesVal.orElse(0)};
                })
                .filter(objects -> objects[1]  >0)
                .collect(Collectors.toMap(o ->  o[0] , o ->  o[1] ));
        System.out.println(calculatedMap);

        Optional<Map.Entry<Integer, Integer>> reducedMap = calculatedMap.entrySet().stream()
                .reduce((integerIntegerEntry, integerIntegerEntry2) -> {
                    int sumOfintegerIntegerEntry = integerIntegerEntry.getKey() + integerIntegerEntry.getValue();
                    int sumOfintegerIntegerEntry2 = integerIntegerEntry2.getKey() + integerIntegerEntry2.getValue();
                    return sumOfintegerIntegerEntry > sumOfintegerIntegerEntry2 ? integerIntegerEntry : integerIntegerEntry2;
                });
        System.out.println(reducedMap);
        return reducedMap.map(integerIntegerEntry -> integerIntegerEntry.getKey()+integerIntegerEntry.getValue()).orElse(-1);

    }


}
