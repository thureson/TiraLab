package compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
    * Compression application using Huffman-coding
    * <p>Usage: java HuffmanCompress InputFilePath OutputFilePath</p>
    * <p>Compresses inputfile to outputfile, builds a header.</p>
*/

public class HuffmanCompress {
    
    // main using terminal-inputs
    public static void main(String[] args) throws IOException, Exception {      
        
        // Make sure enough args
        if (args.length != 2) {
            System.err.println("Try: java HuffmanCompress InputFilePath OutputFilePath");
            System.exit(1);
            return;
        }

        // Open files
        File inputFile  = new File(args[0]);
        File outputFile = new File(args[1]);
        File headerFile = new File("/home/thureson/TiraLab/testheader");

        // Open IO-streams for opened files
        In in = new In(new BufferedInputStream(new FileInputStream(inputFile)));
        Out out = new Out(new BufferedOutputStream(new FileOutputStream(outputFile)));
        Out headerOut = new Out(new BufferedOutputStream(new FileOutputStream(headerFile)));
        
        // Read frequencies from inputfile and creates a Huffman tree
        Frequeancies fq = getFrequeancies(inputFile);
        Node root = fq.buildTree();
        
        // Write headerfile: Form: pre-order tree traversal, 0, not a leaf, 1, leaf, next 8 bits are read as char
        writeHeader(root, headerOut);
        
        // Build complete Huffman-codes for each char (range 0-255, ASCII)
        CodeTable cd = new CodeTable(root);
        cd.build(root, new OwnArrayList());
        OwnArrayList<OwnArrayList<Integer>> lli = cd.returnCodeTable();
        
        // Read inputfile one byte a time, write huffmancode to outputfile using CodeTable
        while (true){
            int c = in.readByte();
            if (c == -1){
                break;
            }
            OwnArrayList<Integer> bits = (OwnArrayList<Integer>) lli.get(c);
            for (int m = 0; m < bits.size(); m++){
                int b = (int) bits.get(m);
                out.write(b);
            }
//            for (int b : bits){
//                out.write(b);
//            }
        }

        //To be EOF
        
        // Close streams
        headerOut.close();
        in.close();
        out.close();
    }
    
    /**
    * Reads frequencies from input file and return a table with frequencies. 
    * @param file File.used to build a frequency-table.
    * @return Returns a complete frequency-table builded from input file.
    * @throws IOException if errors reading the input file.
    */
    
    public static Frequeancies getFrequeancies(File file) throws IOException{
        
        Frequeancies fqs = new Frequeancies(new int[257]);
        In input = new In(new BufferedInputStream(new FileInputStream(file)));
        
        while (true) {
            int b = input.readByte();
            if (b == -1){
                break;
            }
            fqs.set(b, fqs.get(b)+1);
        }
        
        // EOF
        fqs.set(256, 1);
        input.close();
        
        return fqs;
    }
    
    /**
    * Write a header file in pre-order form, 0 marking not leaf, 1 marking leaf,
    * read next 8 bits as char. 
    * @param node Node being writed..
    * @param out Outstream to header file.
    * @throws IOException if errors writing the header file.
    */
    
    public static void writeHeader(Node node, Out out) throws IOException{
        if (node.isLeaf()) {
            out.write(1);
            out.writeChar(node.returnKey());    
        } else {
            out.write(0);
            writeHeader(node.returnLeft(), out);
            writeHeader(node.returnRight(), out);
        }
    }
}
