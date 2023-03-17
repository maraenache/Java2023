package lab3.homework;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Network network = new Network();

        Company cApple = new Company("Apple", 1, "Electronics");
        Company cFacebook = new Company("Facebook", 2, "Computer");
        Company cAudi = new Company("Audi", 3, "Transport");
        Company cNasa = new Company("NASA", 34, "Science");

        Designer pMara = new Designer("Mara", 100, LocalDate.of(2003, 3, 11), cApple, "purple");
        Designer pMihai = new Designer("Mihai", 101, LocalDate.of(2000, 3, 10), cFacebook, "red");
        Designer pCarmen = new Designer("Carmen", 102, LocalDate.of(1999, 2, 26), cAudi, "blue");

        Person pAndrei = new Programmer("Andrei", 103, LocalDate.of(1999, 4, 8), cApple, 7);
        Programmer pAlina = new Programmer("Alina", 104, LocalDate.of(2002, 11, 30), cFacebook, 4);
        Programmer pIoana = new Programmer("Ioana", 105, LocalDate.of(1999, 2, 26), cFacebook, 1);

        pMara.addRelationship(pCarmen, "best-friends");
        pMara.addRelationship(pAndrei, "friends");
        pMara.addRelationship(cApple, "boss");

        pMihai.addRelationship(pAlina, "best-friends");
        pMihai.addRelationship(pIoana, "friends");
        pMihai.addRelationship(cAudi, "client");
        pMihai.addRelationship(pAndrei, "neighbours");//team leader

        network.addNode(cApple);
        network.addNode(cAudi);
        network.addNode(cFacebook);
        network.addNode(cNasa);

        network.addNode(pMara);
        network.addNode(pAndrei);
        network.addNode(pIoana);
        network.addNode(pMihai);
        network.addNode(pAlina);
        network.addNode(pCarmen);

        System.out.println("The list of nodes in network\n");
        List<Node> nodesList = network.getNodes();
        for (Node nod : nodesList) {
            System.out.println(nod);
        }

        System.out.println("\n\nThe list of nodes in network, sorted by their importance\n");
        System.out.println(network);

    }
}
