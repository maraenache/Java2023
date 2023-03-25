package org.example.homework;

import java.util.Collections;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    Problem problem;
    public Solution(Problem problemToSolve) {

        this.problem=problemToSolve;
        problem.studentsList.sort(Student::compareTo);
        Collections.sort(problem.studentsList, Comparator.comparing(student -> student.getProjects().size()));

        System.out.println("\nStudents sorted by name and by the number of projects preferred ");
        System.out.println(problem.studentsList);
    }

    /**
     * Functia afiseza studentii si proiectele la care au fost repartizati
     * sub forma student -> proiect
     * am parcurs lista studentilor sortata crescator dupa numarul de preferinte
     si pentru fiecare student, parcurg lista proiectelor preferate, sortata dupa
     numarul de studenti ce prefera acel proiect
     daca gasesc un proiect care nu e luat project.getCapacity() != 0
     repartizez studentul la proiectul respectiv, si continui pentru fiecare student
     */
    void solve() {

        System.out.println("\nMaximum cardinality matching between students and projects:");
        for (Student student : problem.studentsList) {
            List<Project> sortedList = student.getProjects().stream().sorted(Comparator.comparing(project -> problem.getNumberOfApplicationProject(project)))
                    .collect(Collectors.toList());
            for (Project project : sortedList) {
                if (project.getCapacity() != 0) {
                    System.out.println(student.getName() + " -> " + project.getName());
                    project.setCapacity(0);
                    break;
                }
            }
        }
    }
}
