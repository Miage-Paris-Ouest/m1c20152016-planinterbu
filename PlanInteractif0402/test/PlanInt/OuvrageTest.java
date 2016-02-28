/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanInt;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ibs
 */
public class OuvrageTest {
    
    public OuvrageTest() {
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
     * Test of rechercheparcote method, of class Ouvrage.
     */
    @Test
    public void testRechercheparcote() {
        System.out.println("rechercheparcote");
        String coteSaisie = "";
        Ouvrage instance = new Ouvrage();
        instance.rechercheparcote(coteSaisie);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of RechercheParDiscipline method, of class Ouvrage.
     */
    @Test
    public void testRechercheParDiscipline() {
        System.out.println("RechercheParDiscipline");
        String disc = "";
        Ouvrage instance = new Ouvrage();
        instance.RechercheParDiscipline(disc);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of RechercheParSsDiscipline method, of class Ouvrage.
     */
    @Test
    public void testRechercheParSsDiscipline() {
        System.out.println("RechercheParSsDiscipline");
        String ssDisc = "";
        Ouvrage instance = new Ouvrage();
        instance.RechercheParSsDiscipline(ssDisc);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of affichEtagere method, of class Ouvrage.
     */
     @Test
    public void testAffichEtagere() {
        System.out.println("affichEtagere");
        String coteSaisie = "111";
        String urlLue = "";
        Ouvrage instance = new Ouvrage();
        String expResult = "planEtageres38-39.png";
        String result = instance.affichEtagere(coteSaisie, urlLue);
        assertEquals(expResult, result);
    }

    /**
     * Test of affichDiscipline method, of class Ouvrage.
     */
    @Test
    public void testAffichDiscipline() {
        System.out.println("affichDiscipline");
        String discSaisie = "Philosophie";
        String urlLue = "";
        Ouvrage instance = new Ouvrage();
        String expResult = "salles_disciplines_philo.png";
        String result = instance.affichDiscipline(discSaisie, urlLue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of affichSsDiscipline method, of class Ouvrage.
     */
    @Test
    public void testAffichSsDiscipline() {
        System.out.println("affichSsDiscipline");
        String ssdiscSaisie = "Géographie universelle ";
        String urlLue = "";
        Ouvrage instance = new Ouvrage();
        String expResult = "disciplines_ssdisciplines_cotes_geouniv.png";
        String result = instance.affichSsDiscipline(ssdiscSaisie, urlLue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
