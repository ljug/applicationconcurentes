/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkjoin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author pascalfares
 */
public class ForkJoin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String nchemin="/home/pascalfares/";
        if (args.length == 1) {
            nchemin=args[0];
        }
        Path chemin = Paths.get(nchemin);
        String filtre = "*.java";
    
    //Création de notre tâche principale qui se charge de découper son travail en sous-tâches
    FolderScanner fs = new FolderScanner(chemin, filtre);
    
    //Nous récupérons le nombre de processeurs disponibles
    int processeurs = Runtime.getRuntime().availableProcessors();
    //Nous créons notre pool de thread pour nos tâches de fond
    System.out.println("Nb precessor = "+ processeurs);
    ForkJoinPool pool = new ForkJoinPool(processeurs/2);
    Long start = System.currentTimeMillis();
    
    //Nous lançons le traitement de notre tâche principale via le pool
    pool.invoke(fs);
    
    Long end = System.currentTimeMillis();
    System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
    System.out.println("Temps de traitement : " + (end - start));    
    }
    
}
