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
package Clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pascalfares
 */
public class ServiceInOut implements Runnable {

    private final String _arret;
    private final PrintWriter _out;
    private final BufferedReader _in;

    public ServiceInOut(BufferedReader in, PrintWriter out,String arret) {
        _in = in;
        _out = out;
        _arret=arret;
    }


    /**
     * Lire indiniment l'entrée et la restrasmettre à la sortie (tel quel)
     * Terminer lorque une ligen corrspondant à la commande d'arret est recu
     */
    @Override
    public void run() {
        try {
            String line;
            //System.out.println(_sens);
            while ((line = _in.readLine()) != null) {               
                _out.printf("%s\n", line);_out.flush();
                if (line.startsWith(_arret)) {
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
