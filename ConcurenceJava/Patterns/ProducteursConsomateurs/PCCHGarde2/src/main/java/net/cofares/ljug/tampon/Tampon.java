/*
 * Copyright © <copyright holders>
 * ISSAE - Cnam Liban
 * Pascal Fares
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, 
 * fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, 
 * whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software. »
 */
package net.cofares.ljug.tampon;

import java.util.LinkedList;
import net.cofares.ljug.garde.Garde;
import net.cofares.ljug.prodcons.Consomateur;
import net.cofares.ljug.prodcons.Producteur;

/**
 *
 * @author pascalfares
 */
public class Tampon {

    /**
     * Le contenu : une liste avec nombre max d'élement
     */
    private final LinkedList<String> tampon;
    private final int MAXELEM;
    private int nbElem;
    /**
     * Donnée disponible dans le cube?
     */
    final Garde plein;
    final Garde vide;

    public Tampon(int max) {
        MAXELEM = max;
        nbElem = 0;
        tampon = new LinkedList<>();
        //2 moniteur vide et plein
        vide = new Garde(true);
        plein = new Garde(false);
    }

    private String consommeAction() {
        //Une élément dans le tampon, get va le retiré
        assert nbElem > 0 : "Oups j'ai un bug nbElem ==0!";
        String contents = tampon.remove();
        nbElem--;
        //Bloquerer les lecteurs si vide
        if (nbElem == 0) {
            vide.setGarde(true);
        }
        //Liberer les producteur (on vient de liberer une place)
        plein.setGarde(false); //n'est plus plein
        return contents;
    }

    public String consomme() {
        // when non vide => On va consomer une donnée
        synchronized (vide) {
            vide.notGarde(); //when not vide
            return consommeAction(); //action de l'opération get
        }
    }
    private void produireAction(String value) {
        //on dépose donc plein et nonVide
        assert nbElem < MAXELEM;
        tampon.add(value);
        nbElem++;
        if (nbElem == MAXELEM) {
            plein.setGarde(true);
        }
        vide.setGarde(false); //le tampon n'est plus vide
    }

    public void produire(String value) {
        synchronized (plein) {
            plein.notGarde(); //when not plein
            produireAction(value); //Action put
        }
    }

    /**
     * Pour le test
     *
     * @param args
     */
    public static void main(String[] args) {
        Tampon c = new Tampon(3);
        //Producteur p1 = new Producteur(c, 1);
        Consomateur c1 = new Consomateur(c, 1);
        Consomateur c2 = new Consomateur(c, 2);
        //p1.start();
        c1.start();
        c2.start();
        Producteur p1 = new Producteur(c, 1);
        p1.start();
    }
}
