
package tiralaba;

import java.util.HashMap;

public class InputKasittelija {
    private HashMap<String, String> encode;
    private String input;
    private String charset;

    /* Pakkaaja-konstruktori asettaa mahdolliset kirjaimet inputille. 
    Jos sisään annetaan vain yksi parametri, annetaan oletus -> pienet ja suuret aakkoset + väli*/
    public InputKasittelija(String input){
        this(input, "abcdefghijklmnopqrstuvwxyzåäö ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ");
    }
    
    public InputKasittelija(String input, String charset){
        this.encode = new HashMap();
        this.input = input;
        this.charset = charset;
    }
    
//    public String pakkaa(String input){
//        String pakattu = "";
//        System.out.println(aakkoset);
//        HashMap<String, Integer> subs = new HashMap();
//        
//        for (int count = 0; count < input.length()-2; count++){
//            String sub = input.substring(count, count +2);
//            subs.put(sub, 0);
//        }
//        for (int count = 0; count < input.length()-2; count++){
//            String sub = input.substring(count, count +2);
//            subs.put(sub, subs.get(sub)+1);
//        }
//        System.out.println(subs);
//        
//        for (int count = 0; count < input.length()-2; count++){
//            String sub = input.substring(count, count +2);
//            subs.get(sub);
//        }
//        return pakattu;
//    }

/* To be */    
    public String unpakkaa(String input){
        String unpakattu = "";
//      stuff  
//        more stuff
//          MOAR STUFF
        return unpakattu;
    }
    
    /* esiintyvyys laskee kaikkien merkkien määrät inputista HashMappiin */
    public HashMap esiintyvyys(){
        HashMap<Character, Integer> aakkoset = new HashMap();
 
        for (char qq : charset.toCharArray()){
            aakkoset.put(qq, 0);
        }
        
        for (char tt : input.toCharArray()){
            int mm = aakkoset.get(tt);
            aakkoset.put(tt, mm+1);
        }
        
        return aakkoset;
    }
    
    
}
