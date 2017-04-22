/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import java.util.List;

/**
 *
 * @author thureson
 */
public class Helper {
    
    public void printNodes(Node node){
        if (node.isLeaf()){
            System.out.println(node.returnKey() + " ->" + node.returnFreq());
        } else {
            printNodes(node.returnLeft());
            printNodes(node.returnRight());
            System.out.println(node.returnFreq());
        }
    }
    
    public void printCoding(int[] f, Coding c){
        List<Integer> l;
        for (int a = 0; a < 256; a++){
            l = c.returnCode(a);
            System.out.println(f[a] + " --> " + l);
        }
    }
}
