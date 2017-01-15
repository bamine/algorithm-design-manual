package main.java.chapter02;

public class SelectionSort {
    public static <T extends Comparable<T>> void sort(T[] a){
        int n = a.length;
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=i; j<n; j++){
                if(a[j].compareTo(a[min]) < 0) min = j;
            }
            T tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
