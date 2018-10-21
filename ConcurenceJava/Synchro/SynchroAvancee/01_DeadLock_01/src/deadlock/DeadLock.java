/*
 * Copyright © <Pascal Fares @ ISSAE - Cnam Liban>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, 
 * fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, 
 * whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software. »
 */
/**
 * Version clone de synchronized
 */
package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author pascalfares
 */
public class DeadLock {

    public static boolean DEBUG = true;

    static class Friend {

        private final Lock verrou = new ReentrantLock();
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void fleche(Friend lanceur) {
            if (DeadLock.DEBUG) {
                System.out.printf("%nEF %s : <- %s ?.. ", this.name, lanceur.name);
            }
            verrou.lock();

            if (DeadLock.DEBUG) {
                System.out.printf("%nF %s : <- %s oui.. ", this.name, lanceur.name);
            } else {
                System.out.format("F %s: %s"
                        + "  me lance une flèche!%n",
                        this.name, lanceur.getName());
            }
            lanceur.flecheRetour(this);
            if (DeadLock.DEBUG) {
                System.out.printf("%nF V %s : <- %s .. ", this.name, lanceur.name);
            }

        }

        public void flecheRetour(Friend lanceur) {
            if (DeadLock.DEBUG) {
                System.out.printf("%nEFR %s : <- %s ?.. ", this.name, lanceur.name);
            }

            if (DeadLock.DEBUG) {
                System.out.printf("%nFR %s : <- %s oui.. ", this.name, lanceur.name);
            } else {
                System.out.format("FR V %s: %s"
                        + " m'a relencé une flèche!%n",
                        this.name, lanceur.getName());
            }

            verrou.unlock();

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Friend alphonse
                = new Friend("A");
        final Friend gaston
                = new Friend("B");
        new Thread(() -> {
            while (true) {
                alphonse.fleche(gaston);
            }
        }).start();

        new Thread(() -> {
            while (true) {
                gaston.fleche(alphonse);
            }
        }).start();
        /**/
    }

}
