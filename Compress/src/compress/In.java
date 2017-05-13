package compress;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class In {

    private InputStream input;
    private int currentByte;
    private int numBitsRemaining;

    public In(InputStream in) {
        input = in;
        currentByte = 0;
        numBitsRemaining = 0;
    }

    public int getBitPosition() {
        return (8 - numBitsRemaining) % 8;
    }

    public int readByte() throws IOException {
            currentByte = 0;
            numBitsRemaining = 0;
            return input.read();
    }

    public int read() throws IOException {
            if (currentByte == -1)
                    return -1;
            if (numBitsRemaining == 0) {
                    currentByte = input.read();
                    if (currentByte == -1)
                            return -1;
                    numBitsRemaining = 8;
            }
            if (numBitsRemaining <= 0)
                    throw new AssertionError();
            numBitsRemaining--;
            return (currentByte >>> (7 - numBitsRemaining)) & 1;
    }

    public int readNoEof() throws IOException {
            int result = read();
            if (result != -1)
                    return result;
            else
                    throw new EOFException();
    }

    public void close() throws IOException {
            input.close();
            currentByte = -1;
            numBitsRemaining = 0;
    }	
}