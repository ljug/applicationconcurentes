/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cddc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author pfares
 */
public class CDDCTest {

    public CDDCTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class CDDC.
     */
    @Test
    public void testMain() throws InterruptedException {
        Data d = new Data();

        Tache1 tache1 = new Tache1(d);
        Tache2 tache2 = new Tache2(d);

        Thread t1 = new Thread(tache1);
        Thread t2 = new Thread(tache2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertEquals("Boucle t1 + t2 n'est pas identique a t1+t2!", tache1.getDonneePriv() + tache2.getDonneePrivee(), d.getDonnee());
    }

}
