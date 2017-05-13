package huffmancompress;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class Out {
	
    private OutputStream output;
    private int currentByte;	
    private int numBitsFilled;

    public Out(OutputStream out) {
        output = out;
        currentByte = 0;
        numBitsFilled = 0;
    }

    public void write(int b) throws IOException {
        currentByte = (currentByte << 1) | b;
        numBitsFilled++;
        if (numBitsFilled == 8) {
            output.write(currentByte);
            currentByte = 0;
            numBitsFilled = 0;
        }
    }
    
    public void writeChar(char c) throws IOException{
        for (int j = 7; j >= 0; j--){
            write((c >>> j) & 1);
        }
    }

    public void close() throws IOException {
        while (numBitsFilled != 0)
            write(0);
        output.close();
    }
}