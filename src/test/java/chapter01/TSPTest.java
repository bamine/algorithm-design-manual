package test.java.chapter01;

import main.java.chapter01.TSP;
import main.java.chapter01.TSP.Point;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class TSPTest {
    @Test
    public void runTest(){
        Point[] points = new Point[] {
                new Point(0, 0),
                new Point(1, 0),
                new Point(-21, 0),
                new Point(-1, 0),
                new Point(-5, 0),
                new Point(11, 0),
                new Point(3, 0)
        };

        List<Point> path = TSP.nearestNeighborTSP(points);
        for(Point p: path){
            System.out.println(p.toString());
        }
    }
}