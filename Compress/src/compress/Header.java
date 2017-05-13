/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import java.io.IOException;

/**
 *
 * @author thureson
 */
public class Header {
    
    private OutStream out;
    
    public Header(OutStream out){
        this.out = out;
    }
    
    public void writeNodes(Node node) throws IOException{
        if (node.isLeaf()){
            out.write(0);
            out.writeChar(node.returnKey());
            out.writeInt(node.returnFreq());
        } else {
            out.write(1);
            writeNodes(node.returnLeft());
            writeNodes(node.returnRight());
            
        }
    }
}
