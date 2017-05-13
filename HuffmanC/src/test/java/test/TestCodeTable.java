package test;

import compress.CodeTable;
import compress.Node;
import compress.OwnArrayList;
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
    public void returningRoot() throws Exception{
        Node root = new Node('a', null, null, 2);
        CodeTable ct = new CodeTable(root);
        ct.build(root, new OwnArrayList());
//        assertEquals(2, ct.build(root, new OwnArrayList()));
    }
}
