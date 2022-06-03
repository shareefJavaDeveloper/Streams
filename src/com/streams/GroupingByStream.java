package com.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByStream {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Book{
        private String name;
        private String author;
        private int pageCount;
        private BigDecimal price;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Java","shareef",1200,new BigDecimal("100.00")),
                new Book("python","shareef",1100,new BigDecimal("120.00")),
                new Book("C","Munneer",1234,new BigDecimal("123.00")),
                new Book("Java","Mahammad",1400,new BigDecimal("145.00"))
        );

        Map<String, Long> collect = books.stream().collect(
                Collectors.groupingBy(Book::getAuthor, Collectors.counting())
        );

        System.out.println(collect);

        Map<String, Integer> collect1 = books.stream().collect(
                Collectors.groupingBy(Book::getName, Collectors.summingInt(Book::getPageCount)
                ));

        System.out.println(collect1);
    }
}
