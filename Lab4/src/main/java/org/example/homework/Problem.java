package org.example.homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Problem {
    protected List<Student> studentsList = new LinkedList<>();
    protected Set<Project> projectsList = new TreeSet<>();
    protected Map<Student, List<Project>> studentsPreferences = new HashMap<>();

    /**
     * in constructorul default construiesc o instanta a problemei
     * in care numele proiectelor si studentilor sunt introduse de mine, precum si preferintele acestora
     */
    public Problem() {
        Student[] students = IntStream.range(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        Project[] projects = IntStream.range(0, 3)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        students[0].setProjects(Arrays.asList(projects[0], projects[1], projects[2]));
        students[1].setProjects(Arrays.asList(projects[0], projects[1]));
        students[2].setProjects(Arrays.asList(projects[0]));

        studentsList.addAll(Arrays.asList(students));
        projectsList.addAll(Arrays.asList(projects));

        for (Student student : studentsList) {
            studentsPreferences.put(student, student.getProjects());
        }
    }

    /**
     * in acest constructor proiectele si studentii sunt generate random
     * precum si preferintele studentilor
     *
     * Am apelat constructorii default la crearea unui nou student, respectiv proiect
     * acestia generand nume random
     * Dupa pentru fiecare student am creat o lista de preferinte, proiecte preferate astfel
     * Am parcurs lista de proiecte si am generat un numar cuprins intre 0 si 1,
     * daca acesta era mai mic decat 0.5, il adaug in lista proiectelor
     * Daca la sfarsit nu am nicio preferinta, generez un proiect random si il adaug in lista
     * pentru ca fiecare student sa aiba minim un proiect la care poate merge
     * @param numberOfStudents-numarul de studenti din problema
     * @param numberOfProjects-numarul de proiecte din problema
     */
    public Problem(int numberOfStudents, int numberOfProjects) {
        Faker faker = new Faker();
        Student[] students = IntStream.rangeClosed(0, numberOfStudents - 1)
                .mapToObj(i -> new Student())
                .toArray(Student[]::new);
        Project[] projects = IntStream.rangeClosed(0, numberOfProjects - 1)
                .mapToObj(i -> new Project())
                .toArray(Project[]::new);

        studentsList.addAll(Arrays.asList(students));
        projectsList.addAll(Arrays.asList(projects));

        for (Student student : students) {
            List<Project> pref = new ArrayList<>();
            for (Project project : projects)
                if (faker.random().nextDouble() < 0.5)
                    pref.add(project);

            if (pref.size() == 0) {
                int randomProject = new Faker().random().nextInt(0, numberOfProjects);
                student.setProjects(Arrays.asList(projects[randomProject]));
            } else {
                student.setProjects(pref);
            }
        }
        for (Student student : students)
            studentsPreferences.put(student, student.getProjects());
    }

    /**
     * numarul de proiecte preferate de studentul s este de fapt lungimea listei de proiecte preferate
     *
     * @param s-studentul caruia vrem sa ii aflam numarul de preferinte
     * @return-numarul de proiecte preferate de studentul s
     */
    int getNumberOfPreferences(Student s) {
        return s.getProjects().size();
    }

    /**
     * Am calculat media numarului de preferinte ale fiecarui student, folosind getNumberOfPreferences
     * care de fapt face size de numarul de proiecte preferate
     * si am facut media folosind functia average a stream ului
     * dupa am filtrat studentii care au numarul de preferinte sub medie
     */
    void studentsLowerAVG() {
        double average = studentsList.stream()
                .mapToInt(s -> s.getProjects().size())
                .average()
                .getAsDouble();

        System.out.println("\nThe students with the number of preferences lower than the average (" + average + " )");
        studentsList.stream().filter(student -> getNumberOfPreferences(student) < average)
                .forEach(System.out::println);
    }

    /**
     * Functia primeste ca parametru un obiect de tip Project
     *
     * @param p-proiectul
     * @return- numarul studentilor care prefera proiectul trimis ca parametru
     */
    int getNumberOfApplicationProject(Project p) {
        int number = (int) studentsList.stream()
                .filter(student -> student.getProjects().contains(p))
                .count();
        return number;
    }

    @Override
    public String toString() {
        return "Students" + studentsList + "\n" +
                "Projects" + projectsList + "\n" +
                "Students preferences" + studentsPreferences;
    }
}
