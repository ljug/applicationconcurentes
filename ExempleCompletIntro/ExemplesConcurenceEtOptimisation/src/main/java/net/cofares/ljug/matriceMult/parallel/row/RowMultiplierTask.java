package net.cofares.ljug.matriceMult.parallel.row;

import net.cofares.ljug.matriceMult.util.MatrixGenerator;

public class RowMultiplierTask implements Runnable {

    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private final int row;

    public RowMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int i) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = i;
    }

    @Override
    public void run() {
        MatrixGenerator.rowMultiplier(result, matrix1, matrix2, row);
    }

}
