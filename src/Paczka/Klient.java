/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paczka;

import static Paczka.Menu.m;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Klient extends Thread{
    private String nazwisko;
    private String adres;
    private int telefon;
    private int nr_zamówienia;
    private int godzina_zamówienia;
    private int X;
    private int Y; 
    int ID;
    int adresowa;
    public static BufferedImage ikonaa;
   
     Random generator = new Random();
    Odczyt s = new Odczyt();
    Scanner odczyt = new Scanner(System.in);
    public static Map<Klient,Posiłek> zamowienie = new HashMap<>();
  
public final Lock klientLock = new ReentrantLock();
    
   public void setID(){
       
   }
   public int getID(){
       return ID;
   }
   
   public void setDom() throws IOException{
    //dom = ImageIO.read(getClass().getResource(s));
    
    }
   
   
   
   
    public void setNazwisko() throws IOException {
        s.odczytPlikuTekstowego("Nazwiska.txt");
        int rand = generator.nextInt(19);
       String get = s.lista.get(rand);
        this.nazwisko = get;
        s.lista.clear();
    }
     public void setAdres() {
         switch(Y){
             case 120:
                 adresowa=1;
                 break;
                 case 300:
                 adresowa=2;
                 break;
                 case 390:
                 adresowa=3;
                 break;
                 case 550:
                 adresowa=4;
                 break;
                 case 630:
                 adresowa=5;
                 break;
                 default:
                     break;
             }
    this.adres = Integer.toString(X+adresowa);
}
      public void setTelefon() {
      int rand = generator.nextInt(50000);
    this.telefon = rand;
}
       public void setNr_zamówienia() {
    
}
       public void setGodzina_zamówienia(){
           
       }
       public String getNazwisko(){
           return nazwisko;
       }
       public String getAdres(){
               return adres;
       }
       public int getTelefon(){
    return telefon;
}
   
       public void setX(int X){
           
          
           this.X =X;
        
      }
       public int getX(){
           return X;
       }
       
        public void setY(int Y){
      
           this.Y =Y;
        
      }
       public int getY(){
           return Y;
       }
       
       
       
       
    public void zamów(Karta_dań k){
   
   
   int rand = generator.nextInt(k.karta.size());
    Posiłek get;
    
        get = k.karta.get(rand);
        zamowienie.put(this,get);
       
        
    }
    @Override
    public synchronized void  run(){
        while(true){
            if (m.karta.isEmpty()==false){
            this.zamów(m);
           
              
            try {
                int rand = generator.nextInt(20000)+30000;
                this.sleep(rand);
                
               
         
            } catch (InterruptedException ex) {
                Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else
            {
              try {
                  this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            }
    }
    
    
}
