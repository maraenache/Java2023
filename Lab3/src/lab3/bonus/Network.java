package lab3.bonus;

import java.util.*;


public class Network {
    /**
     * Lista nodurilor din retea
     */
    private List<Node> nodes = new ArrayList<>();

    /**
     * constructor
     * creeaza un obiect de tip Network
     */
    public Network() {
        nodes=new LinkedList<>();
    }


    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * @return lista nodurilor din retea
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Adauga un nod in retea
     *
     * @param node nodul ce trebuie adaugat
     **/
    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * Stringul contine companiile si persoanele adaugate in lista de noduri nodes in functie de importanta
     * interfata comparator are o functie compare pe care am suprascris-o. daca aceasta returneaza 1, nodurile fac swipe
     * altfel, vor ramane neschimbate. Pentru a le scimba trebuie ca primul nod sa aia importanta(numarul de conexiune) mai mare decat al doilea
     *
     * @return un String ce reprezinta un obiect de tip network sortat in functie de importanta nodurilor
     */
    int getImportance(String nodeName)
    {
        for(Node otherNode: nodes)
        {
            if(nodeName.equals(otherNode.getName()))
            {
                return otherNode.getImportance();
            }
        }
        System.out.println("There is no node in the network with this name");
        return -1;
    }
    /*public void Test()
    {
        Graph g = new Graph(nodes.size());

        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        g.findArticulationPoints();
        g.printArticulationPoints();
    }*/
    @Override
    public String toString() {
        Comparator<Node> nodeComparator = new Comparator<Node>() {
            public int compare(Node node1, Node node2) {
                if (node1.getImportance() > node2.getImportance()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(nodes, nodeComparator);
        // sau Collections.sort(nodes,new ImportanceComparator());

        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node).append("\n");
        }
        return sb.toString();
    }

}
