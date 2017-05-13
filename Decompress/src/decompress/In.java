package decompress;

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
        int thebyte = 0;
        for (int j = 7; j >= 0; j--){
            int bit = read();
            thebyte += bit;
            if (j != 0){
                thebyte = (thebyte << 1);
            }            
        }
        return thebyte;
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
        numBitsRemaining--;
        return (currentByte >>> (numBitsRemaining)) & 1;
    }
    
    public int readAmount(int n) throws IOException{
        int bitset = 0;
        for (int count = 0; count < n; count++){
            int bit = read();
            
        }
        return bitset;
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