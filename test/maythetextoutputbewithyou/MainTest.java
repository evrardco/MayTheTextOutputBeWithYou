/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maythetextoutputbewithyou;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Colin Evrard
 */
public class MainTest {

    public MainTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of randBetween method, of class Main.
     */
    @Test
    public void testRandBetween() {
        System.out.println("randBetween");
        int a = 0;
        int b = 10;
        for (int i = 0; i < 1000; i++) {
            int rand = Main.randBetween(a, b);
            System.out.println(rand);
            Assert.assertTrue("Erreur plus petit", rand >= a);
            Assert.assertTrue("Erreur plus grand", rand < b);
        }

        // TODO review the generated test code and remove the default call to fail.
    }

}
