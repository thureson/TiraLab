package compress;

import java.io.IOException;
import java.io.OutputStream;

public class OutStream {
	
    private OutputStream output;
    private int currentByte;
    private int bitsFilled;

    public OutStream(OutputStream out) {
            output = out;
            currentByte = 0;
            bitsFilled = 0;
    }

    public void write(int b) throws IOException {
        currentByte = (currentByte << 1) | b;
        bitsFilled++;
        if (bitsFilled == 8) {
                output.write(currentByte);
                currentByte = 0;
                bitsFilled = 0;
        }
    }

    public void close() throws IOException {
        while (bitsFilled != 0){
            write(0);
        }
        output.close();
    }
	
}
