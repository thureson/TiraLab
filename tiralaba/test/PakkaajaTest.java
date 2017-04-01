/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tiralaba.InputKasittelija;

/**
 *
 * @author thureson
 */
/* Pakkaaja-luokan testit */

public class PakkaajaTest {
    
    public PakkaajaTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /* Testataan esiintyvyys-metodin toimintaa */
    @Test
    public void esiintyvyysTest(){
        String test = "aa";
        InputKasittelija pakkaaja = new InputKasittelija(test);
        HashMap teset = pakkaaja.esiintyvyys();
        assertEquals(teset.get('a'), 2);
    }
}
