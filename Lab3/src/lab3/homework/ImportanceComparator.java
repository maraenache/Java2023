package lab3.homework;

import java.util.Comparator;

/**
 * o alternativa pentru sortarea din metoda toString din network este un comparator
 * si sa le sortez asa Collections.sort(nodes,new ImportanceComparator());
 * dar am optat pentru comparatorul din functie pentru a se vedea mai clar cum sortez
 */
public class ImportanceComparator implements Comparator<Node> {

    /**
     * Compara 2 obiecte de tip nod in functie de importanta(numarul de conexiuni ale nodului)
     *
     * @param node1 primul nod
     * @param node2 al doilea nod
     * @return 0 daca numarul din conexiuni din primul nod este egal cu numarul de conexiuni din al doilea
     * un numar pozitiv daca numarul de conexiuni din primul nod este mai mare decat numarul de conexiuni din al doilea
     * un numar negativ daca numarul de conexiuni din primul nod este mai mic decat numarul de conexiuni din al doilea
     */
    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node2.getImportance(), node1.getImportance());
    }
}
