/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.parking;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Parking implements ParkingIntf {

    Semaphore park;

    public Parking(int n) {
        park = new Semaphore(n, true);
    }

    @Override
    public boolean entrer() {
        return park.tryAcquire();

    }

    @Override
    public void sortir() {
        park.release();
    }

    @Override
    public String seGarer() {
        System.out.printf("La voiture se gare..." + Thread.currentThread());
        try {
            //Simuler le temps de parking
            Thread.sleep((long) (Math.random() * 10000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Puis fini par repartir ... " + Thread.currentThread());
        return Thread.currentThread().toString();
    }

}
