package main.java.chapter02;

public class MatrixMultiplication {
    public static double[][] multiply(double[][] a, double[][] b){
        assert a[0].length == b.length;
        double[][] c = new double[a.length][b[0].length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<b[i].length; j++){
                c[i][j] = 0;
                for(int k=0; k<b.length; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
