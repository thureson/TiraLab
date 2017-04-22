package compress;

import java.io.IOException;
import java.io.InputStream;

public class InStream {
	
    private InputStream input;
    private int currentByte;
    private int bitsFilled;

    public InStream(InputStream input) {
            input = input;
            currentByte = 0;
            bitsFilled = 0;
    }

    public void read() throws IOException {
        bitsFilled++;
        if (bitsFilled == 8) {
                input.read();
                currentByte++;
                bitsFilled = 0;
        }
    }

    public void close() throws IOException {
            input.close();
    }
	
}