/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralaba;

import java.util.ArrayList;

/**
 *
 * @author thureson
 */
public class Sorter {
    
    public int[] InsertionSort(int[] esiintyvyys){
        for (int i=1; i < esiintyvyys.length; i++){
            int temp = esiintyvyys[i];
            int m;
            for (m = i-1; m >= 0 && temp < esiintyvyys[m]; m++){
                esiintyvyys[m+1] = esiintyvyys[m];
                esiintyvyys[m+1] = temp;
            }
            esiintyvyys[m+1] = temp;
        }
        
        return esiintyvyys;
    }
    
    public ArrayList InsertionSortSolmuille(ArrayList<Solmu> esiintyvyys){
        for (int i = 1; i < esiintyvyys.size(); i++){
            Solmu temp = esiintyvyys.get(i);
            int m;
            for (m = i-1; m >= 0 && temp.returnMaara() < esiintyvyys.get(m).returnMaara(); m++){
                esiintyvyys.set(m+1, esiintyvyys.get(m));
            }
            esiintyvyys.set(m+1, temp);
        }
        
        return esiintyvyys;
    }
    
    public ArrayList InsertionSort2(ArrayList<Solmu> input){
        Solmu temp;
        for (int i = 1; i < input.size(); i++){
            for (int j = i; j > 0; j--){
                if (input.get(j).returnMaara() < input.get(j-1).returnMaara()){
                    temp = input.get(j);
                    input.set(j, input.get(j-1));
                    input.set(j-1, temp);
                }
            }
        }
        return input;
    }
}
