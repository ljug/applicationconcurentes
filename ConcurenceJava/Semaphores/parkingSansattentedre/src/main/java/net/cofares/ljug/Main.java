/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.cofares.ljug.parking.Parking;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Main {

    public static void main(String... args) {
        Parking parking = new Parking(10);
        Runnable voiture = () -> {
            if (parking.entrer()) {
                parking.seGarer();
                parking.sortir();
            } else {
                System.out.println("Pas de palce je repart .."+Thread.currentThread());
            }
        };
        //Simulons 100 voiture souhaitant entrer dans le parking
        for (int i = 0; i < 100; i++) {
            Thread v = new Thread(voiture, "v" + i);
            v.start();
        }
    }

}
