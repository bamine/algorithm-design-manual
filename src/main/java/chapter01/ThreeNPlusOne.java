package main.java.chapter01;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ThreeNPlusOne {
    public static int cycleLength(int a){
        int l = 1;
        while(a > 1){
            if(a%2 == 1) a = 3*a+1;
            else a = a/2;
            l++;
        }
        return l;
    }
    public static int maxCycleLength(int a, int b){
        return IntStream.range(a, b+1).map(n -> cycleLength(n)).max().orElse(0);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println(a + " " + b + " " + maxCycleLength(Math.min(a, b), Math.max(a, b)));
        }
    }
}
