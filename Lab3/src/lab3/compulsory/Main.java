package lab3.compulsory;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Company company1 = new Company("Apple", 1);
        company1.setIndustry("Electronics");
        Company company2 = new Company("Facebook", 2, "Computer");
        Company company3 = new Company("Audi", 3, "Transport");

        Position position1 = new Position("Manager", 600_000, 10);
        Position position2 = new Position("Software Engineer", 800_000, 15);
        Position position3 = new Position("CEO", 900_000, 20);


        Person person1 = new Person("Ana", 100, company1, position1);
        Person person2 = new Person("Mihai", 101, company1, position3);
        Person person3 = new Person("Andrei", 102, company1, position2);

        System.out.println(company1);
        System.out.println(company2);
        System.out.println(company3);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        List<Node> nodes = new ArrayList<>();

        nodes.add(person1);
        nodes.add(person2);
        nodes.add(person3);

        Network network = new Network();

        network.addNode(company1);
        network.addNode(company2);
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(person3);

        List<Node> nodesList = network.getNodes();
        for (Node node : nodesList) {
            System.out.println(node);
        }

    }
}
