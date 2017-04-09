package tiralaba;

import java.util.ArrayList;
import java.util.HashMap;

public class Huffman {
    
    public Huffman(){
    }
    
    public byte[] pakkaa(String input){ // MUOKKAA INPUT -------- TYYPPI VÄÄRÄ        
        Converter converter = new Converter();
        char[] inpu = input.toCharArray();
        
        int[] esiintyvyys = esiintyvyys2(input.toCharArray());
        Solmu juuri = teePuu(esiintyvyys);
        
        String[] codingTaulukko = new String[256];
        teeCoding(codingTaulukko, juuri, "");
        
//        System.out.println("\nTaulukko");
//        for (int s = 0; s < 256; s++){
//            System.out.print(".." + codingTaulukko[s] + " " + (char) s);
//        }
//        System.out.println(codingTaulukko);
        
        String bits = "";
        for (char c : input.toCharArray()){
            bits += codingTaulukko[c];
        } 
        
        byte[] bytes = bits.getBytes();
//        ArrayList<Integer> bytes = new ArrayList<>();
//        for(String str : bits.split("(?<=\\G.{8})")){
//            bytes.add(Integer.parseInt(str, 2));
//        }
        
//        System.out.println(bits);
//        String b = converter.stringToBinary(input);
        return bytes;
    }
    
    public int unpakkaa(int input){ // MUOKKAA INPUT -------- TYYPPI VÄÄRÄ
        int bits = input;
        
        
        return bits;
    }
    
     private static void teeCoding(String[] st, Solmu solmu, String code) {
        if (!solmu.onkoLehti()) {
            teeCoding(st, solmu.returnLeft(),  code + '0');
            teeCoding(st, solmu.returnRight(), code + '1');
        }
        else {
            st[solmu.returnKey()] = code;
        }
    }
    
    public HashMap esiintyvyys(String input){
        HashMap<Character, Integer> esiintyvyys = new HashMap();
        
        for (char qq : input.toCharArray()){
            if (esiintyvyys.containsKey(qq)){
                esiintyvyys.put(qq, esiintyvyys.get(qq) +1);
            } else {
                esiintyvyys.put(qq, 1);
            }
        }
        
        return esiintyvyys;
    }
    
    public int[] esiintyvyys2(char[] input){
        int[] esiintyvyys = new int[256];
        for (int i = 0; i < input.length; i++){
            esiintyvyys[input[i]]++;
        }
        
        return esiintyvyys;
    }
    
    public static Solmu teePuu(int[] esiintyvyys){
        Sorter sorter = new Sorter();

        ArrayList<Solmu> sorted = new ArrayList();
        for (char i = 0; i < 256; i++){
            if (esiintyvyys[i] > 0){
                sorted.add(new Solmu(i, null, null, esiintyvyys[i]));
            }
        }
        
        sorted = sorter.InsertionSort2(sorted);
//        for (Solmu m : sorted){
//            System.out.print(" " + m.returnKey() + "" + m.returnMaara());
//        }
        
        while (sorted.size() > 1) {
            Solmu left  = sorted.remove(0);
            Solmu right  = sorted.remove(0);
            Solmu parent = new Solmu('\0', left, right, left.returnMaara() + right.returnMaara());
            sorted.add(parent);
            sorted = sorter.InsertionSort2(sorted);
        }
        
        return sorted.remove(0);
    }
}
