package lab2.bonus;

public class DijkstraAlgorithm extends Algorithm {
    public DijkstraAlgorithm(Problem problem) {
        super(problem);
    }

    @Override
    public Solution solve() {

        //djikstra
        //Djikstra
        //in final creez un nou array de locatii care sa contina cea mai buna ruta
        // gasita de algoritm
        //am modificat problem astfel incat sa contina si o locatie de inceput si una de sfarsit

        Location[] route = new Location[0];
        Solution solution = new Solution(route);
        return solution;


    }

        /*
        Location start = problem.getStartLocation();
        Location end = problem.getEndLocation();
        Creez o coada de prioritati si adaug locatia de start in coadă, a i la inceputul cozii sa am cea mai mica dist(0).
        Mereu coada va fi ordonată în funcție de dist de la locația de start, a i locaia cu cea mai mică distanță să fie prima.
        PriorityQueue<Location> queue =
        Cat timp coada nu este vida, iau prima locatie, cea cu dist minima, o elimin din coada cu poll si
        vad daca este egala cu locatia la care trebuie sa ajung. In caz afirmativ, ma opresc si am gasit cel mai scurt drum
            while (!queue.isEmpty()) {
            Location first = queue.poll();
            if (first.equals(end)) {
                break;
            }
            for (Location other : problem.getDifferentLocation(location)) {

                }
            }

      Pt fiecare locatie vecina cu locatia curenta, calculez distanta de la start la vecin. Daca este mai mica decat distanta curenta
      de la start la locatia curenta, actualizez distanta si adaug vecinul in coada
*/
}
