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
public class CDDC {

    /**
     * Code différents Données commune
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data d=new Data();
        Runnable tache1= new Tache1(d);
        Runnable tache2= new Tache2(d);
        
        Thread t1=new Thread(tache1);
        Thread t2=new Thread(tache2);
        
        t1.start();
        t2.start();
        System.out.println("\nSe termine "+ d.getDonee());
    }
    
}
