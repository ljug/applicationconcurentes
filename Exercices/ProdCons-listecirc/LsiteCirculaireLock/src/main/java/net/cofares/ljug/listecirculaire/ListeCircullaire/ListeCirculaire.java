package net.cofares.ljug.listecirculaire.ListeCircullaire;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.cofares.ljug.exeptions.ListePleine;
import net.cofares.ljug.exeptions.ListeVide;

/**
 *
 * @author Pascal Fares
 * @param <D> : Donnée générique de la liste
 */
public class ListeCirculaire<D> {

    private final D[] liste;
    private final int taille;
    private int nbElem;
    /**
     * debut et fin de la liste debut ou on peut écrire (la case est vide) fin
     * ou on peut lire (FIFO)
     *
     */
    private int debut, fin;

    Lock cle;
    Condition pleine;
    Condition vide;

    public ListeCirculaire(int taille) {
        liste = (D[]) new Object[taille];
        this.taille = taille;
        nbElem = debut = fin = 0; //la liste est vide
        cle = new ReentrantLock();
        pleine = cle.newCondition();
        vide = cle.newCondition();
    }

    public void put(D d) throws InterruptedException {
        cle.lock();
        try {
            //si liste pas pleine
            while (estPleine()) {
                pleine.await();
            }
            liste[debut] = d;
            debut = (debut + 1) % taille;
            nbElem++;
            vide.signalAll();
        } finally {
            cle.unlock();
        }
    }

    public D get() throws InterruptedException {       
        cle.lock();
        D d=null;
        try {
            //si liste pas vide
            while (estVide()) {
                vide.await();
            }
            d = liste[fin];
            fin = (fin + 1) % taille;
            nbElem--;
            pleine.signalAll();
        } finally {
            cle.unlock();
        }
        return d;
    }

    public boolean estPleine() {

        return (getNbElem() == taille);
    }

    public boolean estVide() {
        return (getNbElem() == 0);
    }

    /**
     * @return the nbElem
     */
    public int getNbElem() {
        return nbElem;
    }
}
