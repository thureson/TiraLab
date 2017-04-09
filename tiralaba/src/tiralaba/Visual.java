/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralaba;

/**
 *
 * @author thureson
 */
public class Visual {
    
    public void tulostaPuu(Solmu juuri){
        if (juuri == null){
            return;
        }
        System.out.print(" ");
        tulostaPuu(juuri.returnLeft());
        System.out.print(juuri.returnMaara() + "" + juuri.returnKey());
        tulostaPuu(juuri.returnRight());
        System.out.print(" ");
//        System.out.print(juuri.returnMaara());
    }
}
