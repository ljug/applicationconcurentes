/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billes;

import java.awt.Point;
import net.cofares.sgraphic.Fenetre;

/**
 *
 * @author pascalfares
 */
public class PlusieursBilles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fenetre f = new Fenetre(300,200, "title","light slate gray");
        Point p1 = new Point(150, 120);
        Point dx1 = new Point(2, 1);
        Point dx2 = new Point(1,2);
        Point dx3 = new Point(-1,-2);
        //f.remplir("light slate gray");
        
        UneBille cote1 = new UneBille(f, p1, dx1, "red");
        
        UneBille cote2 = new UneBille(f, p1, dx2, "blue");
        
        UneBille cote3 = new UneBille(f, p1, dx3, "lime");
        
        Thread t1 = new Thread(cote1);
        Thread t2 = new Thread(cote2);
        Thread t3 = new Thread(cote3);
        t1.start();t2.start();t3.start();
    }
    
}
