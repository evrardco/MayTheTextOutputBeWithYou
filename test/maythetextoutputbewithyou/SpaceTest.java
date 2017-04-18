/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maythetextoutputbewithyou;

import java.util.ArrayList;
import javax.swing.JTextArea;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Colin Evrard
 */
public class SpaceTest {

    public SpaceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setTextArea method, of class Space.
     */
    @Test
    public void testSetTextArea() {
        System.out.println("setTextArea");
        JTextArea t = null;
        Space instance = new Space();
        instance.setTextArea(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSizeX method, of class Space.
     */
    @Test
    public void testGetSizeX() {
        System.out.println("getSizeX");
        Space instance = new Space();
        int expResult = 0;
        int result = instance.getSizeX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSizeY method, of class Space.
     */
    @Test
    public void testGetSizeY() {
        System.out.println("getSizeY");
        Space instance = new Space();
        int expResult = 0;
        int result = instance.getSizeY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArray method, of class Space.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        Space instance = new Space();
        ArrayList<Affichable> expResult = null;
        ArrayList<Affichable> result = instance.getArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addIn method, of class Space.
     */
    @Test
    public void testAddIn() {
        System.out.println("addIn");
        Affichable a = null;
        Space instance = new Space();
        instance.addIn(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of superpose method, of class Space.
     */
    @Test
    public void testSuperpose() {
        System.out.println("superpose");
        String a = "a        a";
        String b = "         x";
        int maxX = 16;
        String expResult = "a        x";
        String result = Space.superpose(a, b, maxX);
        assertEquals(expResult, result);

    }

    /**
     * Test of display method, of class Space.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        Space instance = new Space();
        String expResult = "";
        String result = instance.display();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Space.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Space instance = new Space();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
