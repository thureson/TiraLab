package tiralaba;

import java.util.ArrayList;
import java.util.HashMap;

public class Tiralaba {

    public static void main(String[] args) {
        String input = "Olen jo kauan tiennyt kuinka toteutan tämän algoritmin";
        Pakkaaja packman = new Pakkaaja(input);
        HashMap<Character, Integer> esiintyvyys = packman.esiintyvyys();
//        Solmu root = teePuu(esiintyvyys);
//        String packed = packman.pakkaa(input);
//        String original = packman.unpakkaa(packed);
        
    }    
//    
//    public static Solmu teePuu(HashMap<Character, Integer> esiintyvyys){
//        Solmu root = new Solmu();
//        ArrayList<Solmu> puu = new ArrayList();
//        
//        return root;
//    }
    
}
