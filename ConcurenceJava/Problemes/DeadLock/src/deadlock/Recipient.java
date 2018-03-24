/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

import java.io.Serializable;

/**
 *
 * @author Pascal Fares
 */
public class Recipient implements Serializable {

    // permet de savoir si le verre est vide ou pas
    private boolean plein = false;

    // un verre a besoin d'une carafe pour se remplir
    private Recipient lautre;

    private String nomRecipient;
    
    public Recipient(String nom) {
        nomRecipient=nom;
    }
    // on ne peut se remplir que si l'autre est pleine
    public synchronized void remplis() {
        if (getLautre().isPlein()) {
            System.out.printf("le travailleur %s rempli %s ", Thread.currentThread(),this);
            plein = true;
            getLautre().setPlein(false);
            System.out.printf("En vidant %s\n",lautre);
        }
    }

    // et l'on ne peut se vider que si l'autre e est vide
    public synchronized void vide() {
        if (!lautre.isPlein()) {
            System.out.printf("le travailleur %s vide %s ", Thread.currentThread(),this);
            plein = false;
            getLautre().setPlein(true);
            System.out.printf("En remplissant %s\n",lautre);
        }
    }

    // permet au monde extérieur de savoir
    // si nous sommes plein ou vide
    public synchronized boolean isPlein() {
        return this.plein;
    }

    // reste des getters non synchronisé
    public void setPlein(boolean plein) {
        this.plein = plein;
    }

    /**
     * @return the lautre
     */
    public Recipient getLautre() {
        return lautre;
    }

    /**
     * @param lautre the lautre to set
     */
    public void setLautre(Recipient lautre) {
        this.lautre = lautre;
    }
    
    @Override
    public String toString(){
        return ("Je suis "+nomRecipient);
    }

}
