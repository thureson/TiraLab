package huffmancompress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HuffmanCompress {

    public static void main(String[] args) throws IOException {      
//        if (args.length != 2) {
//            System.err.println("Try: java HuffmanCompress InputFilePath OutputFilePath");
//            System.exit(1);
//            return;
//        }
//
//        File inputFile  = new File(args[0]);
//        File outputFile = new File(args[1]);
        File inputFile  = new File("/home/thureson/TiraLab/testin");
        File outputFile = new File("/home/thureson/TiraLab/testout");
        File headerFile = new File("/home/thureson/TiraLab/testheader");


        In in = new In(new BufferedInputStream(new FileInputStream(inputFile)));
        Out out = new Out(new BufferedOutputStream(new FileOutputStream(outputFile)));
        Out headerOut = new Out(new BufferedOutputStream(new FileOutputStream(headerFile)));
        
        Frequeancies fq = getFrequeancies(inputFile);
        Node root = fq.buildTree();
        System.out.println(root.returnFreq());
        
        writeHeader(root, headerOut);
        CodeTable cd = new CodeTable(root);
        cd.build(root, new ArrayList<>());
        List<List<Integer>> lli = cd.returnCodeTable();
        for (int count = 0; count < fq.getLenght(); count++){
            System.out.println(count + " " + lli.get(count) + " " + (char) count);
        }
        while (true){
            int c = in.readByte();
            if (c == -1){
                break;
            }
            List<Integer> bits = lli.get(c);
            for (int b : bits){
                out.write(b);
            }
        }
//        List<Integer> EOF = lli.get(256);
//        for (int s : EOF){
//            System.out.println(s);
//        }
        headerOut.close();
        in.close();
        out.close();
    }
    
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
        fqs.set(256, 1);
        input.close();
        return fqs;
    }
    
    
    public static void writeHeaderSimple(Node node, Out out) throws IOException{
        if (node.isLeaf()) {
            out.writeChar(node.returnKey());
            out.writeChar((char) node.returnFreq());
        } else {
            writeHeaderSimple(node.returnLeft(), out);
            writeHeaderSimple(node.returnRight(), out);
        }
    }
    
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
