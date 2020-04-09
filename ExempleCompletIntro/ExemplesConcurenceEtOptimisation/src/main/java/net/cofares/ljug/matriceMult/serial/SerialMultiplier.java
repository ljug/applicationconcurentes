package net.cofares.ljug.matriceMult.serial;

import net.cofares.ljug.matriceMult.util.MatrixGenerator;

public class SerialMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        int rows1 = matrix1.length;
        for (int i = 0; i < rows1; i++) {
            MatrixGenerator.rowMultiplier(result, matrix1, matrix2, i);
        }

    }

}
