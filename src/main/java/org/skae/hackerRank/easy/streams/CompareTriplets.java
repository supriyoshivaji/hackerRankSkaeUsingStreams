package org.skae.hackerRank.easy.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareTriplets {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
       // a.stream().collect(Collectors.toMap())
        //List<Integer> result=new ArrayList<>(2);
       List<Integer> result=Arrays.asList(0,0);
       Stream.iterate(0,i -> i<3 ,i -> i+1)
               .map(index ->  {
                        switch (Integer.compare(a.get(index),b.get(index))){
                            case 0:
                                System.out.println("Do nothing for "+a.get(index)+":"+b.get(index));
                                break;
                            case -1:
                                System.out.println("A less than B for "+a.get(index)+":"+b.get(index));
                                result.set(1, result.get(1)+1) ;
                                break;
                            case 1:
                                System.out.println("A greater than B for "+a.get(index)+":"+b.get(index));
                                result.set(0, result.get(0)+1) ;
                                break;

                        }
                        return index;
                })
               .forEach(index -> {
                   //System.out.println("A :B = "+a.get(index)+":"+b.get(index));

               });
        ;
    return result;
    }

    public static void main(String[] args) {
        List<Integer> alex= Arrays.asList(5, 6 , 7);
        List<Integer> bob= Arrays.asList(3 , 6 , 10);
        List<?> result = compareTriplets(alex,bob);
        System.out.println("Result :: "+result);
    }
}
