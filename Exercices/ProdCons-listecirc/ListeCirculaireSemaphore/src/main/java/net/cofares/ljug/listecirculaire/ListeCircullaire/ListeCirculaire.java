package net.cofares.ljug.listecirculaire.ListeCircullaire;

import java.util.concurrent.Semaphore;
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
    
    Semaphore mutex;
    Semaphore vide;
    Semaphore plein;
    /**
     * debut et fin de la liste
     * debut ou on peut ecrire (la case est vide)
     * fin ou on peut lire (FIFO) 
     * 
     */
    private int debut,fin; 
    public ListeCirculaire(int taille) {
        liste = (D[]) new Object[taille];
        this.taille=taille;
        nbElem=debut=fin=0; //la liste est vide
        mutex = new Semaphore(1);
        //Nb de case vide
        vide=new Semaphore(taille);
        //nombre délément dans la file
        plein=new Semaphore(0);
                
    }
    public void put(D d) throws ListePleine{
        //si liste pas pleine
        vide.acquireUninterruptibly();
        mutex.acquireUninterruptibly();
        liste[debut]=d;
        debut = (debut+1) % taille;
        nbElem++;
        mutex.release();
        plein.release();
    }
    public D get() throws ListeVide{
        //si liste pas vide
        plein.acquireUninterruptibly();
        mutex.acquireUninterruptibly();
        D d=liste[fin];
        fin = (fin+1) % taille;
        nbElem--;
        mutex.release();
        vide.release();
        return d;
    }
    
    /*
    Avec la solution sémaphore pas bespon de ces 2 méthodes
    public boolean estPleine() {
        
        return (getNbElem()==taille);
    }
    
    public boolean estVide() {
        return (getNbElem()==0);
    }
    */

    /**
     * @return the nbElem
     */
    public int getNbElem() {
        return nbElem;
    }
}
