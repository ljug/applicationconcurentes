/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.sgraphic;

import java.awt.Point;

/**
 *
 * @author pascalfares
 */
public class Triangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fenetre f = new Fenetre(300, 300, "title");
        Point p1 = new Point(50, 20);
        Point p2 = new Point(200, 100);
        Point p3 = new Point(40,250);
        f.tracerLignePointAPoint(p1, p2, "red");
        f.tracerLignePointAPoint(p2, p3, "blue");
        f.tracerLignePointAPoint(p3, p1, "lime");
    }
    
}
