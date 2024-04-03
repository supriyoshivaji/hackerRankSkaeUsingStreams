package org.skae.hackerRank.easy.streams;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MigratoryBirds {
    public static void main(String args[]){
        List<Integer> arr = List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
        int variant = migratoryBirds(arr);
        System.out.println(variant);
    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here

        /*Map<Object, Object> asd = arr.stream().sorted().distinct()
                .map(integer -> {
                    Long count = arr.stream().filter(integer1 -> integer1.equals(integer)).count();
                    return new Object[]{integer, count};
                })
                .collect(Collectors.toMap(objects -> Integer.valueOf(objects[0].toString()), objects -> Integer.valueOf(objects[1].toString())));
        System.out.println(asd);*/

        Optional<Map.Entry<Integer, Integer>> qwe = arr.stream().sorted().distinct()
                .map(integer -> {
                    Long count = arr.stream().filter(integer1 -> integer1.equals(integer)).count();
                    return new Object[]{integer, count};
                })
                .collect(Collectors.collectingAndThen(
                                Collectors.toMap(objects -> Integer.valueOf(objects[0].toString()), objects -> Integer.valueOf(objects[1].toString())),
                                integerIntegerMap -> {
                                    return integerIntegerMap.entrySet().stream()
                                            .reduce((integerIntegerEntry, integerIntegerEntry2) -> {
                                                if (integerIntegerEntry2.getValue() > integerIntegerEntry.getValue()) {
                                                    return integerIntegerEntry2;
                                                } else if (integerIntegerEntry2.getValue() == integerIntegerEntry.getValue()) {
                                                    return integerIntegerEntry2.getKey() < integerIntegerEntry.getKey() ? integerIntegerEntry2 : integerIntegerEntry;
                                                } else {
                                                    return integerIntegerEntry;
                                                }
                                            });

                                }
                        )
                );
        System.out.println(qwe.get());
        //return 0;
        return qwe.get().getKey();
    }
}
