package compress;

import java.io.IOException;
import java.io.InputStream;

public class InStream {
	
    private InputStream input;
    private int currentByte;
    private int bitsRemaining;

    public InStream(InputStream input) {
            this.input = input;
            currentByte = 0;
            bitsRemaining = 0;
    }

    public int read() throws IOException {
        if (bitsRemaining == 0) {
            currentByte = input.read();
            if (currentByte == -1)
                    return -1;
            bitsRemaining = 8;
        }
        bitsRemaining--;
        return (currentByte >>> bitsRemaining) & 1;
//	
//        currentByte = (currentByte << 1) | b;
//        bitsFilled++;
//        if (bitsFilled == 8) {
//                input.read();
//                currentByte++;
//                bitsFilled = 0;
//        }
    }
    
    public int readByte() throws IOException{
        return input.read();
    }

    public void close() throws IOException {
            input.close();
    }
	
}