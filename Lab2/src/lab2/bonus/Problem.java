package lab2.bonus;

import java.util.*;

import static java.lang.Math.sqrt;

public class Problem {
    protected int numberOfLocations;
    protected int numberOfRoads;
    private Location[] locations;
    private Road[] roads;

    Location startLocation;
    Location endLocation;

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public Problem() {
        this.locations = new Location[0];
        this.roads = new Road[0];
        this.numberOfLocations = 0;
        this.numberOfRoads = 0;
    }

    /**
     * Returneaza pozitia obiectului Location in array ul locations[].
     *
     * @param location -locatia pe care o cauta
     * @return the position of the location in the array, or -1 if it is not found
     */
    private int getLocationPosition(Location location) {
        for (int i = 0; i < numberOfLocations; i++) {
            if (locations[i].equals(location)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Verifica daca o anumita locatie se afla in array-ul locations[].Am folosit functia de mai sus
     * Daca este returnat -1, inseamna ca locatia nu este in vector, deci returnam fals
     * Daca este returnat un numar nenegativ, valoarea returnata reprezinta pozitia, deci returnam true
     *
     * @param location-locatia pe care vrem sa o verificam
     * @return true if the location is already in use, false otherwise
     */
    public boolean locationInUse(Location location) {

        try {
            int position = getLocationPosition(location);
            if (position >= 0) {
                //System.out.println("The location " + location + " is already in use");
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            System.out.println("The location cannot be null");
            return false;
        } catch (Exception e) {
            System.out.println("An error for location" + location.getName());
            return false;
        }
    }

    /**
     * Verifica daca un anumit drum se afla in array-ul roads[]. Am facut diferit fata de locations, folosind
     * doar o functie. Parcurg vectorul de locatii si daca intalnesc o valoare egala, returnez true-intrucat drumul
     * e deja in array.Am folosit try catch pentru a trata cazul cu null, initial am pus throw pentru atrata exceptiile,
     * dar pentru a putea verifica mai multe cazuri simultan, am lasat doar afisarea unor mesaje pentru consola.
     *
     * @param road-drumul pe care vrem sa il verificam
     * @return true if the road is already in use, false otherwise
     */
    public boolean roadInUse(Road road) {
        try {
            for (int i = 0; i < numberOfRoads; i++) {
                if (roads[i].equals(road)) {
                    // System.out.println("The road is already in use");
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            System.out.println("The road cannot cannot be null");
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verifica daca proprietatile specifice fiecarui tip sunt corespunzatoare.
     * Pentru City, verifica daca populatia este un numar pozitiv
     * Pentru GasStation, verifica daca pretul este un numar pozitiv
     * Pentru Airport, verifica daca numarul de terminale este un numar pozitiv
     * Daca nu este in niciunul din cazuri, va returna fals, ce va conduce spre invalid.
     * Restul exceptiilor, precum nullPoointer, vor conduce la afisarea unui mesaj de eroare
     *
     * @param location-locatia a carui proprietati le verificam
     * @return true if the location has valid properties, false otherwise
     */
    public boolean validSpecificPropertiesLocation(Location location) {
        try {
            if (location.type.equals("City")) {
                City city = (City) location;
                if (city.getPopulation() < 0) {
                    System.out.println("Invalid value for population for " + city.getName() + " (Indication: it should be a positive value)");
                    return false;
                }
                return true;
            } else if (location.type.equals("GasStation")) {
                GasStation gasStation = (GasStation) location;
                if (gasStation.getGasPrice() < 0) {
                    System.out.println("Invalid value for gas price for " + gasStation.getName() + " (Indication: it should be a positive value)");
                    return false;
                }
                return true;
            } else if (location.type.equals("Airport")) {
                Airport airport = (Airport) location;
                if (airport.getNumbersOfTerminals() < 0) {
                    System.out.println("Invalid value for numberOfTerminals for " + airport.getName() + " (Indication: the number of terminals should be at least 1)");
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error, invalid properties for location " + location.getName());
            return false;
        }
    }

    /**
     * Verifica daca proprietatile specifice fiecarui tip de drum sunt corespunzatoare.
     * Pentru orice tip de drum, verificam initial daca viteza este numar pozitiv
     * Pentru Express, verifica daca numarul de benzi este un numar pozitiv
     * Pentru Highway, verifica daca numarul de indicatoare este un numar pozitiv
     * Pentru Country, verifica in plus daca numarul de stalpi electrici este un numar pozitiv
     * Daca nu este in niciunul din cazuri, va returna fals, ce va conduce spre invalid.
     * Restul exceptiilor, precum nullPoointer, vor conduce la afisarea unui mesaj de eroare
     *
     * @param road-drumul al carui proprietati le verificam
     * @return true if the road has valid properties, false otherwise
     */
    public boolean validSpecificPropertiesRoad(Road road) {
        try {
            if (road.getSpeedLimit() < 0) {
                System.out.println("Invalid value for speedLimit for" + road.getName() + " (Indication:the speed value should be a positive value");
                return false;
            }
            if (road.type == "Country") {
                Country country = (Country) road;
                if (country.getNumberOfElectricPoles() < 0) {
                    System.out.println("Invalid value for number of electric poles for" + country.getName() + " (Indication:the number of electric poles should be a positive value");
                    return false;
                }
                return true;
            } else if (road.type == "Express") {
                Express express = (Express) road;
                if (express.getNumberOfLanes() < 1) {
                    System.out.println("Invalid value for number of lanes for" + express.getName() + " (Indication:the number of lanes should be a positive value");
                    return false;
                }
                return true;
            } else if (road.type.equals("Highway")) {
                Highway highway = (Highway) road;
                if (highway.getNumberOfIndicationSigns() < 0) {
                    System.out.println("Invalid value for number of indication signs for" + highway.getName() + " (Indication:the  number of indication signs should be a positive value");
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error, invalid properties for Road " + road.getName());
            return false;
        }
    }

    /**
     * Calculeaza distanta Euclidiana dintre 2 locatii dupa formula
     * (x1-x2)^2+(y1-y2)^2
     * @param start -locatia de inceput
     * @param end locatia de sfarsit
     * @return the Euclidean distance between the start and the end locations
     */
    double euclidianDistance(Location start, Location end) {
        double x = start.getX() - end.getX();
        double y = start.getY() - end.getY();
        double euclidianDistance = sqrt(x * x + y * y);
        return euclidianDistance;
    }

    /**
     * In cazul in care locatia a fost introdusa ca instanta a problemei
     * stim ca numele difera de restul, mai trebuie verificat si daca coordonatele difera
     * De exemplu daca am Iasi de coordonate 0 0 nu pot adauga si Suceava de coordonate 0 0
     * parcurh vectorul de locatii si aflu cu getLocationPosition pozitia locatiei trimise ca parametru
     * daca gasesc o locatie de pe alta pozitie care are aceleasi coordonate returnez false
     * @param location-locatia a carei coordonate vrem sa le verificam
     * @return true-if the location has valid coordinates,false otherwise
     */
    public boolean validUniqueCoordinates(Location location) {
        for (int i = 0; i < numberOfLocations; i++) {
            if (i != getLocationPosition(location) && locations[i].getX() == location.getX() && locations[i].getY() == location.getY()) {
                System.out.println("The coordinates for " + location.getName() + " are not unique (Indication: Two locations cannot have the same coordinates)");
                return false;
            }
        }
        return true;
    }

    /**
     * Implement a method that determines if a problem's instance is valid.
     * Pentru fiecare drum, verific daca lungimea sa este mai mare decat distanta dintre locatiile start si end corespunzatoare
     * Implicit se verifica daca este o valoare pozitiva, fiind mai mare decat o suma de patrate perfecte
     * si se verifica si proprietatile pentru fiecare tip de drum, daca oricare din functii returneaza fals,
     * instanta problemei nu este valida
     * Pentru fiecare locatie se verifica daca are coordonate unice, numele fiind verificat inainte de a adauga in problema locatia
     * si respectiv, proprietatile specifice fiecarui tip de drum
     * Daca in urma verificarilor nu s a iesit cu return false inseamna ca instanta este valida
     * @return-true if the problem s instance is valid, false otherwise
     */
    public boolean validInstanceOfProblem() {
        try {
            for (Road road : roads) {
                if (road.length < euclidianDistance(road.getStart(), road.getEnd())) {
                    //System.out.println("Invalid value for length for road " + road.getName() + "(Indication: The length ofa road should
                    // not be less than the euclidian distance between the location coordinates, which is"+euclidianDistance(road.getStart(), road.getEnd()));
                    return false;
                }
                if (!validSpecificPropertiesRoad(road)) {
                    return false;
                }
            }
            for (Location location : locations) {
                if (!validSpecificPropertiesLocation(location)) {
                    return false;
                }
                if (!validUniqueCoordinates(location)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error ");
            return false;
        }
    }

    /**
     * Adauga o locatie noua in array ul locations. Daca locatia este deja in array, nu o putem adauga
     * Daca numarul de locatii ajunge egal cu dimensiunea arrayului locations, crestem capacitatea
     * cream un nou vector cu o capacitate mai mare, si copiem elementele din vectorul vechi pe primele pozitii
     * dupa care adaugam pe ultima pozitie locatia newLocation
     * O alternativa era sa folosesc List<>, sau o alta colectie, dar asta era specific pentru laboratorul 3
     * Daca era spatiu, doar atribuiam pe prima pozitie libera locatia noua, si crestem numarul de locatii
     * @param newLocation-locatia pe care vrem sa o adaugam
     * @return true if the location is added , false otherwise
     *
     **/

    public boolean addLocation(Location newLocation) {
        try {
            if (locationInUse(newLocation)) {
                return false;
            }
            if (numberOfLocations == locations.length) {
                int capacity = locations.length;
                int newCapacity = locations.length + 1;
                Location[] newLocations = new Location[newCapacity];
                System.arraycopy(locations, 0, newLocations, 0, capacity);
                newLocations[newCapacity - 1] = newLocation;
                locations = newLocations;
                numberOfLocations++;
                return true;
            } else {
                locations[numberOfLocations] = newLocation;
                numberOfLocations++;
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("Location cannot be null");
            return false;
        } catch (Exception e) {
            System.out.println("Error (addLocation)");
            return false;
        }
    }

    /**
     * Adauga un drum nou in array ul roads. Daca drumul este deja in array, nu il putem adauga
     * Daca numarul de drumuri ajunge egal cu dimensiunea array ului roads, crestem capacitatea astfel:
     * cream un nou vector cu o capacitate mai mare, si copiem elementele din vectorul vechi pe primele pozitii
     * dupa care adaugam pe ultima pozitie locatia newLocation
     * Daca era spatiu, doar atribuiam pe prima pozitie libera drumul nou, si crestem numarul de drumuri
     * @param newRoad-drumul pe care vrem sa o adaugam
     * @return true if the road is added , false otherwise
     *
     **/

    public boolean addRoad(Road newRoad) {

        try {
            if (roadInUse(newRoad)) {
                return false;
            }
            if (numberOfRoads == roads.length) {
                int capacity = roads.length;
                int newCapacity = roads.length + 1;
                Road[] newRoads = new Road[newCapacity];
                System.arraycopy(roads, 0, newRoads, 0, capacity);
                newRoads[newCapacity - 1] = newRoad;
                roads = newRoads;
                numberOfRoads++;
                return true;
            } else {
                roads[numberOfRoads] = newRoad;
                numberOfRoads++;
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("Road cannot be null");
            return false;
        } catch (Exception e) {
            System.out.println("Error (addRoad)");
            return false;
        }
    }

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public int getNumberOfRoads() {
        return numberOfRoads;
    }

    /**
     * Implement an algorithm for determining if it is possible to go from one location to another using the given roads.
     * Verifica daca este posibil sa ajung dintr-o locatie de inceput(start), intr-o locatie de sfarsit(end), utilizand
     * drumurile din problema.
     * Implementarea este DFS si foloseste un array pentru a tine evidenta locatiilor vizitate in timpul cautarii.
     *
     * Metoda canTravel primeste ca parametru 2 locatii A si Z si returneaza true daca exista o succesiune de drumuri intre ele.
     * Daca oricare din parametri este null sau daca nu este in lista de locatii din problema(in array ul locations[]) atunci returnez fals
     * caci nu pot ajunge sau pleca dintr-o locatie care nu este in intanta problemei. Altfel, inseamna ca este o posibilitate sa am un drum intre cele doua locatii
     * deci initializez vectorul de locatii vizitate cu fals si incep parcurgerea DFS folosind functia recursiva canTravelDFS. Asemanator cu exercitiile de la grafuri, daca plec dintr-o locatie A, si stiu ca pot folosi un drum AB, il vizitez
     * si vizitez A si B si acum caut un drum care sa inceapa din B, daca il gasesc continui, pana ajung in Z (locatia de sfarsit). Daca am putut parcurge
     * si am gasit drumuri succesive de la A la Z, returnez true, altfel inseamna ca nu pot ajunge din locatia start la
     *locatia end.
     * @param start-locatia din care plec
     * @param end-locatia in care vreau sa ajung
     * @return true if if it is possible to go from one location to another using the given roads, false otherwise
     */
    public boolean canTravel(Location start, Location end) {
        if (start == null || end == null) {
            return false;
        }
        if (!locationInUse(start) || !locationInUse(end)) {
            return false;
        }
        boolean[] visited = new boolean[numberOfLocations];
        for (int i = 0; i < numberOfLocations; i++) {
            visited[i] = false;
        }
        return canTravelDFS(start, end, visited);
    }

    /**
     * Metoda DFS primeste ca parametru o locatie de start, una de end, si vectorul de locatii vizitate.
     * Fiind o functie recursiva, locatia start se va inlocui la fiecare apel, cu o locatie noua. Daca vreau sa ajung din A in C si am
     * drumurile AB si BC, initial apelez DFS(A,C,vizitat) dupa care gasesc drumul AB deci inseamna ca pot sa caut din B acum, apelez
     * cu DFS(B,C,vizitat). Gasesc drumul BC, deci inseamna ca pot sa plec din C sa caut, si apelez DFS(C,C,vizitat)
     * si cum locatia curenta de start(newStart), corespunde cu locatia de sfarsit(end), inseamna ca am ajuns, deci exista drumuri din A in C, si returnam true
     * Functia verifica initial daca locatia curenta de start(newStart) coincide cu locatia de sfarsit, daca da returnam true, intrucat am reusit sa ajungem in locatia dorita
     * Ulterior, aflu pozitia pt locatia newStart si astfel marchez locatia ca vizitata. Pentru fiecare drum din roads verific daca incepe cu locatia newStart si se termina
     * intr-o locatie diferita si nevizitata, inseamna ca am gasit un drum care pleaca din newStart, deci apelez functia DFS,
     * cu locatia de sfarsit a  drumului gasit ca noua locatie de start, si locatia de sfarsit initiala.
     * Daca niciun drum nu conduce catre locatia de sfarsit sau daca am vizitat toate locatiile fara sa gasim locatia de sfarsit
     * inseamna ca nu exista o secventa de drumuri, deci returnam fals
     * @param newStart-locatia in care am ajuns printr-un drum pornind de la start
     * @param end-locatia unde vreau sa ajung
     * @return-true if it is possible to go from one location newStart to end using the given roads, false otherwise
     */
    private boolean canTravelDFS(Location newStart, Location end, boolean[] visited) {
        if (newStart.equals(end)) {
            return true;
        }
        int newStartIndex = getLocationPosition(newStart);
        visited[newStartIndex] = true;
        for (int i = 0; i < numberOfRoads; i++) {
            if (!visited[getLocationPosition(roads[i].getEnd())] && roads[i].getStart().equals(newStart)) {
                if (canTravelDFS(roads[i].getEnd(), end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Returneaza o reprezentare a unui obiect de tip Problem sub forma unui string.
     * Problema va include numarul de locatii, numarul de drumuri, si descierera fiecaruia.
     * @return a string representation of the Problem object
     */
    @Override
    public String toString() {
        return "Instance of problem\n" +
                "NUMBER OF LOCATIONS:" + numberOfLocations +
                ", NUMBER OF ROADS:" + numberOfRoads + "\n" +
                "LOCATIONS:\n" + Arrays.toString(locations) +
                "\nROADS:\n" + Arrays.toString(roads)
                ;
    }
}
