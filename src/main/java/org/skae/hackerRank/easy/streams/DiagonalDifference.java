package org.skae.hackerRank.easy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiagonalDifference {

    /*public static int diagonalDifference(List<List<Integer>> arr) {
        int diag1=Stream.iterate(0,i -> i < arr.size(),i -> i+1 )
                .map(index -> {
                    return arr.get(index).get(index);
                })
                .collect(Collectors.summingInt(value -> value)) ;
        int diag2=Stream.iterate(arr.size()-1, j-> j >=0, j-> j-1)
                .map(index -> {
                    return arr.get(index).get(arr.size()-1-index);
                })
                .collect(Collectors.summingInt(value -> value)) ;
        ;
        System.out.println("diag1:diag2="+diag1+":"+diag2);


        return diag1-diag2;
    }*/
    public static int diagonalDifference(List<List<Integer>> arr) {
        int diag1=Stream.iterate(0,i -> i < arr.size(),i -> i+1 )
                .map(index -> {
                    return arr.get(index).get(index);
                })
                .collect(Collectors.summingInt(value -> value)) ;
        int diag2=Stream.iterate(arr.size()-1, j-> j >=0, j-> j-1)
                .map(index -> {
                    return arr.get(index).get(arr.size()-1-index);
                })
                .collect(Collectors.summingInt(value -> value)) ;
        ;
        System.out.println("diag1:diag2="+diag1+":"+diag2);


        return diag2>diag1?diag2-diag1:diag1-diag2;
    }

    public static void main(String[] args) {
//        List<Integer> row1= Arrays.asList(1, 2, 3);
//        List<Integer> row2= Arrays.asList(4, 5, 6);
//        List<Integer> row3= Arrays.asList(9 ,8 ,9 );
        List<Integer> row1= Arrays.asList(11, 2, 4);
        List<Integer> row2= Arrays.asList(4, 5, 6);
        List<Integer> row3= Arrays.asList(10 ,8 ,-12 );

        List<List<Integer>> listOfRows = Arrays.asList(row1,row2, row3);

        System.out.println("Diagonal Difference : "+diagonalDifference(listOfRows) );
    }
}
