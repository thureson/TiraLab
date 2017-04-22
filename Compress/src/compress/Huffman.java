/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author thureson
 */
public class Huffman {
    
    public void compress(char[] input, InputStream in, OutStream out) throws IOException{
        int[] freqTable = freqTable(input);
        Node root = huffmanTree(freqTable);
        Coding coding = new Coding(root);
        coding.build(root, new ArrayList<>());
        Encoder encoder = new Encoder(out, coding);
        
//        Helper helper = new Helper();
//        helper.printNodes(root);
//        helper.printCoding(freqTable, coding);
        
        int count = 0;
        while (true){
            int c = in.read();
            if (c == -1){
                break;
            }
            encoder.write(c);
            count++;
        }
    }
    
    public static Node huffmanTree(int[] freqTable){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (char i = 0; i < 256; i++){
            if (freqTable[i] > 0){
                pq.add(new Node(i, null, null, freqTable[i]));
            }
        }
        while (pq.size() > 1) {
            Node left  = pq.remove();
            Node right  = pq.remove();
            Node parent = new Node('\0', left, right, left.returnFreq() + right.returnFreq());
            pq.add(parent);
        }
        return pq.remove();
    }
    
    public static int[] freqTable(char[] input){
        int[] freqTable = new int[256];
        for (int i = 0; i < input.length; i++){
            freqTable[input[i]]++;
        }
        
        return freqTable;
    }
}
