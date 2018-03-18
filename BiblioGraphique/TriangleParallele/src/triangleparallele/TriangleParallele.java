/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleparallele;

import java.awt.Point;
import net.cofares.sgraphic.Fenetre;

/**
 *
 * @author pascalfares
 */
public class TriangleParallele {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fenetre f = new Fenetre(300, 300, "title");
        Point p1 = new Point(50, 20);
        Point p2 = new Point(200, 100);
        Point p3 = new Point(40,250);
        
        UnCote cote1 = new UnCote(f, p1, p2, "red");
        
        UnCote cote2 = new UnCote(f, p2, p3, "blue");
        
        UnCote cote3 = new UnCote(f, p3, p1, "lime");
        
        Thread t1 = new Thread(cote1);
        Thread t2 = new Thread(cote2);
        Thread t3 = new Thread(cote3);
        t1.start();t2.start();t3.start();
    }
    
}
