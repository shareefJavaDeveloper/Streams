package com.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiscMethodsInStream {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Employee {
        private String name;
        private String Designation;
        private int age;
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
        AgeComparator ageComparator = new AgeComparator();
        List<Employee> empList = getAll();
        
        List<Integer> numbers = Arrays.asList(121,345,230,378,420,256);
        List<String> firstNames = Arrays.asList("munneer","sameena","sohail","shoibe");
        List<String> lastNames = Arrays.asList("Shareef","sameena","khan","patan");

        //AnyMatch
        boolean anyMatch = numbers.stream().anyMatch(num -> num%2!=0);
        System.out.println(anyMatch+ " - Any Match");

        //AllMatch
        boolean allMatch = numbers.stream().allMatch(num -> num % 2 == 0);
        System.out.println(allMatch + " - All Match");

        //concat
        List<String> concat = Stream.concat(firstNames.stream(), lastNames.stream()).collect(Collectors.toList());
        System.out.println(concat);

        //distinct
        List<String> distinct = concat.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);

        //count
        long count = numbers.stream().filter(num -> num % 2 == 0).count();
        System.out.println(count);

        //empty
        //To produce an empty string on-demand
        Stream<Object> empty = Stream.empty();

        //findAny
        /**
         * findAny() is a terminal-short-circuiting operation of Stream interface.
         * This method returns any first element satisfying the intermediate operations.
         * This is a short-circuit operation because it just needs ‘any’ first element to be returned and terminate the rest of the iteration.
         * The behavior of Stream findAny() operation is explicitly non-deterministic i.e, it is free to select any element in the stream.
         * Multiple invocations on the same source may not return the same result.
         */
        Optional<Employee> findAny = empList.stream().filter(emp -> emp.getName().equalsIgnoreCase("shareef")).findAny();
        System.out.println(findAny);

        //findFirst
        /**
         * The findFirst() method finds the first element in a Stream.
         * So, we use this method when we specifically want the first element from a sequence.
         * When there is no encounter order, it returns any element from the Stream.
         * According to the java.util.streams package documentation, “Streams may or may not have a defined encounter order.
         * It depends on the source and the intermediate operations.”
         */
        Optional<Employee> first = empList.stream().filter(emp -> emp.getName() != "shareef").findFirst();
        System.out.println(first);

        //generate and limit
        List<Double> limit = Stream.generate(new Random()::nextDouble).limit(5).collect(Collectors.toList());
        System.out.println(limit);

        //iterate
        /**
         * This is enhanced in JAVA9 to add the predicate itself without adding
         */
        Stream.iterate(10,n -> n*10).limit(10).forEach(n-> System.out.print(n+" "));

        //max
        System.out.println();
        Optional<Employee> max = empList.stream().max(ageComparator);
        System.out.println(max);

        //min
        Optional<Employee> min = empList.stream().min(ageComparator);
        System.out.println(min);

        //noneMatch
        boolean noneMatch = numbers.stream().noneMatch(x -> x.equals(2));
        System.out.println(noneMatch); //none of the element matches with 2 so, returns true.

        empList.stream().peek(u->u.setName(u.getName().toUpperCase())).forEach(System.out::println);
    }

}
