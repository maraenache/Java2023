package lab3.compulsory;

import java.util.List;
import java.util.ArrayList;

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
     * setter
     * seteaza lista nodurilor
     *
     * @param nodes o lista de obiecte de tip Node
     */

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
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
     * Stringul contine companiile si persoanele adaugate in lista de noduri nodes
     *
     * @return un String ce reprezinta un obiect de tip network
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.getName()).append("\n");
        }
        return sb.toString();
    }
}