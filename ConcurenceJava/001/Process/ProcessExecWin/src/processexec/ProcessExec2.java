/*
 * Copyright © <Pascal Fares @ ISSAE - Cnam Liban>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, 
 * fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, 
 * whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software. »
 */
package processexec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Notre premier example de création de processus fils suivi d'un recouvrement
 * Equivalent en C de : fork() -> exec()
 *
 * @author pascalfares
 */
public class ProcessExec2 {

    /**
     * Un chemin pour vos execution et réféence de fichier, adaptez le a votre
     * Environement
     */
    public static String CHEMIN = "c:\\Users";

    /**
     * Récuperer le standard output du processus fils
     *
     * @param p
     * @return
     */
    private static BufferedReader getOutput(Process p) {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    /**
     * Récuperer le standard error du processus fils
     *
     * @param p
     * @return
     */
    private static BufferedReader getError(Process p) {
        return new BufferedReader(new InputStreamReader(p.getErrorStream()));
    }

    private static PrintWriter getInput(Process p) {
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Début du programme 2");
        try {
            if (args.length == 1) {
                CHEMIN = args[0];
            }
            String[] commande = {"CMD.exe", "/C", "Dir", CHEMIN};
            Process p = Runtime.getRuntime().exec(commande);
            BufferedReader output = getOutput(p);
            BufferedReader error = getError(p);
            PrintWriter input = getInput(p);

            String ligne = "";

            input.printf("Un texte\n");
            input.flush();

            while ((ligne = output.readLine()) != null) {
                System.out.println(ligne);
            }

            while ((ligne = error.readLine()) != null) {
                System.out.println(ligne);
            }

            p.waitFor();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ProcessExec2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fin du programme 2");
    }

}
