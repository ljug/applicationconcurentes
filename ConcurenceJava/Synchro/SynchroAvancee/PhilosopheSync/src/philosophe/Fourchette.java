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
package philosophe;

/**
 *
 * @author pascalfares
 */
class Fourchette {

    /**
     * une fourchette est libre (prise==false)
     * ou prise (prise==true)
     */
    private boolean prise = false;

    /**
     * <h1>Commande gardée</h1>
     * Condition -> action
     * <h2>en Java<h2>
     * while (not Condition) wait();
     * doAction()
     */
    public synchronized void prendre() {
        // fouchetteLibre -> prendreFourchette
        // fourchetteLibre == not prise
        // prendreFourchette == prese=true
        
        while (prise) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            };
        }
        prise = true;
    }

    //Condition change notifié les gardes
    public synchronized void poser() {
        prise = false;
        this.notify();
    }
}
