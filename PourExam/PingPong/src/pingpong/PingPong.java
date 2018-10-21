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
public class PingPong {
    public static void main(String[] args) {
        new Thread(new Afficher("ping")).start();
        new Thread(new Afficher("pong")).start();    
    }   
}
