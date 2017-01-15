package main.java.chapter01;

import java.util.*;

public class TSP {
    public static class Point {
        double x;
        double y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point other){
            return Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2);
        }
        public String toString() { return "Point(" +x + "," + y + ")"; }
    }

    public static List<Point> nearestNeighborTSP(Point[] points){
        ArrayList<Point> path = new ArrayList<>();
        Set<Point> visited = new HashSet<>();
        Point p = points[0];
        visited.add(p);
        path.add(p);
        while(visited.size() < points.length){
            p = closest(p, points, visited).orElse(null);
            visited.add(p);
            path.add(p);
        }
        return path;
    }

    public static Optional<Point> closest(Point p, Point[] points, Set<Point> visited){
        return Arrays.stream(points)
                .filter(p1 -> !visited.contains(p1))
                .min(Comparator.comparingDouble(p2 -> p2.distanceTo(p)));
    }
}
