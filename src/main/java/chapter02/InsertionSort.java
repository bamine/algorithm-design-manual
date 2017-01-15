package main.java.chapter02;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] a){
        for(int i=0; i<a.length; i++){
            int j=i;
            while(j > 0 && a[j].compareTo(a[j-1])<0){
                T tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
                j = j-1;
            }
        }
    }
}
