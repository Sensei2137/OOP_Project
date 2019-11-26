/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paczka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Karta_dań {
   List<Posiłek> karta = new ArrayList<>();
   
   public void Dodaj_posiłek() throws IOException{
       
       Posiłek p = new Posiłek();
      
      
     
       
       p.setCena();
       p.setCzas();
       p.setNazwa();
      
       p.setKategoria();
       p.setSkładniki();
       karta.add(p);
   }
   public void wyświetl_menu(){
       for (int i = 0; i < karta.size(); i++) {
           Posiłek get = karta.get(i);
           System.out.println(get.getCena());
           System.out.println(get.getNazwa());
           System.out.println(get.getkategoria());
           
           get.getSkładniki();
       }
   }
    
}
