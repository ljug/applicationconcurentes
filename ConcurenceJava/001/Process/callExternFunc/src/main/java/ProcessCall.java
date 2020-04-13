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
public class ProcessCall {

    /**
     * Un chemin pour vos execution et réféence de fichier, adaptez le a votre
     * Environement
     */
    public static final String CHEMIN = "c:\\Users";

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
     * @param param Le parametre a nvoyer a python
     * @param output python => java
     * @param error Python => java si erreurs
     * @param input java => python
     * @return Le resultat appel du script python
     */
    public static String call(String param,
        BufferedReader output, BufferedReader error, PrintWriter input) {
        String ligne;
        String res="";
        try {
            System.out.println("Envoi de " + param);
            input.println(param);
            input.flush();
            while ((ligne = output.readLine()) != null) {
                System.out.println(ligne);
                if (ligne.equals("end")) {
                    System.out.printf("%d <%s>",ligne.length(),ligne);
                    break;
                }
                res += ligne;
                
            }
            System.out.println("En principe res= " + res);
                     
            while ((ligne = error.readLine()) != null) {
                System.out.println("err: " + ligne);
                if(ligne.equals("ok"))  break;                
                throw new Exception("Erreur du script python");
            }
         
            System.out.println("En principe res 2= " + res);
        } catch (IOException ex) {
            Logger.getLogger(ProcessCall.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProcessCall.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Début du programme 2");
        try {
            if (args.length == 0) {
                System.out.println("Utilisation: java ProcessCall <scriptPython> [params]");
                System.exit(1);
            }
            String[] commande = new String[args.length + 1];
            commande[0] = "python.exe";
            //The args of main are pythonscript.py [params] ...
            System.arraycopy(args, 0, commande, 1, args.length);
            for (String commande1 : commande) {
                System.out.printf("%s ", commande1);
            }
            System.out.println();
            Process p = Runtime.getRuntime().exec(commande);
            BufferedReader output = getOutput(p);
            BufferedReader error = getError(p);
            PrintWriter input = getInput(p);

            String res = call("10", output, error, input);
            System.out.println("Res call 10="+res);
            call("20", output, error, input);
            System.out.println("Res call 20="+res);
            call("stop", output, error, input);


            p.waitFor();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ProcessCall.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fin du programme 2");
    }

}
