package lab2.bonus;

import lab2.bonus.Location;

import java.util.Arrays;

import static java.lang.Math.sqrt;
public class Solution {
    private Location[] route;

    public Solution(Location[] route) {
        this.route = route;
    }

    public Location[] getRoute() {
        return route;
    }
    double euclidianDistance(Location start, Location end)
    {
        double x=start.getX() - end.getX();
        double y=start.getY() - end.getY();
        double euclidianDistance = sqrt(x*x+y*y);
        return euclidianDistance;
    }
    public double computeLength() {
        double length = 0.0;
        for (int i = 0; i < route.length - 1; i++) {
            length += euclidianDistance(route[i],(route[i+1]));
        }
        return length;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "route=" + Arrays.toString(route) +
                '}';
    }
}