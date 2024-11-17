package org.skae.hackerRank.easy.streams;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberLineJump {

	public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));
        System.out.println(kangaroo(4523, 8092, 9419, 8076));
        System.out.println(kangaroo(14, 4, 98, 2));
        System.out.println(kangaroo(2564, 5393, 5121, 2836));
    }


    /*public static String kangaroo(int x1, int v1, int x2, int v2) {
        int x = x1;
        int y = x2;
        while (x <= 10000 && y <= 10000 && x1<x2) {
            if (x == y) {
                return "YES";
            }
            x += v1;
            y += v2;
        }
        return "NO";


    }*/

     /*public static String kangaroo(int x1, int v1, int x2, int v2) {
         // Write your code here
         //some test cases are failing!

        AtomicInteger x = new AtomicInteger(x1);
        AtomicInteger y = new AtomicInteger(x2);

         Map<Integer, Integer> createdMap = Stream.iterate(0, integer -> integer + 1)
                 .limit(10000)
                 .map(integer -> {
                     x.set(x.get() + v1);
                     y.set(y.get() + v2);
                     return Map.entry(x.get(), y.get());
                 }).filter(integerIntegerEntry -> integerIntegerEntry.getKey().equals(integerIntegerEntry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
         System.out.println("Created Map:"+createdMap);

         return !createdMap.isEmpty()? "YES" : "NO";
    }*/

    /**
     *
     *
      There's programmatically no issue in the above code, however Hackerrank test case is
     going to be marked failed because of the answer isn't returned within desired time.
     The above program is looping 10000 times at any situation .
     Below is the mathematical approach
     First checks if velocities are equal - they'll only meet if starting at same position
     Uses math to calculate if they'll meet:

     If they meet at jump n: x1 + nv1 = x2 + nv2
     Solving for n: n = (x2 - x1)/(v1 - v2)


     The answer is "YES" if:

     First kangaroo is faster (v1 > v2)
     The number of jumps is non-negative
     The number of jumps is a whole number

     It more efficient ( Considering  O(1) vs O(n) )
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        return Stream.of(new int[]{x1, v1, x2, v2})
                .filter(arr -> v1 != v2) // filter out equal velocities case
                .mapToDouble(arr -> (double)(x2 - x1)/(v1 - v2)) // calculate jump number
                .filter(jumps -> jumps >= 0) // must be non-negative
                .filter(jumps -> jumps == (int)jumps) // must be whole number
                .filter(jumps -> v1 > v2) // first kangaroo must be faster
                .findFirst()
                .isPresent() ? "YES" :
                (v1 == v2 && x1 == x2) ? "YES" : "NO";
    }







}
