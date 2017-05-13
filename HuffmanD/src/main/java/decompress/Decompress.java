package decompress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
    * Decompression application using Huffman-coding
    * <p>Usage: java Decompress InputFilePath OutputFilePath</p>
    * <p>Reads headerfile to create a huffman-tree and decode input file accordingly</p>
*/

public class Decompress {
    
    // main using terminal-inputs
    public static void main(String[] args) throws IOException {      
        if (args.length != 2) {
            System.err.println("Try: java HuffmanD InputFilePath OutputFilePath");
            System.exit(1);
            return;
        }
        
        // Init files needed
        File inputFile  = new File(args[0]);
        File outputFile = new File(args[1]);
        File headerFile  = new File(args[0] + "header");

        // Open streams
        In in = new In(new BufferedInputStream(new FileInputStream(inputFile)));
        In headerIn = new In(new BufferedInputStream(new FileInputStream(headerFile)));
        Out out = new Out(new BufferedOutputStream(new FileOutputStream(outputFile)));
        
        // Build huffman-tree reading header and return its root node
        Node root = readHeader(headerIn);
        
        // Reads decoding from huffman-tree and writes characters to Output file
        int temp = 0;
        while (true){
            Node node = root;
            while (!node.isLeaf()){
                int bit = in.read();
                if (bit == -1){
                    temp = 1;
                }
                if (bit == 0){
                    node = node.returnLeft();
                } else {
                    node = node.returnRight();
                }
            }
            if (temp == 1){
                break;
            }
            out.writeChar(node.returnKey());
        }
        
        headerIn.close();
        in.close();
        out.close();
    }    
    
    /**
    * Read header file and build a huffman-tree from results
    * If bit is 0 -> node not leaf, if 1 the next 8 bits are read as character
    * @param in Instream for header file.
    * @throws IOException if errors writing the header file.
    */
    
    public static Node readHeader(In in) throws IOException {
        int symbol;
        int isLeaf = in.read();
        if (isLeaf == 1) {
            symbol = in.readByte();
            return new Node((char) symbol, null, null, -1);
        } else {
            return new Node((char) '\0', readHeader(in), readHeader(in), -1);
        }
    }
}

