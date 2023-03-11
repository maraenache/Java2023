package lab2.homework;

public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem();
        City city1 = new City("Iasi", 150.0, 250.0, 300_000);
        City city1b = new City("Iasi", 300_000);//acelasi nume
        City city1c = new City("Bucuresti", 1_000_000);//nume diferit, dar tot oras si la aceleasi coordonate ca un oras existent
        City city2 = new City("Brasov", 350.0, 550.0, 250_000);
        City city3 = new City(330_000);
        city3.setName("Suceava");
        city3.setX(700.0);
        city3.setY(800.0);

        GasStation gasStation1 = new GasStation("MOL Miroslava", 950.0, 600.0, 6.5);
        GasStation gasStation2 = new GasStation("PETROM Iasi", 400.0, 200.0, 7.0);
        GasStation gasStation3 = new GasStation("Lukoil Brasov", 250.0, 900.0, 7.5);

        Airport airport1 = new Airport("Airport Suceava", 600.0, 400.0, 5);
        Airport airport2 = new Airport("Airport Constanta", 800.0, 300.0, 10);


        problem.addLocation(city1);
        problem.addLocation(city2);
        problem.addLocation(city3);

        problem.addLocation(gasStation1);
        problem.addLocation(gasStation2);
        problem.addLocation(gasStation3);

        problem.addLocation(airport1);
        problem.addLocation(airport2);

        Highway highway1 = new Highway("H12", city1, city2, 450);
        highway1.setSpeedLimit(80);
        highway1.setLength(500);

        Highway highway2 = new Highway("H23", city2, city3, 100, 800, 150);

        Express express1 = new Express("E31", city3, airport1, 120, 1000, 4);
        Express express2 = new Express("E12", airport1, airport2, 80, 600, 5);

        Country country1 = new Country("C13", airport2, gasStation1, 60, 700, 50);
        Country country2 = new Country("C23", city1, airport1, 40,600,200);

        problem.addRoad(highway1);
        problem.addRoad(highway2);

        problem.addRoad(express1);
        problem.addRoad(express2);

        problem.addRoad(country1);
        problem.addRoad(country2);

        System.out.println(problem);

        if (problem.validInstanceOfProblem()) {
            System.out.println("Valid instance of problem");
        } else {
            System.out.println("Invalid instance of problem");
        }

       if (problem.canTravel(city1, city3)) {
            System.out.println("You can travel from " + city1.getName() + " to " + city3.getName() + " using given roads");
        } else {
            System.out.println("You can't travel from " + city1.getName() + " to " + city3.getName() + " using given roads");
        }
        if (problem.canTravel(city1, airport1)) {
            System.out.println("You can travel from " + city1.getName() + " to " + airport1.getName() + " using given roads");
        } else {
            System.out.println("You can't travel from " + city1.getName() + " to " + airport1.getName() + " using given roads");
        }
    }

}
