package lab3.bonus;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Network network = new Network();

        Company c0 = new Company("Apple");

        Person p0 = new Person("Mara");
        Person p1 = new Person("Mihai") ;
        Person p2 = new Person("Carmen");

        Person p3 = new Person("Andrei");
        Person p4 = new Person("Alina");

        p0.addRelationship(p1, "best-friends");
        p1.addRelationship(p0, "best-friends");

        p1.addRelationship(p2, "friends");
        p2.addRelationship(p1, "friends");

        p0.addRelationship(p2, "best-friends");
        p2.addRelationship(p0, "best-friends");


        p0.addRelationship(c0, "CEO");

        c0.addEmployee(p0, "CEO");

        p2.addRelationship(c0, "boss");
        c0.addEmployee(p2, "boss");

        p4.addRelationship(c0, "manager");
        c0.addEmployee(p4, "manager");


        network.addNode(c0);

        network.addNode(p0);
        network.addNode(p1);
        network.addNode(p2);
        network.addNode(p3);
        network.addNode(p4);


        System.out.println(network);

        Graph graph = new Graph(network.getNodes().size());
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        /*Ideea 1, era sa leg network din graf folosind id pentru persoana si company care sa reprezinte pozitiile intr-un vector
dupa sa parcurg din Network si sa creez un obiect de tip Graph la care sa adaug muchii(id-urile)nodurileor
Ideea 2, sa creez o matrice de adiacenta a networkului, a[i][j]=1 <=> exista relatie intre i si j
si dupa sa parcurg matricea si sa creez un obiect de tip Graph la care sa adaug nodurile i si j, unde a[i][j]=1
Ideea 3, sa creez o clasa Edge, care sa aiba Node source, Node dest, si sa adaug in network o lista de muchii, si sa aplic algoritmul
direct pe ea
* */
        graph.findArticulationPoints();
        graph.printArticulationPoints();
    }
}