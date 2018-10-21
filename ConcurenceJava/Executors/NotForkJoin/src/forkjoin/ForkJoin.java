/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkjoin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        FolderScanner fs = new FolderScanner(chemin, filtre);

        try {
            Long start = System.currentTimeMillis();
            Long resultat = fs.sequentialScan();
            Long end = System.currentTimeMillis();
            System.out.println("Il y a " + resultat + " fichier(s) portant l'extension " + filtre);
            System.out.println("Temps de traitement : " + (end - start));
        } catch (ScanException ex) {
            Logger.getLogger(ForkJoin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
