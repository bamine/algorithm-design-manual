package test.java.chapter02;

import main.java.chapter02.MatrixMultiplication;
import main.java.chapter02.StringMatching;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class OtherTests {
    @Test
    public void stringMatchigTest(){
        String s1 = "algorithm design manual";
        String s2 = "design";
        Optional<Integer> match = StringMatching.findMatch(s1, s2);
        Assert.assertTrue(match.isPresent() && match.get() == 10);
    }

    @Test
    public void matrixMultiplicationTest(){
        double[][] a = {{1, 0, 0},{0, 1, 0},{0, 0, 1}};
        double[][] b = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};

        double[][] c = MatrixMultiplication.multiply(a, b);
        for(int i=0; i<c.length; i++){
            for(int j=0; j<c[i].length; j++){
                Assert.assertTrue(c[i][j] == b[i][j]);
            }
        }
    }
}
