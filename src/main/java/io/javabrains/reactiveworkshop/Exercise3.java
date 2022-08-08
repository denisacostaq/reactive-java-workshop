package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        System.out.println("Get all numbers in the ReactiveSources.intNumbersFlux stream " +
                "into a List and print the list and its size");
        List<Integer> l = ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList());
        System.out.println(l);
        System.out.println(l.size());


//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
