package lab3.homework;

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
