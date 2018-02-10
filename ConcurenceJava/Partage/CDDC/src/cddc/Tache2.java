/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cddc;

/**
 *
 * @author Pascal Fares
 */
public class Tache2 implements Runnable {

    private Data referenceDonnees;
    private int DonneePrivee;

    public Tache2(Data data) {
        referenceDonnees = data;
    }

    @Override
    public void run() {
        System.out.println("debut t2");
        while (DonneePrivee < 100000) {
            referenceDonnees.inc();
            DonneePrivee++;
            //System.out.printf(" <T2 Priv : %d Glob: %d> ", 
                    //DonneePrivee, referenceDonnees.getDonee());
        }
        System.out.println("fin t2");
    }

}
