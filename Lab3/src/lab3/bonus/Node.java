package lab3.bonus;


public interface Node {
    String getName();

    /**
     * am adaugat ulterior metoda getImportance
     * @return-numarul de conexiuni al fiecarui nod
     */
    default int getImportance() {
        return 0;
    }

}
