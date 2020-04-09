/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lb.edu.isae.matrice;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Pascal Fares
 */
public class Matrice {

    public double[][] matrice;

    public Matrice(int nbLignes, int nbColonnes) {
        matrice = new double[nbLignes][nbColonnes];
    }

    public Matrice(double[][] matrice) {
        this.matrice = matrice;
    }

    public static Matrice fabrique(int nbLignes, int nbColonnes) {
        Matrice res = new Matrice(nbLignes, nbColonnes);
        Random random = new Random();
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                res.matrice[i][j] = random.nextDouble() * 10;
            }
        }
        return res;
    }

    public static Matrice multiply(double[][] matrice1, double[][] matrice2) {
        int nbLigneM1 = matrice1.length;
        int nbColonnesM1 = matrice1[0].length;

        int NbColonnesM2 = matrice2[0].length;

        Matrice result = new Matrice(nbLigneM1, NbColonnesM2);
        for (int i = 0; i < nbLigneM1; i++) {
            for (int j = 0; j < NbColonnesM2; j++) {
                result.matrice[i][j] = 0.;
                for (int k = 0; k < nbColonnesM1; k++) {
                    result.matrice[i][j] += matrice1[i][k] * matrice2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String... args) {
        Matrice m1 = fabrique(2000, 2000);
        System.out.println(m1);
        Matrice m2 = fabrique(2000, 2000);
        System.out.println(m2);

        Date start = new Date();
        Matrice resultat = multiply(m1.matrice, m2.matrice);
        Date end = new Date();
        long tot=end.getTime() - start.getTime();
        System.out.printf("Serial: %ds%dms%n", tot/1000,tot%1000);
    }
}
