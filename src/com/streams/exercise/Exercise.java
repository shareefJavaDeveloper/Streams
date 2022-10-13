package com.streams.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
     static class Student{
        private String studentName;
        private Integer RollNo;
        private Integer marks;
        private Integer rank;
    }

    static class NameComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getStudentName().compareTo(o2.getStudentName());
        }
    }

    static class MarksComparator implements  Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getMarks()>o2.getMarks()) return 1;
            else if (o1.getMarks()<o2.getMarks()) return -1;
            else return 0;
        }
    }


    private static List<Student> getAll(){

        List<Student> studentList = Stream
                                    .of(new Student("shareef",null,20,null)
                                            ,new Student("shareef",null,30,null)
                                            , new Student("munneer",2,10,null)
                                            , new Student("arun pawar",12 ,12, null)
                                    )
                                    .collect(Collectors.toList());

        return studentList;
    }

    public static void main(String[] args) {
        // Assume Roll number in passed list is null for all student object,
        // please assign roll  number on Alphbatical order of name ,
        // and if name is same then use marks student having higher marks will get lower roll number ;
        List<Student> students = getAll().stream().sorted(Comparator.comparing(Student::getStudentName).thenComparing(Student::getMarks)).collect(Collectors.toList());
        AtomicInteger i = new AtomicInteger(1);
        students.forEach(s -> s.setRollNo(i.getAndIncrement()));
        students.forEach(System.out::println);


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);

list.stream().collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));


        //  this method will give me Rank for all student on bais of marks,
        //  if marks are same use alphabital  ordering like amit
        //  and sumit have same marks then give amit as higher rank then sumit
    }



}
