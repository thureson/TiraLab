package compress;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
    * Handles input from file as bytes/bits. 
    * <p>Used to read single bits from InputStream</p>
*/

public class In {

    private InputStream input;
    private int currentByte;
    private int numBitsRemaining;
    
    /**
    * Constructor
    * @param in InputStream to be used
    * Inits the currenbyte as 0 and bits filled as 0
    */

    public In(InputStream in) {
        input = in;
        currentByte = 0;
        numBitsRemaining = 0;
    }
    
    /**
    * Read a byte from inputStream
    * Only to be used if read() not called for this stream
    * @throws IOException if errors reading from file.
    */

    public int readByte() throws IOException {
        currentByte = 0;
        numBitsRemaining = 0;
        return input.read();
    }

    /**
    * Read a bit from currentByte
    * Reads a bit, update currentByte and decrease bitsRemaining
    * @throws IOException if errors reading from file.
    */
    
    public int read() throws IOException {
        if (currentByte == -1)
            return -1;
        if (numBitsRemaining == 0) {
            currentByte = input.read();
            if (currentByte == -1)
                return -1;
            numBitsRemaining = 8;
        }
//        if (numBitsRemaining <= 0)
//            throw new AssertionError();
        numBitsRemaining--;
        return (currentByte >>> (numBitsRemaining)) & 1;
    }

    /**
    * Checks if EOF
    * @throws IOException if errors reading from input file.
    */
    
    public int readNoEof() throws IOException {
        int result = read();
        if (result != -1)
            return result;
        else
            throw new EOFException();
    }

    /**
    * Closes stream from input file
    * @throws IOException if errors reading from input file.
    */
    
    public void close() throws IOException {
        input.close();
        currentByte = -1;
        numBitsRemaining = 0;
    }	
}