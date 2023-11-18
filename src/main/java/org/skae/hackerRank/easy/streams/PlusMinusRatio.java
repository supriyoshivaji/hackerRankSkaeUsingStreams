package org.skae.hackerRank.easy.streams;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlusMinusRatio {

    public static void plusMinus(List<Integer> arr) {

        // Write your code here
        //.forEach((k,v)-> System.out.println(k+":"+v))
        /*.forEach((integer, aLong) -> {
                   System.out.println(Double.valueOf(aLong)/Double.valueOf(arr.size()) );
                }) */
        DecimalFormat decfor = new DecimalFormat("0.000000");

        Map<Integer, Long> mapper = Stream.iterate(0, i -> i < arr.size(), i -> i + 1)
                //.limit(arr.size())
                .map(arr::get)
                .collect(Collectors.groupingBy(integer -> Integer.compare(integer, 0), Collectors.counting()));

        System.out.println(decfor.format(Double.valueOf(Optional.ofNullable(mapper.get(1)).orElse(0L))/Double.valueOf(arr.size()))  );
        System.out.println(decfor.format(Double.valueOf(Optional.ofNullable(mapper.get(-1)).orElse(0L))/Double.valueOf(arr.size()))  );
        System.out.println(decfor.format(Double.valueOf(Optional.ofNullable(mapper.get(0)).orElse(0L))/Double.valueOf(arr.size()))  );
    }

    public static void main(String[] args) {

        List<Integer> arr= Arrays.asList(1,1,1,0,-1,-1);
        List<Integer> arr2= Arrays.asList(0, 100, 35, 0, 94, 40, 42, 87, 59, 0);

        plusMinus(arr);
        plusMinus(arr2);
    }
}
