package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Student[] students = IntStream.range(0, 5).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        Project[] projects = IntStream.range(0, 3).mapToObj(i -> new Project("P" + i)).toArray(Project[]::new);

        students[0].setProjects(Arrays.asList(projects[0], projects[1], projects[2]));
        students[1].setProjects(Arrays.asList(projects[0], projects[1]));
        students[2].setProjects(Arrays.asList(projects[0], projects[2]));
        students[3].setName("Mara");
        students[3].setProjects(Arrays.asList(projects[1], projects[2]));
        students[4].setName("Teodora");
        students[4].setProjects(Arrays.asList(projects[0], projects[1]));

        System.out.println("Students:");
        for (Student s : students)
            System.out.println(s);

        List<Student> listOfStudents = new LinkedList<>();
        listOfStudents.addAll(Arrays.asList(students));//sau lisOfStudents.add(S0);lisOfStudents.add(S1); etc.
        System.out.println("Sorted list of students:");

        List<Student> newSortedList = listOfStudents.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());

        for (Student s : newSortedList)
            System.out.println(s);

        //Aceasta colectie isi pastreaza elementele sortate
        Set<Project> setOfProjects = new TreeSet<>();
        setOfProjects.addAll(Arrays.asList(projects));
        System.out.println("Sorted set of projects:");
        for (Project p : setOfProjects) {
            System.out.println(p);
        }
    }
}

