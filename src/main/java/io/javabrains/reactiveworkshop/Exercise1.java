package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().forEach(System.out::println);

        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream().filter(n -> n < 5).forEach(System.out::println);

        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream().filter(n -> n > 5).skip(1).limit(2).forEach(System.out::println);

        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        System.out.println("If nothing is found, print -1");
        System.out.println(StreamSources.intNumbersStream().filter(n -> n > 5).findFirst().orElse(-1));

        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(System.out::println);

        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);
        StreamSources.intNumbersStream()
                .flatMap(integer -> StreamSources.userStream().filter(user -> user.getId() == integer))
                .forEach(System.out::println);
    }

}
