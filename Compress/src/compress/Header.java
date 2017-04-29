/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

/**
 *
 * @author thureson
 */
public class Header {
    
    private OutStream out;
    
    public Header(OutStream out){
        this.out = out;
    }
    
    public void writeNodes(Node node){
        if (node.isLeaf()){
            try{
                out.writeChar(node.returnKey());
                out.writeInt(node.returnFreq());
            } catch (Exception e){
                System.out.println("node write error");
            }
        } else {
            writeNodes(node.returnLeft());
            writeNodes(node.returnRight());
            
        }
    }
}
