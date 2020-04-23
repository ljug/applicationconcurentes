package cddc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Exemple de données muttable, 
 * sera partagé entre plusieurs Threads
 *
 * @author Pascal Fares
 */
public class Data {

    private final AtomicInteger donnee;


    public Data() {
        donnee = new AtomicInteger(0);
    }

    /**
     * Incrémente et modifie la donnée
     */
    public void inc() {
        //1- getData : lire
        //2- +1
        //3- setData : ecrire
        donnee.incrementAndGet();
    }

    public int getDonnee() {
        return donnee.get();
    }

    public void setDonnee(int donnee) {
        this.donnee.set(donnee);
    }
}
