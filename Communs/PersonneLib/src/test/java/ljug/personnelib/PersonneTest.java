/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ljug.personnelib;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cnamliban
 */
public class PersonneTest {
    
    public PersonneTest() {
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
     * Test of getNom method, of class Personne.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Personne instance = new Personne.Builder().nom("Pascal").build();
        String expResult = "Pascal";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrenom method, of class Personne.
     */
    @Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        Personne instance = new Personne.Builder().prenom("Pascal").build();
        String expResult = "Pascal";
        String result = instance.getPrenom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Personne.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Personne instance = new Personne.Builder().age(55).build();
        int expResult = 55;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Personne.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Personne instance = null;
        //instance.print();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printNomComplet method, of class Personne.
     */
    @Test
    public void testPrintNomComplet() {
        System.out.println("printNomComplet");
        Personne instance = null;
        //instance.printNomComplet();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Personne.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Personne instance = new Personne.Builder().build();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createShortList method, of class Personne.
     */
    @Test
    public void testCreateShortList() {
        System.out.println("createShortList");
        int expResult = 7;
        List<Personne> result = Personne.createShortList();
        assertEquals(expResult, result.size());
    }
    
}
