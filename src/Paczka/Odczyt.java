/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paczka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class Odczyt {
   List<String> lista = new ArrayList<>();
        
    
    public  void odczytPlikuTekstowego(String nazwa) throws IOException {
     
        FileReader plikWe = null;
    
        BufferedReader plik2 = null;
     
        try {            
            plik2 = new BufferedReader(new FileReader(nazwa));
          
            String l = plik2.readLine();
            while (l != null) {
               
                l = plik2.readLine();
                lista.add(l);
            }
        } finally {
            if (plik2 != null) {
                
                plik2.close();
            }
        }
    }
 
  
}