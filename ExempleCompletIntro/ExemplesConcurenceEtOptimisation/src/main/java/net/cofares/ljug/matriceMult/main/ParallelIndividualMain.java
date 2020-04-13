package net.cofares.ljug.matriceMult.main;

import java.util.Date;
import lb.edu.isae.matrice.ParallelIndividualMultiplier;
import net.cofares.ljug.matriceMult.util.MatrixGenerator;

public class ParallelIndividualMain {

    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(2000, 2000);
        double matrix2[][] = MatrixGenerator.generate(2000, 2000);
        double resultParallel[][] = new double[matrix1.length][matrix2[0].length];

        Date start, end;

        System.out.println("Start");

        start = new Date();
        ParallelIndividualMultiplier.multiply(matrix1, matrix2, resultParallel);
        end = new Date();
        System.out.printf("Parallel Individual: %d%n", end.getTime() - start.getTime());

    }

}