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
        pCarmen.addRelationship(pMara, "best-friends");

        pMara.addRelationship(pAndrei, "friends");
        pAndrei.addRelationship(pMara, "friends");

        pMihai.addRelationship(pAlina, "best-friends");
        pAlina.addRelationship(pMihai, "best-friends");

        pMihai.addRelationship(pIoana, "coworkers");
        pIoana.addRelationship(pMihai, "coworkers");

        pMihai.addRelationship(pAndrei, "neighbours");
        pAndrei.addRelationship(pMihai, "neighbours");

        pMihai.addRelationship(cAudi, "CEO");
        cAudi.addEmployee(pMihai, "CEO");

        pMara.addRelationship(cApple, "boss");
        cApple.addEmployee(pMara, "boss");

        pIoana.addRelationship(cNasa, "manager");
        cNasa.addEmployee(pIoana, "manager");

        pAndrei.addRelationship(cFacebook, "assistant");
        cFacebook.addEmployee(pAndrei, "assistant");

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

/*
output:
The list of nodes in network

Company|name='Apple', id=1, industry=Electronics employees 1 -Mara;
Company|name='Audi', id=3, industry=Transport employees 1 -Mihai;
Company|name='Facebook', id=2, industry=Computer employees 1 -Andrei;
Company|name='NASA', id=34, industry=Science employees 1 -Ioana;
Designer | Name: Mara, ID: 100, Favorite color: purple, Birthday: 2003-03-11, relationships 3: -Andrei->friends; Apple->boss; Carmen->best-friends;
Programmer | Name: Andrei, ID: 103, Number of Projects: 7, Birthday: 1999-04-08, relationships 3 : -Mihai->neighbours; Mara->friends; Facebook->assistant;
Programmer | Name: Ioana, ID: 105, Number of Projects: 1, Birthday: 1999-02-26, relationships 2 : -Mihai->coworkers; NASA->manager;
Designer | Name: Mihai, ID: 101, Favorite color: red, Birthday: 2000-03-10, relationships 4: -Andrei->neighbours; Audi->CEO; Alina->best-friends; Ioana->coworkers;
Programmer | Name: Alina, ID: 104, Number of Projects: 4, Birthday: 2002-11-30, relationships 1 : -Mihai->best-friends;
Designer | Name: Carmen, ID: 102, Favorite color: blue, Birthday: 1999-02-26, relationships 1: -Mara->best-friends;


The list of nodes in network, sorted by their importance

Programmer | Name: Alina, ID: 104, Number of Projects: 4, Birthday: 2002-11-30, relationships 1 : -Mihai->best-friends;
Designer | Name: Carmen, ID: 102, Favorite color: blue, Birthday: 1999-02-26, relationships 1: -Mara->best-friends;
Company|name='Audi', id=3, industry=Transport employees 1 -Mihai;
Company|name='Apple', id=1, industry=Electronics employees 1 -Mara;
Company|name='Facebook', id=2, industry=Computer employees 1 -Andrei;
Company|name='NASA', id=34, industry=Science employees 1 -Ioana;
Programmer | Name: Ioana, ID: 105, Number of Projects: 1, Birthday: 1999-02-26, relationships 2 : -Mihai->coworkers; NASA->manager;
Programmer | Name: Andrei, ID: 103, Number of Projects: 7, Birthday: 1999-04-08, relationships 3 : -Mihai->neighbours; Mara->friends; Facebook->assistant;
Designer | Name: Mara, ID: 100, Favorite color: purple, Birthday: 2003-03-11, relationships 3: -Andrei->friends; Apple->boss; Carmen->best-friends;
Designer | Name: Mihai, ID: 101, Favorite color: red, Birthday: 2000-03-10, relationships 4: -Andrei->neighbours; Audi->CEO; Alina->best-friends; Ioana->coworkers;

* */
