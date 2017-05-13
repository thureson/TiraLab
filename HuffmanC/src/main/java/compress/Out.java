package compress;

import java.io.IOException;
import java.io.OutputStream;

/**
    * Handles output to file writing one bit a time. 
*/

public class Out {
	
    private OutputStream output;
    private int currentByte;	
    private int numBitsFilled;

    /**
    * Constructor
    * @param out OutputStream to be used
    * Inits the currenbyte as 0 and bits filled as 0
    */
    
    public Out(OutputStream out) {
        output = out;
        currentByte = 0;
        numBitsFilled = 0;
    }
    
    /**
    * Write a bit to output file
    * @param b Bit to be written to output file
    * @throws IOException if errors writing to output file.
    */
    
    public void write(int b) throws IOException {
        currentByte = (currentByte << 1) | b;
        numBitsFilled++;
        if (numBitsFilled == 8) {
            output.write(currentByte);
            currentByte = 0;
            numBitsFilled = 0;
        }
    }
    
    /**
    * Calls write() for every bit of input character.
    * @param c Char to be written to output file
    * @throws IOException if errors writing to output file.
    */
    
    public void writeChar(char c) throws IOException{
        for (int j = 7; j >= 0; j--){
            write((c >>> j) & 1);
        }
    }

    /**
    * Closes stream to output file
    * @throws IOException if errors writing to output file.
    */
    
    public void close() throws IOException {
        while (numBitsFilled != 0)
            write(0);
        output.close();
    }
}