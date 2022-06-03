package com.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortStream {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("shareef","ramu","janu","spandu","love","jinni","malak","volvo");
        List<Integer> numbers = Arrays.asList(2,1,5,6,3,4,7,9,8);

        //using sorted
        /**
         * sorted() is a stateful intermediate operation which returns a new Stream.
         * It returns a stream consisting of the elements of this stream, sorted according to natural order.
         * If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.
         * For ordered streams, the sort is stable.
         * For unordered streams, no stability guarantees are made.
         */
        System.out.println("------Using sorted method-----");
        List<String> sorted = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
        List<Integer> numbersSorted = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(numbersSorted);

        //using sorted(Comparator)

        /**
         * This is a stateful intermediate operation which returns a new stream.
         * It returns a stream consisting of the elements of this stream, sorted according to the provided Comparator..
         * For ordered streams, the sort is stable.
         * For unordered streams, no stability guarantees are made.
         */
        System.out.println("------Using sorted(Comparator) method-----");
        List<String> collect = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> collect1 = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
