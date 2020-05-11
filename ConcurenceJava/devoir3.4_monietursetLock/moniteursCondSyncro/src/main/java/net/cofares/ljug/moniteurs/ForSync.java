/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.moniteurs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class ForSync {

    /**
     * @return the l
     */
    public Lock getL() {
        return l;
    }

    /**
     * @return the cpair
     */
    public Condition getCpair() {
        return cpair;
    }

    /**
     * @return the cimpair
     */
    public Condition getCimpair() {
        return cimpair;
    }
    private final Lock l = new ReentrantLock();
    private final Condition cpair = l.newCondition();
    private final Condition cimpair = l.newCondition();
}
