package test;

import compress.CodeTable;
import compress.Node;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author thureson
 */
public class TestCodeTable {
    
    public TestCodeTable() {
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
    public void constructor() throws Exception{
        Node n = new Node('q', null, null, 1);
        CodeTable ct = new CodeTable(n);
        assertEquals(257, ct.returnCodeTable().size());
    }
}
