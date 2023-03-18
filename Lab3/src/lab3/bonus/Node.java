package lab3.bonus;
import java.util.*;
public interface Node {
    String getName();
    int getId();

    /**
     * am adaugat ulterior metoda getImportance
     * @return-numarul de conexiuni al fiecarui nod
     */
    default int getImportance()
    {
        return 0;
    }

    /**
     * Node-un nod cu care nodul are relatie, String-tipul de relatie
     * @return lista nodurilor cu care nodul din this are relatii
     */
    default Map<Node, String> getRelationships()
    {
        return null;
    }

}
