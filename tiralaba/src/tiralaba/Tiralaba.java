package tiralaba;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import static sun.security.krb5.Confounder.bytes;

public class Tiralaba {

    public static void main(String[] args) throws IOException {
        String lTiedosto = "/home/thureson/testzone/huffmantest";
        String kTiedosto = "/home/thureson/testzone/huffmantestOutput";
        FileManager fm = new FileManager();
        byte[] inputbytes =  fm.lueTiedosto(lTiedosto);
//        String input = "Olen jo kauan tiennyt kuinka toteutan tämän algoritmin";
        String input = new String(inputbytes, StandardCharsets.UTF_8);
        Huffman huffman = new Huffman();
//        HashMap<Character, Integer> esiintyvyys = huffman.esiintyvyys(input);
        int[] esiintyvyys2 = huffman.esiintyvyys2(input.toCharArray());
//        InputKasittelija packman = new InputKasittelija(input);
//        HashMap<Character, Integer> esiintyvyys = packman.esiintyvyys();
//        Converter converter = new Converter();
        
//        String b = converter.stringToBinary(input);
//        System.out.println(b);
//        
//        String t = converter.binaryToString(b);
//        System.out.println(t);
//        
//        System.out.println(esiintyvyys);
        Solmu juuri = Huffman.teePuu(esiintyvyys2);
//        System.out.println(juuri.returnMaara());
//        Visual visual = new Visual();
//        visual.tulostaPuu(juuri);
        byte[] packed = huffman.pakkaa(input);
        fm.kirjoitaTiedosto(packed, kTiedosto);
//        System.out.println(packed);
//        Solmu root = teePuu(esiintyvyys);
//        String packed = packman.pakkaa(input);
//        String original = packman.unpakkaa(packed);
//        
    }    
//    
//    public static Solmu teePuu(HashMap<Character, Integer> esiintyvyys){
//        Solmu root = new Solmu();
//        ArrayList<Solmu> puu = new ArrayList();
//        
//        return root;
//    }
    
}
