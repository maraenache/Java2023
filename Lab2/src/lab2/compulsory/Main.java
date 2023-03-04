package lab2.compulsory;

public class Main {
    public static void main(String[] args) {

        LocationType locationType1 = LocationType.GAS_STATION;
        LocationType locationType2 = LocationType.CITY;
        LocationType locationType3 = LocationType.AIRPORT;
        Location location1 = new Location("Negresti", locationType1, 16.2, 89.78);
        Location location2 = new Location("Brasov", locationType2, 247.77, 39);
        Location location3 = new Location("Suceava", locationType3, 167.77, 99);
        System.out.println(location1);
        System.out.println(location2);
        System.out.println(location3);
        Location location4 = new Location();
        location4.setName("Iasi");
        location4.setX(25.0);
        location4.setY(9.6);
        System.out.println(location4);
        Location location5 = new Location("Vaslui", 10.0, 29.6);
        System.out.println(location5);


        RoadType roadType1 = RoadType.COUNTRY;
        RoadType roadType2 = RoadType.EXPRESS;
        RoadType roadType3 = RoadType.HIGHWAY;
        Road road1 = new Road("D24", roadType1, 70, location4, location5);

        Road road2 = new Road("A2", 150, 180, roadType2);
        Road road3 = new Road(120, 400, roadType3);
        road3.setName("A3");

        Road road4 = new Road("D34", RoadType.EXPRESS, 100, location2, location3);

        Road road5 = new Road();
        road5.setName("D23");
        road5.setLength(120);
        road5.setSpeedLimit(70);
        road5.setType(RoadType.HIGHWAY);

        System.out.println(road1);
        System.out.println(road2);
        System.out.println(road3);
        System.out.println(road4);
        System.out.println(road5);
    }
}