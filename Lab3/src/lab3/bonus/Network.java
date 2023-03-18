package lab3.bonus;

import java.util.*;


public class Network {
    /**
     * Lista nodurilor din retea
     */
    private List<Node> nodes = new ArrayList<>();

    /**
     * pentru fiecare nod pastram pozitia pentru a o folosi in crearea listei de adiacenta
     * pentru a ne referi la un anume nod, folosind pozitia sa in lista nodurilor
     */
    Map<String, Integer> nodePosition = new HashMap<>();

    /**
     * matricea de adiacenta a retelei de noduri,
     * adjMatrix[i][j]=1 <=> exista relatie de la obiectul de tip Node i la obiectul de tip Node j
     */
    int[][] adjMatrix;

    /**
     * constructor default
     * creeaza un obiect de tip Network
     */
    public Network() {
        nodes = new LinkedList<>();
    }

    /**
     * constructor ce primeste o lista de noduri
     * creeaza un obiect de tip Network
     */

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
     * @return importanta unui nod-numarul de relatii pe care acesta le are cu celelate noduri
     */
    int getImportance(String nodeName) {
        for (Node otherNode : nodes) {
            if (nodeName.equals(otherNode.getName())) {
                return otherNode.getImportance();
            }
        }
        System.out.println("There is no node in the network with this name");
        return -1;
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


    /**
     * Metoda asociaza fiecarui nod din network o pozitie pentru a putea crea matricea de adiacenta
     * astfel primul nod, va fi pozitia 0
     * al doulea nod, va fi reprezentat de pozitia 1
     * matricea de adiacenta adjMatrix[i][j]=1 <=> exista relatie de la obiectul de tip Node i la obiectul de tip Node j
     * 0 altfel
     */
    public void Graph() {
        int numberOfVerticies = nodes.size();
        int[][] adjMatrix = new int[numberOfVerticies][numberOfVerticies];
        Map<String, Integer> nodePosition = new HashMap<>();

        int position = 0;
        for (Node node : nodes) {
            this.nodePosition.put(node.getName(), position);
            position++;
        }
        this.nodePosition = this.nodePosition;

        for (Node node : nodes) {
            int positionNode1 = this.nodePosition.get(node.getName());
            for (Node neighbor : node.getRelationships().keySet()) {
                int positionNode2 = this.nodePosition.get(neighbor.getName());
                adjMatrix[positionNode1][positionNode2] = 1;
                adjMatrix[positionNode2][positionNode1] = 1;
            }
        }
        this.adjMatrix = adjMatrix;
    }

    /**
     * Se initializeaza vectorii de timp tin, low și visited, cu -1, si se pornește parcurgerea DFS dintr-un nod care poate fi root sau nu.
     * caz1)Dacă v este radacina arborelui DFS și are cel putn 2 subarbori, atunci v este PA
     * caz2)se pornește parcurgerea DFS dintr-un nod dif de radacina si pt fiecare nod vizitat, se calculeaza children count,
     * timpul de discovery tin și se setează low initial ca tin.
     * pt fiecare muchie vizitata, se verif dacă nodul adiacent este parintele nodului curent. Daca este, se trece la urmatorul nod, altfel
     * se verif daca nodul adiacent a fost vizitat anterior.
     * daca s a vizitat, se modif low[v] cu minimul dintre low[v] și tin[j]
     * daca nu e vizitat, inseamna ca putem continua parcurgerea DFS din nodul adiacent si modificam low[v] cu
     * minimul dintre low[v] și low[j].
     * După ce s-a terminat parcurgerea DFS din nodul curent, se verif daca exista un nod j în subarborele lui v cu low[j] >= tin[v].
     * daca exista, v este un PA.
     */
    public void articulationPoints() {
        Graph();
        int n = nodes.size();
        boolean[] visited = new boolean[nodes.size()];
        int[] low = new int[nodes.size()];
        int[] tin = new int[nodes.size()];
        int time = 0;
        int p = -1;
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < n; i++) {
            low[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            tin[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(i, p, visited, tin, low, time);
        }
    }

    /**
     * Metoda ce returneaza numele nodului de pe pozitia i din hasmapul nodePosition
     *
     * @param map-hasmapul<nod, pozitie>
     * @param position-pozitia  pe care o cautam
     * @return
     */
    public String getKey(Map<String, Integer> map, Integer position) {

        if (map.containsValue(position)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (Objects.equals(entry.getValue(), position)) {
                    return entry.getKey();
                }
            }
        }
        return "There is no node at this position";
    }

    /**
     * traverseaza graful prin DFS si afla punctele de articulatie folosind cele doua cazuri din
     * algoritmul lui Tarjan, respectiv
     *
     * @param v       nodul curent
     * @param p       parintele nodului curent
     * @param visited un vector de indicatori care ține evidența nodurilor vizitate
     * @param tin     timpul de intrare pentru fiecare nod, discovery time conf video
     * @param low     timpul minim de intrare pentru nodurile accesibile din subarborele nodului curent, lowest time stamp that can be reach
     * @param time    timpul curent
     */
    public void dfs(int v, int p, boolean[] visited, int[] tin, int[] low, int time) {
        visited[v] = true;
        tin[v] = low[v] = time++;
        int children = 0;
        for (int j = 0; j < nodes.size(); j++) {
            if (adjMatrix[v][j] != 0)// lista de adiacenta a lui i
            {
                if (j == p) continue;
                if (visited[j]) {
                    low[v] = Math.min(low[v], tin[j]);
                } else {
                    dfs(j, v, visited, tin, low, time);
                    low[v] = Math.min(low[v], low[j]);
                    if (low[j] >= tin[v] && p != -1)
                        System.out.println("Node" + getKey(nodePosition, v) + " is an articulation point");
                    ++children;
                }
            }
        }
        if (p == -1 && children > 1) {
            System.out.println("Node" + getKey(nodePosition, v) + " is an articulation point");
        }
    }


}
