package decompress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decompress {

    public static void main(String[] args) throws IOException {      
//        if (args.length != 2) {
//            System.err.println("Try: java Decompress InputFilePath OutputFilePath");
//            System.exit(1);
//            return;
//        }
//        
//        File inputFile  = new File(args[0]);
//        File outputFile = new File(args[1]);
        File inputFile  = new File("/home/thureson/TiraLab/testout");
        File headerFile  = new File("/home/thureson/TiraLab/testheader");
        File outputFile = new File("/home/thureson/TiraLab/testret");

        In in = new In(new BufferedInputStream(new FileInputStream(inputFile)));
        In headerIn = new In(new BufferedInputStream(new FileInputStream(headerFile)));
        Out out = new Out(new BufferedOutputStream(new FileOutputStream(outputFile)));
        
        Node root = readHeader(headerIn);
        
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
    
    public static Node readHeaderSimple(In in) throws IOException {
        Frequeancies fqs = new Frequeancies(new int[256]);
        while (true){
            int chr = (char) in.readByte();
            if (chr == -1){
                break;
            }
            int amt = in.readByte();
            if (amt == -1){
                break;
            }
            fqs.set(chr, amt);
        }
        
        return fqs.buildTree();
    }
    
    public static Frequeancies getFrequeancies(File file) throws IOException{
        Frequeancies fqs = new Frequeancies(new int[256]);
        
        In input = new In(new BufferedInputStream(new FileInputStream(file)));
        while (true) {
            int b = input.readByte();
            if (b == -1){
                break;
            }
            fqs.set(b, fqs.get(b)+1);
        }
        input.close();
        return fqs;
    }
}

