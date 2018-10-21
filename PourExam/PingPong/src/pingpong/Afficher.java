/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

/**
 *
 * @author Pascal Fares
 */
public class Afficher implements Runnable {
    final String moi;
    public Afficher(String m){
        moi=m;
    }
    @Override
    public void run() {
        while (true) System.err.println(moi);
    } 
}
