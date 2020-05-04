/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.moniteurs;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Exemple {
    public static void main(String ...args) {
        Runnable paire = new Compteur2En2(0, 100);
        Runnable impaire = new Compteur2En2(1, 100);
        
        Thread t1=new Thread(paire, "paire");
        Thread t2=new Thread(impaire, "impaire");
    }
}
