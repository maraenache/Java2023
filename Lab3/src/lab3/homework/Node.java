package lab3.homework;

public interface Node {
    String getName();
    int getId();

    /**
     * am adaugat ulterior metoda getImportance
     * @return-numarul de conexiuni al fiecarui nod
     */
    default int getImportance() {
        return 0;
    }

}
