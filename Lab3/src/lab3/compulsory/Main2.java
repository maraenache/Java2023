package lab3.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {


        Node company1 = new Company("Apple", 1, "Electronics");

        Node company2 = new Company("Facebook", 2, "Computer");

        Node company3 = new Company("Audi", 3, "Transport");

        Position position1 = new Position("Manager", 600_000, 10);
        Position position2 = new Position("Software Engineer", 800_000, 15);
        Position position3 = new Position("CEO", 900_000, 20);


        Node person1 = new Person("Ana", 100, new Company("Apple", 1, "Electronics"), position1);
        Node person2 = new Person("Mihai", 101, new Company("Facebook", 2, "Computer"), position3);
        Node person3 = new Person("Andrei", 102, new Company("Audi", 3, "Transport"), position2);

        List<Node> nodes = new ArrayList<>();

        nodes.add(company1);
        nodes.add(company2);
        nodes.add(company3);

        nodes.add(person1);
        nodes.add(person2);
        nodes.add(person3);

        for(Node node: nodes)
        {
            System.out.println(node);
        }
    }

}
