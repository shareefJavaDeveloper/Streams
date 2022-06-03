package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStream {

    static class Employee{
        private String name;
        private String designation;
        private Double salary;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Employee() {
        }

        public Employee(String name, String designation, Double salary) {
            this.name = name;
            this.designation = designation;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", designation='" + designation + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static List<Employee> getAll() {
        return Stream.of(
                new Employee("shareef","vp",123.000d),
                new Employee("munneer","AVP",122.00d),
                new Employee("mahammad","ass",1233.00d),
                new Employee("pinky","dir",400.00d)
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(13,131,432,357,56);
        List<Employee> emp = MapStream.getAll();
        //Map without lambda
        list.stream().filter(i->i%2!=0).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*10;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //Map with lambda
        list.stream().filter(i->i%2!=0).map(integer -> integer*10).forEach(System.out::println);

        //Employee Obj's
        List<Employee> mapemplist = emp.stream().filter(i -> i.getSalary() % 2 == 0).map(i -> {
            Employee mapEmp = new Employee();
             mapEmp.setDesignation(i.getDesignation() + " - AfterMap");
             mapEmp.setName(i.getName() + " - AfterMap");
             mapEmp.setSalary(i.getSalary());
             return mapEmp;
        }  ).collect(Collectors.toList());

        for (Employee s: mapemplist
             ) {
            System.out.println(s.toString());
        }
    }
}
