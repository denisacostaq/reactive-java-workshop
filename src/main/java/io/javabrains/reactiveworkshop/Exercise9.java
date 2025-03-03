package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        ReactiveSources.intNumbersFlux().doOnComplete(() -> System.out.println("Completed")).count().subscribe(System.out::println);

        // Collect all items of intNumbersFlux into a single list and print it
        ReactiveSources.intNumbersFlux().collectList().subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux().buffer(2, 1).map(l -> l.get(0) + l.get(1)).subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
