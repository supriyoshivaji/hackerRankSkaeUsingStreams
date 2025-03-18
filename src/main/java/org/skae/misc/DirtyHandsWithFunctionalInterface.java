package org.skae.misc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DirtyHandsWithFunctionalInterface {

    public static void main(String[] args) {
        DirtyHandsWithFunctionalInterface d = new DirtyHandsWithFunctionalInterface();
        d.doSomething();

        List<String> list = Arrays.asList("a", "b", "c",null,"d","e");

        list.stream().filter(new CheckForNull())
                .forEach(System.out::println);

        list.stream().filter(checkForNull())
                .forEach(System.out::println);
    }
    public  static CheckForNull<String> checkForNull(){
            return new CheckForNull<String>();
    }



    public void doSomething() {
        System.out.println("doSomething");
    }

    public CheckForNull doSomethingElse() {
        System.out.println("doSomethingElse");
        return null;
    }

    public  static class CheckForNull<String> implements Predicate {

        @Override
        public boolean test(Object o) {
            System.out.println("Verifying Object ::"+o);

            return o != null;

        }
    }
}
