package compress;

import java.io.IOException;
import java.util.List;

public class Decoder {
    
    private InStream input;
    private Coding coding;
    
    public Decoder(InStream input, Coding coding){
        this.input = input;
        this.coding = coding;
    }
    
    public int read() throws IOException {
        Node cnode = coding.returnRoot();
        while (true) {
            int temp = input.read();
            Node nnode = null;
            if (temp == 0){
                nnode = cnode.returnLeft();
            } else if (temp == 1){
                nnode = cnode.returnRight();
            }
            if (nnode.isLeaf()){
                return nnode.returnKey();
            } else {
                cnode = nnode;
            }
        }
    }   
}