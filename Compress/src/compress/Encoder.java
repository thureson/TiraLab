package compress;

import java.io.IOException;
import java.util.List;

public class Encoder {
    
    private OutStream output;
    
    public Encoder(OutStream output){
        this.output = output;
    }
    
    public void write(int c) throws IOException {
        List<Integer> bits = codeTree.getCode(c);
        for (int b : bits)
                output.write(b);
    }
}
