package org.skae.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovingZeros {
    public static void main (String[] args) {
        //System.out.println("Hello, World!");
        int [] intArray =  {0,2,4,0,4,2,2,0,0,4,5,0};
        int arraySize=intArray.length;
        int frontCounter=0;
        int backCounter=arraySize-1;
        int [] outputArray = new int[arraySize];



        for(int i=0; i<intArray.length ;i++){
            if(intArray[i]==0){
                outputArray[backCounter]=intArray[i];
                backCounter--;
            }else{
                outputArray[frontCounter]=intArray[i];
                frontCounter++;
            }
        }
        System.out.println("Method 1 :"+Arrays.toString(outputArray));

        List<Integer> integerList  = Arrays.asList(0, 2, 4, 0, 4, 2, 2, 0, 0, 4, 5, 0);
        List<Integer> outputList=Stream.concat(integerList.stream().filter(integer -> integer.intValue()!=0),
                integerList.stream().filter(integer -> integer.intValue()==0))
                .collect(Collectors.toList())
                ;
        System.out.println("Method 2: "+outputList.toString());


        outputList = integerList.stream()
                .map(Integer::intValue)
                .collect(Collectors.collectingAndThen(Collectors.partitioningBy(intValue -> intValue != 0, Collectors.toList()),
                        booleanListMap -> {
                             booleanListMap.get(true).addAll(booleanListMap.get(false));
                            return booleanListMap.get(true);
                        }));

        System.out.println("Method 3: "+outputList.toString());

        outputList = integerList.stream()
                .map(Integer::intValue)
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(intValue -> intValue == 0, Collectors.toList()),
                        booleanListMap -> {
                            return booleanListMap.entrySet()
                                    .stream()
                                    .flatMap(entry -> entry.getValue().stream())
                                    //.map(Map.Entry::getValue)
                                    .collect(Collectors.toList())
                                    ;
                        }));
        System.out.println("Method 4: "+outputList.toString());
    }
}
