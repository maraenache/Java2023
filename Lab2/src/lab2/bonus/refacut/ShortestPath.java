
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.sp.SinglePairShortestPath;
import org.graph4j.util.Path;

class ShortestPath {

    private final int numLocations = 100;
    private List<Location> locations;
    private static final double MAX_ROAD_LENGTH = 100;
    
    private Graph graph;

    public static void main(String args[]) {
        var app = new ShortestPath();
        app.createUserModel();
        app.createGraph();
        app.solveProblem();
    }
    /**creez locatii random si conexiunile cu alte locatii.Pe baza acestui model,
    se va crea un graf cu metodata createGraph*/
    void createUserModel() {
        //creez locatiile
        locations = new ArrayList<>(numLocations);
        for (int i = 0; i < numLocations; i++) {
            locations.add(new Location("City " + i));
        }

        //conectez random locatiile
        var random = new Random();
        for (int i = 0; i < numLocations - 1; i++) {
            var loc1 = locations.get(i);
            for (int j = i + 1; j < numLocations; j++) {
                var loc2 = locations.get(j);
                if (random.nextBoolean()) {
                    double length = random.nextDouble() * MAX_ROAD_LENGTH;
                    loc1.getNeighbors().put(loc2, length);
                    loc2.getNeighbors().put(loc1, length);
                }
            }
        }
    }

    /**Metoda creeaza un graf pe baza modelului creat,
    astfel incat fiecare varf corespunde unei locatii si fiecare muchie
    corespune unei conexiuni dintre locatii. Muchiile cu cost
    contin si lungimea drumului dintre vf incidente
    */
    void createGraph() {
        //graf nul
        this.graph = GraphBuilder.empty()
                .estimatedNumVertices(numLocations)
                .buildGraph();

        //vertex=index locatie
        for (int i = 0; i < numLocations; i++) {
            graph.addVertex(i, locations.get(i));
        }

        //muchiile
        for (var location : locations) {
            //numarul varfului ce coresp obiectul location
            int v = graph.findVertex(location);
            var neighborMap = location.getNeighbors();
            for (var neighbor : neighborMap.keySet()) {
                int u = graph.findVertex(neighbor);
                //pt a nu adauga aceeasi muchie de 2 ori
                if (v < u) {
                    //lungimea drumului dintre 2 locatii
                    double length = neighborMap.get(neighbor);
                    //pun costul pe muchie
                    graph.addEdge(v, u, length);
                }
            }
        }
        assert graph.numVertices() == numLocations;
    }

    /**Dupa ce am creat graful, aleg 2 locatii si apelez metoda
    findShortestPath pentru a gasi cel mai scurt traseu 
    */
    void solveProblem() {
       
        Location fromLoc = locations.get(0);
        Location toLoc = locations.get(numLocations - 1);

        findShortestPath(fromLoc, toLoc);
    }

    /**
    Pornim de la un graf creat, gasesc indexul celor 2 locatii primite ca parametru
    si folosesc libraria Graph4J sa creez un algoritm ce determina cel mai scurt
    traseu, in acest caz SinglePairShortestPath
    */
    private void findShortestPath(Location fromLoc, Location toLoc) {

        int source = graph.findVertex(fromLoc);
        int target = graph.findVertex(toLoc);

        var alg = SinglePairShortestPath.getInstance(graph, source, target);
       
        double length = alg.getPathWeight();
        System.out.println("The length of the shortest path: " + length);

        Path path = alg.findPath();
        System.out.println("The shortest path in the graph: " + path);
        
        List<Location> route = new ArrayList<>();
        for (int v : path.vertices()) {
            route.add(locations.get(v));
        }
        System.out.println("The shortest route between locations: " + route);

    }
}
