package com.streams.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {
        List<Employee> employeeList = Data.getAllEmployees();

        System.out.println("----------Q1----------");
        //How many male and female employees are there in the organization?

        Map<String,Long> genderCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(genderCount);

        System.out.println("----------Q2----------");
        //Print the name of all departments in the organization?
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        System.out.println("----------Q3----------");
        //What is the average age of male and female employees?
        Map<String, Double> averageAgeForGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAgeForGender);

        System.out.println("----------Q4----------");
        // Get the details of highest paid employee in the organization?
        Optional<Employee> emp = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(emp);

        System.out.println("----------Q5----------");
        //Get the name of all the employees name and age who have joined after 2015
        List<String> employeesNames = employeeList.stream().filter(e -> e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());
        employeesNames.forEach(System.out::println);

        System.out.println("----------Q6----------");
        //Count the number of employees in each department?
        Map<String,Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        for (Map.Entry<String,Long> entry:
                map.entrySet()) {
            System.out.println(entry.getKey()+" --> "+entry.getValue());
        }

        System.out.println("----------Q7----------");
        //What is the average salary of each department
        Map<String,Double> averageSalaryOfDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        for (Map.Entry<String,Double> entry:
             averageSalaryOfDept.entrySet()) {
            System.out.println(entry.getKey()+" --> "+entry.getValue());
        }

        System.out.println("----------Q8----------");
        //get the youngest male employee from Product Development department
        Optional<Employee> youngestEmployee = employeeList.stream()
                                                          .filter(e -> e.getGender().equalsIgnoreCase("male") && e.getDepartment().equalsIgnoreCase("Product Development"))
                                                          .min(Comparator.comparingInt(Employee::getAge));
        System.out.println(youngestEmployee);
        Employee youngestEmployeeInProductDevelopmentDept = youngestEmployee.get();
        System.out.println(youngestEmployeeInProductDevelopmentDept.getName());

        System.out.println("----------Q9----------");
        //Who has the most working experience in the organization?
        //Optional<Employee> mostExperiencedEmployee = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
        //System.out.println(mostExperiencedEmployee);
        Optional<Employee> mostExperiencedEmployee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        System.out.println(mostExperiencedEmployee);

        System.out.println("----------Q10----------");
        //How many male and female employees are there in the sales and marketing team?
        Map<String,Long> count = employeeList.stream()
                                             .filter(e->e.getDepartment().equalsIgnoreCase("sales and marketing"))
                                             .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(count);

        System.out.println("----------Q11----------");
        //What is the average salary of male and female employees?
        Map<String,Double> averageSalaryOfGender = employeeList.stream()
                                                               .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryOfGender);

        System.out.println("----------Q12----------");
        //List down the names of all employees in each department?
        Map<String,List<Employee>> empList = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        for (Map.Entry<String,List<Employee>> entry:
             empList.entrySet()) {
            List<Employee> e = entry.getValue();
            for (Employee r:
                 e) {
                System.out.println(entry.getKey()+ " --> " +r.getName());
            }
        }

        System.out.println("----------Q13----------");
        //What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics summaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average salary : "+summaryStatistics.getAverage());
        System.out.println("Total salary : "+summaryStatistics.getSum());

        System.out.println("----------Q14----------");
        //Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Employee> oldestEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println(oldestEmp);

        System.out.println("----------Q15----------");
        //Divide the employees into 2 sets based on age greater the > 25
        Map<Boolean,List<Employee>> partitionMap = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge()>25));
        for (Map.Entry<Boolean,List<Employee>> entry:
             partitionMap.entrySet()) {
            List<Employee> em = entry.getValue();
            if (entry.getKey()){
                System.out.println("------True------");
                for (Employee r:
                     em) {
                    System.out.println(r);
                }
            }
            else{
                System.out.println("------False------");
                for (Employee r:
                        em) {
                    System.out.println(r);
                }
            }
        }



    }

}
