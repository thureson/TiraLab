package compress;

import java.io.IOException;
import java.util.List;

public class Encoder {
    
    private OutStream output;
    private Coding coding;
    
    public Encoder(OutStream output, Coding coding){
        this.output = output;
        this.coding = coding;
    }
    
    public void write(int c) throws IOException {
        List<Integer> bits = coding.returnCode(c);
        if (bits != null){
            for (int b : bits){
                output.write(b);
            }
        }
    }
}
