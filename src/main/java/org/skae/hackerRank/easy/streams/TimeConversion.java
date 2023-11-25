package org.skae.hackerRank.easy.streams;

import javax.management.StringValueExp;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringTokenizer;

public class TimeConversion {

    public static String timeConversion(String s) {
        // Write your code here

        return switch (s.substring(8,10)){
            case "AM" -> {
                yield s.substring(0,2).equals("12") ? "00" + s.substring(2,8) : s.substring(0,8);
            }
            case "PM" -> {
                Serializable hour = Arrays.stream(s.split(":")).findFirst()
                        .map(s1 -> {
                            return s1.equals("12") ? "12" : Integer.parseInt(s1) + 12;

                        }).get();
                yield hour + s.substring(2,8);
            }
            default -> throw new IllegalStateException("Unexpected value: " + s.substring(8, 10));
        };
    }

    public static void main(String[] args) {
        String sampleTime="12:01:00AM";
        String sampleTime2="03:11:16PM";
        String sampleTime3="12:01:00PM";
        System.out.println(timeConversion(sampleTime));
        System.out.println(timeConversion(sampleTime2));
        System.out.println(timeConversion(sampleTime3));
    }
}
