package org.example.homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {

        Problem problem=new Problem(3,4);
        System.out.println(problem);
        problem.studentsLowerAVG();
        Solution solution= new Solution(problem);
        solution.solve();
    }
}