package com.arturfrimu.functionalprogramming.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Function takes 1 argument and produces 1 result
 * BiFunction takes 2 arguments and produces 1 result
 */
public class _Function {
    public static void main(String[] args) {
        System.out.println("\tFunction\n");
        int increment = incrementByOne(1);
        System.out.println(increment);

        int multiply = multiplyByTen(increment);
        System.out.println(multiply);

        int _increment = incrementByOneFunction.apply(1);
        System.out.println(_increment);

        int _multiply = multiplyByTenFunction.apply(_increment);
        System.out.println(_multiply);

        System.out.println("\n\tMETHOD CHAINING\n");

        int addAndMultiplied = addByOneAndMultiplyByTen.apply(1);
        System.out.println(addAndMultiplied);

        System.out.println("\n\tBiFunctions\n");

        int incrementAndMultiply = incrementByOneAndMultiply(1, 10);
        System.out.println(incrementAndMultiply);

        int _incrementAndMultiply = incrementByOneAndMultiplyFunction.apply(1, 10);
        System.out.println(_incrementAndMultiply);
    }

    static int incrementByOne(int number) {
        return number + 1;
    }

    static int multiplyByTen(int number) {
        return number * 10;
    }

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    // CHAINING 2 FUNCTIONS
    static Function<Integer, Integer> addByOneAndMultiplyByTen =
            incrementByOneFunction.andThen(multiplyByTenFunction);

    // BiFunctions
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction
            = (number, numToMultiplyBy) -> (number + 1) * numToMultiplyBy;

}
