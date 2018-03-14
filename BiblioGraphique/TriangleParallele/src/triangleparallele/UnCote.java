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
public class UnCote implements Runnable {
    Point _p1,_p2;
    Fenetre _f;
    String _couleur;
    public UnCote(Fenetre f,Point p1,Point p2, String couleur){
        _f=f;
        _p1=p1;
        _p2=p2;
        _couleur=couleur;
    }
    @Override
    public void run() {
        _f.tracerLignePointAPoint(_p1, _p2, _couleur);
    }
    
}
