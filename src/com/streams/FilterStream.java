package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("shareef","munneer","mahammad","pinky");

        list.stream().filter(name -> !name.equals("pinky")).forEach(System.out::println);
    }
}
