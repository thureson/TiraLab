package tiralaba;

import java.util.ArrayList;
import java.util.HashMap;
import static javafx.scene.input.KeyCode.R;
import javax.xml.soap.Node;

public class Huffman {
    
    public Huffman(){
    }
    
    public int pakkaa(String input){ // MUOKKAA INPUT -------- TYYPPI VÄÄRÄ        
        Converter converter = new Converter();
        char[] inpu = input.toCharArray();
        
        int[] esiintyvyys = esiintyvyys2(input.toCharArray());
        Solmu juuri = teePuu(esiintyvyys);
        
        
        String b = converter.stringToBinary(input);
        
                
        
        return bits;
    }
    
    public int unpakkaa(int input){ // MUOKKAA INPUT -------- TYYPPI VÄÄRÄ
        int bits = input;
        
        
        return bits;
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
    
    public static int[] esiintyvyys2(char[] input){
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
        
        sorted = sorter.InsertionSortSolmuille(sorted);
        
        while (sorted.size() > 1) {
            Solmu left  = sorted.remove(0);
            Solmu right  = sorted.remove(0);
            Solmu parent = new Solmu('\0', left, right, left.returnMaara() + right.returnMaara());
            sorted.add(parent);
            sorter.InsertionSortSolmuille(sorted);
        }
        
        return sorted.remove(0);
    }
}
