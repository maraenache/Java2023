package lab3.bonus;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Network network = new Network();

        Designer p0 = new Designer("Mara", 100, LocalDate.of(2003, 3, 11),"purple");
        Designer p1 = new Designer("Mihai", 101, LocalDate.of(2000, 3, 10), "red");
        Designer p2 = new Designer("Carmen", 102, LocalDate.of(1999, 2, 26), "blue");
        Programmer p3 = new Programmer("Andrei", 103, LocalDate.of(1999, 4, 8),  7);
        Programmer p4 = new Programmer("Darius", 103, LocalDate.of(1999, 4, 8),  7);
        Programmer p5 = new Programmer("Laura", 103, LocalDate.of(1999, 4, 8),  7);


        network.addNode(p0);
        network.addNode(p1);
        network.addNode(p2);
        network.addNode(p3);
        network.addNode(p4);
        network.addNode(p5);

        p0.addRelationship(p1,"coworkers");
        p1.addRelationship(p2,"friends");
        p0.addRelationship(p2,"teammates");
        p0.addRelationship(p3,"neighbours");
        p3.addRelationship(p4,"best-friend");
        p5.addRelationship(p3,"friends");

        network.articulationPoints();
    }
}

/*
output:
Node Andrei is an articulation point(3)
Node Mara is an articulation point(0)

* am construit nodurile si muchiile din spatele retelei dupa exemplul din videoul pus in README
*/
