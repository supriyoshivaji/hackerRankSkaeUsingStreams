package org.skae.hackerRank.easy.streams;

import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {



    public static void main(String[] args) {
        List<Integer> grades = List.of(73, 67, 38, 33);
        List<Integer> result = gradingStudents(grades);
        System.out.println(result);
    }


    public static List<Integer> gradingStudents(List<Integer> grades){

        return grades.stream()
                .map(grade -> (grade >= 38 && grade % 5 >= 3)?grade += 5 - (grade % 5):grade)
                .collect(Collectors.toList());
    }


    /**
     * public static List<Integer> gradingStudents(List<Integer> grades) {
        Map<Boolean, List<Integer>> mapOfList = grades.stream()
                    .collect(Collectors.partitioningBy(grade -> grade >= 38 && grade % 5 >= 3, Collectors.toList()));
        Stream<Integer> updatedStream = mapOfList.entrySet().stream()
                .filter(booleanListEntry -> booleanListEntry.getKey() == true)
                .flatMap(entry -> entry.getValue().stream()
                        .map(grade -> grade += 5 - (grade % 5))
                        .collect(Collectors.toList())
                        .stream());

        return Stream.concat(mapOfList.get(false).stream(), updatedStream)
                .collect(Collectors.toList());
    } */

}
