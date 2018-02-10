/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouclepourtestjconsole;

/**
 *
 * @author Pascal Fares
 */
public class Binfini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Hello ....");
        while (true) {
            System.out.print(".");
            Thread.sleep(500);
        }

    }
}
