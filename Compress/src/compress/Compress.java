package compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Compress {

    public static void main(String[] args) throws IOException {
        
        // Handle command line arguments
//        if (args.length != 2) {
//                System.err.println("Try: java Compress InputFilePath OutputFilePath");
//                System.exit(1);
//                return;
//        }
        
        //tests
        File inputFile = new File("/home/thureson/TiraLab/testIn");
        File outputFile = new File("/home/thureson/TiraLab/testOut");
        
//        File inputFile  = new File(args[0]);
//        File outputFile = new File(args[1]);

        // FileIOs
        InputStream in = new BufferedInputStream(new FileInputStream(inputFile));
        OutStream out = new OutStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
        try {
            compress(in, out);
        } finally {
            out.close();
            in.close();
        }
    }
    
    public static void compress(InputStream in, OutStream out){
        
        
        Huffman huffman = new Huffman();
        huffman.compress();
    }
    
}
