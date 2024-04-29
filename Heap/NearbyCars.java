import java.util.*;
/**
 * 
 * NearbyCars
 * we are given a N points in a 2D plan which are locaition of N cars.
 * If we are at the origin, print the nearest K cars.
 * 
 */
public class NearbyCars {
    static class Point implements Comparable<Point> {
        String name;
        double distance;

        Point(String name, double distance) {
            this.name = name;
            this.distance = distance;
        }
        @Override
        public int compareTo(Point o) {
            return (int) (this.distance - o.distance);
        }
    }

    public static void main(String[] args) {
        // in co-ordinates distance = (x^2  + y^2) ^ 1/2. (origin)
        
        PriorityQueue<Point> nearCars = new PriorityQueue<>();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;

        for (int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            nearCars.add(new Point("Car no: " + i, distance));
        }

        for (int i = 0; i < K; i++) {
            System.out.println((nearCars.poll().name));
        }
    }
}