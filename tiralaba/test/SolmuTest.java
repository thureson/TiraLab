/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tiralaba.Solmu;

/**
 *
 * @author thureson
 */
public class SolmuTest {
    
    public SolmuTest() {
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
    
    @Test
    public void KonstruktoriToimii(){
        Solmu test = new Solmu('t', null, null, null);
        assertEquals(test.returnKey(), 't');
        assertEquals(test.returnLeft(), null);
        assertEquals(test.returnRight(), null);
        assertEquals(test.returnParent(), null);
    }

    @Test
    public void onLehtiToimii(){
        Solmu test = new Solmu('t', null, null, null);
        assertEquals(test.onLehti(), true);
        Solmu newTest = new Solmu('a', test, null, null);
        assertEquals(newTest.onLehti(), false);
    }
}
