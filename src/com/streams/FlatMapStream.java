package com.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapStream {
     @Data
     @NoArgsConstructor
     @AllArgsConstructor
     static class Employee{
            private String name;
            private String Designation;
            private Double salary;
            private List<Address> address;
        }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Address {

         private String addressLine1;
         private Long pincode;
    }

    private static List<Employee> getAll(){
        List<Employee> collect = Stream.of(
                new Employee("shareef", "AVP", 0300.00d, Arrays.asList(new Address("eluru", 534003l), new Address("Vijayawada", 534001l))),
                new Employee("munneer", "VP", 200.00d, Arrays.asList(new Address("Hyderabad", 534005l), new Address("kadapa", 534002l))),
                new Employee("mahammad", "ass", 410.030d, Arrays.asList(new Address("vuyuru", 534006l), new Address("visakhapatnam", 534007l)))
        ).collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = FlatMapStream.getAll();

        List<List<Address>> map = employeeList.stream().map(emp -> emp.getAddress()).collect(Collectors.toList());
        System.out.println(map);

        List<Address> flatMap = employeeList.stream().flatMap(emp -> emp.getAddress().stream()).collect(Collectors.toList());
        System.out.println(flatMap);
    }
}
