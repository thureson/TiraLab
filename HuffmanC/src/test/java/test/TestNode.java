/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import compress.Node;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author thureson
 */
public class TestNode {
    
    public TestNode() {
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
    public void testIfLeaf(){
        Node n = new Node('a', null, null, 3);
        assertTrue(n.isLeaf());
    }
    
    @Test
    public void testIfLeaf2(){
        Node n = new Node('a', null, null, 3);
        Node a = new Node('a', n, null, 3);
        assertFalse(a.isLeaf());
    }
    
    @Test
    public void compare(){
        Node n = new Node('a', null, null, 3);
        Node a = new Node('a', n, null, 5);
        assertEquals(-2, n.compareTo(a));
        assertEquals(2, a.compareTo(n));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
