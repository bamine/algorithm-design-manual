package test.java.chapter01;

import main.java.chapter01.Scheduling;
import main.java.chapter01.Scheduling.Segment;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class SchedulingTest {
    @Test
    public void earlisestJobTest(){
        ArrayList<Segment> segments = new ArrayList<>(Arrays.asList(new Segment[]{
                new Segment(3, 5),
                new Segment(1, 4),
                new Segment(2, 3),
                new Segment(4.5, 7),
                new Segment(6.5, 10),
                new Segment(9, 12),
                new Segment(9.5, 11),
                new Segment(3.5, 6),
                new Segment(10.5, 12.5)
        }));
        List<Segment> jobs = Scheduling.earliestJobFirst(segments);
        for(Segment s: jobs){
            System.out.println(s);
        }

        jobs = Scheduling.shortestJobFirst(segments);
        for(Segment s: jobs){
            System.out.println(s);
        }
    }
}
