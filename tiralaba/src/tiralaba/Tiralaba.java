/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralaba;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author thureson
 */
public class Tiralaba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        HOFFMAN
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
