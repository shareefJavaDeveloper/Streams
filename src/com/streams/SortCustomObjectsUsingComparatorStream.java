package com.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortCustomObjectsUsingComparatorStream {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Employee{
        private String name;
        private String designation;
        private int age;
    }

    static class NameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class AgeComparator implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {
            if (o1.getAge()>o2.getAge()) return 1;
            else if (o1.getAge()<o2.getAge()) return -1;
            else return 0;
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
        List<Employee> empList = getAll();
        // We can use above classes as well
        List<Employee> collect = empList.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).collect(Collectors.toList());

        System.out.println(collect);

        System.out.println("---------");
        AgeComparator ageComparator = new AgeComparator();
        empList.sort(ageComparator);
        empList.forEach(System.out::println);

        System.out.println("--If wanna use both comparators at a time--");

        empList.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getDesignation).reversed());

        empList.forEach(System.out::println);
    }


}
