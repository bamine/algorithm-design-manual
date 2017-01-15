package test.java.chapter02;

import main.java.chapter02.InsertionSort;
import main.java.chapter02.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

public class SortTests {
    @Test
    public void SelectionSortTest(){
        Integer[] a = new Integer[] {2, 4, 1, 7, 3, 9, 0};
        SelectionSort.sort(a);
        Assert.assertArrayEquals(a, new Integer[]{0, 1, 2, 3, 4, 7, 9});
    }

    @Test
    public void InsertionSortTest(){
        Integer[] a = new Integer[] {2, 4, 1, 7, 3, 9, 0};
        InsertionSort.sort(a);
        Assert.assertArrayEquals(a, new Integer[]{0, 1, 2, 3, 4, 7, 9});
    }
}
