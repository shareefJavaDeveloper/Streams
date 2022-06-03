package com.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortCustomObjectsUsingComparableStream {

    /**
     * Sort by using comparable interface
     */

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Employee implements  Comparable<Employee>{
        private String name;
        private String designation;
        private int age;

        @Override
        public int compareTo(Employee o) {
            if (age==o.getAge()) return 0;
            else if (age>o.getAge()) return 1;
            else return -1;
        }
    }

    private static List<Employee> getAll(){
        List<Employee> collect = Stream.of(
                new Employee("shareef", "AVP", 24),
                new Employee("munneer", "AVP", 23),
                new Employee("mahammad", "VP", 32),
                new Employee("shareef", "trp", 24)
        ).collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        List<Employee> empList = SortCustomObjectsUsingComparableStream.getAll();
        /**
         * If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.
         * so, below line will not work
         * In these cases need to work with comparable interface(implement).
         */
        //List<Employee> collect = empList.stream().sorted().collect(Collectors.toList());

        List<Employee> collect = empList.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
    }

}
