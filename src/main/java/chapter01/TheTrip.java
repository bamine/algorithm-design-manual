package main.java.chapter01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class TheTrip {
    public static double computeMinimumExchange(double[] expenses){
        double average = Arrays.stream(expenses).average().orElse(0);
        double pos = 0;
        double neg = 0;
        for(double expense: expenses){
            if(expense < average) pos += Math.floor((average - expense)*100)/100;
            else neg += Math.floor((expense - average)*100)/100;
        }
        return Math.max(-neg, pos);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            if(n == 0) break;
            double[] expenses = new double[n];
            for(int i=0; i<n; i++){
                expenses[i] = scan.nextDouble();
            }
            double minimum = computeMinimumExchange(expenses);
            System.out.println(String.format("$%.2f", minimum));
        }
    }
}
