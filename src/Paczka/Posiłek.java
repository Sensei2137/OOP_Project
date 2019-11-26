package Paczka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Posiłek {
    private String nazwa;
    private int czas_przygotowania;
    private String kategoria;
    private int cena;
    private String składniki;
    public int cena_dowozu;
    List<String> skład = new ArrayList<>();
    Random generator = new Random();
    Odczyt s = new Odczyt();
    public String getNazwa(){
    return nazwa;
   
}
    public String getkategoria(){
    return kategoria;
   
}
    public int getCzas(){
    return czas_przygotowania;
   
}
    public int getCena(){
    return cena;
    
   
}
    public void getSkładniki(){
        for (int i = 0; i < skład.size(); i++) {
            String get = skład.get(i);
            System.out.println(get);
            
        }
   
}
    public void setNazwa() throws IOException {
        s.odczytPlikuTekstowego("Posiłki.txt");
        int rand = generator.nextInt(34);
       String get = s.lista.get(rand);
        this.nazwa = get;
        s.lista.clear();
    }
    
    public void setCenaDojazdu(){
        int rand = generator.nextInt(50)+10;
        this.cena_dowozu=rand;
    }
    
    public int getCenaDojazdu(){
        return cena_dowozu;
    }
    
    public void setKategoria( ) throws IOException {
        s.odczytPlikuTekstowego("Kategorie.txt");
        int rand = generator.nextInt(19);
        String kat = s.lista.get(rand);
        this.kategoria = kat;
         s.lista.clear();
    }
    public void setCzas() {
        this.czas_przygotowania = generator.nextInt(1000)+500;
    }public void setCena() {
        this.cena = generator.nextInt(50);
    }
    public void setSkładniki( ) throws IOException {
        s.odczytPlikuTekstowego("Składniki.txt");
        for (int i = 0; i < generator.nextInt(6); i++) {
            
        
        int rand = generator.nextInt(24);
        String kat = s.lista.get(rand);
        this.składniki = kat;
        skład.add(składniki);
        }
        s.lista.clear();
       
        
    }
    
  
    
    

     
     
     
}
