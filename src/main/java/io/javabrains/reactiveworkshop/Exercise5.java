package io.javabrains.reactiveworkshop;

import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;
import java.util.function.Consumer;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        System.out.println("Subscribe to a flux using the error and completion hooks");
        ReactiveSources.intNumberMono().subscribe(
                System.out::println,
                err -> System.err.println(err.getMessage()),
                () -> System.out.println("Done"));

        System.out.println("Subscribe to a flux using an implementation of BaseSubscriber");
        ReactiveSources.userMono().subscribe(
                (User user) -> System.out.println(user.getFirstName()),
                err -> System.err.println(err.getMessage()),
                () -> System.out.println("Done"));

        System.out.println("Press a key to end");
        System.in.read();
    }

}