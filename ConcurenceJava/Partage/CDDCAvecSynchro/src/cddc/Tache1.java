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
public class Tache1 implements Runnable {

    private Data reftoData;

    public Tache1(Data data) {
        reftoData = data;
    }

    @Override
    public void run() {
        System.out.println("debut t1");
        for (int i = 0; i < 100000; i++) {
            synchronized (reftoData) {
                reftoData.inc();
            }
            //System.out.printf(" ...T1 Priv : %d Glob: %d... ", 
            //i, reftoData.getDonee());
        }
        System.out.println("fin t1");
    }

}
