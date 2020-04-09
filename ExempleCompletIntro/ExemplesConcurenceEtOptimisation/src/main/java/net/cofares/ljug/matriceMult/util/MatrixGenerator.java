package net.cofares.ljug.matriceMult.util;

import java.util.Random;

public class MatrixGenerator {

    public static double[][] generate(int rows, int columns) {
        double[][] ret = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ret[i][j] = random.nextDouble() * 10;
            }
        }
        return ret;
    }

    public static void individualMultiplier(double[][] result,
            double[][] matrix1, double[][] matrix2,
            int row, int column) {
        result[row][column] = 0;
        for (int k = 0; k < matrix1[row].length; k++) {
            result[row][column] += matrix1[row][k] * matrix2[k][column];
        }
    }

    public static void rowMultiplier(double[][] result,
            double[][] matrix1, double[][] matrix2,
            int row) {
        int columns2 = matrix2[0].length;
        for (int j = 0; j < columns2; j++) {
            individualMultiplier(result, matrix1, matrix2, row, j);
        }
    }
}
