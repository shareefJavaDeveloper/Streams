package com.streams.exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise2 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings
                = Arrays.asList("Geek_First", "Geek_2",
                "Geek_3", "Geek_4","Geek_4","Geek_Magic",
                "Geek_Last");
        System.out.println("Q1 - How to sum all the stream integers");

        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        System.out.println("----------------------------------");
        System.out.println("Q2 - Find first element of stream");
        //stream.reduce((first, second) -> first).orElse(null);
        System.out.println(strings.stream().findFirst().orElse(null));

        System.out.println("----------------------------------");
        System.out.println("Q3 - Find last element of the stream");
        //String s1 = strings.stream().skip(strings.stream().count() - 1).findFirst().orElse(null);
        //System.out.println(s1);
        String s = strings.stream().reduce((first, second) -> second).orElse(null);
        System.out.println(s);

        System.out.println("----------------------------------");
        System.out.println("Q4 - How to find duplicate elements in a Stream in Java");
        System.out.println("--------Using Stream.frequency---------");
        Set<String> string = strings.stream().filter(i -> Collections.frequency(strings, i) > 1).collect(Collectors.toSet());
        System.out.println(string);
        System.out.println("--------Using Collectors.groupingBy()---------");
        Set<String> collect = strings.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting())).entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println("--------Using stream.add()---------");
        Set<String> set = new HashSet<>();
        Set<String> collect1 = strings.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
        System.out.println(collect1);

        System.out.println("----------------------------------");
        System.out.println("Q5 - Count occurrence of a given character in a string using Stream API in Java");
        System.out.println("--------Using Stream---------");
        String str = "shareef";
        char ch = 'e';
        long count = str.chars().filter(e -> e == ch).count();
        System.out.println(count);

        System.out.println("----------------------------------");
        System.out.println("Q6 - counting the STRING elements using Stream API in JAVA");
        System.out.println("--------Using Stream---------");
        String str1 = "Munneer";
        Stream<Character> charStream = str1.chars().mapToObj(i->(char) i);
        Map<Character, Long> countOfCharacters = charStream.collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        System.out.println(countOfCharacters);

        System.out.println("----------------------------------");
        System.out.println("Q7 - counting the NUMBER elements using Stream API in JAVA");
        System.out.println("--------Using Stream---------");
        Integer number = 345623;
        List<Integer> num_list = new ArrayList<>();

    }
}
