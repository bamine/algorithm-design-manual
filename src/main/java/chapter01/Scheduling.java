package main.java.chapter01;

import java.util.*;
import java.util.stream.Collectors;

public class Scheduling {
    public static class Segment {
        public double start;
        public double end;
        public Segment(double start, double end){
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Segment other){
            return !(this.start > other.end || this.end < other.start);
        }
    }

    public static List<Segment> earliestJobFirst(List<Segment> segments){
        List<Segment> jobs = new ArrayList<>();
        for(Segment segment: segments.stream().sorted(Comparator.comparingDouble(s -> s.start)).collect(Collectors.toList())){
            if(jobs.stream().noneMatch(s -> s.overlaps(segment))){
                jobs.add(segment);
            }
        }
        return jobs;
    }

    public static List<Segment> shortestJobFirst(List<Segment> segments){
        List<Segment> jobs = new ArrayList<>();
        for(Segment segment: segments.stream().sorted(Comparator.comparingDouble(s -> s.end - s.start)).collect(Collectors.toList())){
            if(jobs.stream().noneMatch(s -> s.overlaps(segment))){
                jobs.add(segment);
            }
        }
        return jobs;
    }
}
