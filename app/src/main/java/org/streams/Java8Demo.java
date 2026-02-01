package org.streams;

import com.google.common.base.Function;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Hello World!"));
        t1.start();

        Math addition = (a, b) -> a+b;
        System.out.println(addition.operation(1,2));

        //Predicate -> Functional interface, function that takes one input and returns a boolean.
        System.out.println("\n-----------Predicate-----------");
        Predicate<Integer> isEven = x -> x%2 == 0;

        Predicate<String> isWordStartsWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndsWithA = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = isWordStartsWithA.and(isWordEndsWithA);
        System.out.println(and.test("Ankit"));

        // Functions
        System.out.println("\n-----------Functions-----------");
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 2 * x;

        System.out.println(doubleIt.andThen(tripleIt).apply(20));

        //Consumer
        System.out.println("\n-----------Consumer-----------");
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(51);

        //Supplier
        System.out.println("\n-----------Supplier-----------");
        Supplier<String> giveHelloWorld = () -> "Hello World!";
        System.out.println(giveHelloWorld.get());
    }
}

@FunctionalInterface
interface Math {
    int operation(int a, int b);
}

//class Task implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Hello World!");
//    }
//}