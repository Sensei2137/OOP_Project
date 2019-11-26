/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paczka;

import static Paczka.Menu.Mapa;
import static Paczka.Menu.aktywni_dost;
import static Paczka.Menu.dostawcy;
import static Paczka.Restauracja.odebrane_zamowienia;
import static Paczka.Restauracja.zleceniodawca;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author ASUS
 */
public class Dostawca extends Thread{
    private String nazwisko;
    private int PESEL;
    private int Prawo_jazdy;
    private int X;
    private int Y;
    public static BufferedImage ikona;
    Odczyt s = new Odczyt();
    Random generator = new Random();
    int celX;
    int celY;
    int cel2X;
    int cel2Y;
    int temp;
    private int pojemnosc;
    boolean lew_skrzy;
    boolean Y_skrzy;
    public final Lock lock = new ReentrantLock();
    private boolean rozwozi;
    public void setNazwisko() throws IOException {
        s.odczytPlikuTekstowego("Nazwiska.txt");
        int rand = generator.nextInt(400);
       String get = s.lista.get(rand);
        this.nazwisko = get;
        s.lista.clear();
    }
     public String getNazwisko(){
           return nazwisko;
       }
    public void setPESEL(){
        int rand = generator.nextInt(9999999)+1000000;
        this.PESEL=rand;
    }
    public int getPESEL(){
        return PESEL;
    }
    public void setPrawko(){
        int rand = generator.nextInt(2);
        this.Prawo_jazdy=rand;
    }
    public int getPrawko(){
        return Prawo_jazdy;
    }
 
    public void odbierzZamowienie() throws InterruptedException{
        this.sleep(200);
       if(odebrane_zamowienia.isEmpty()==false ){
             lock.lock();
            if(this.getPrawko()==0){
           
                 
               
             
                try {
                   
              
               this.sleep(100);
               celX = zleceniodawca.element().getX();
               celY = zleceniodawca.element().getY();
              
                  
                } finally {
                    lock.unlock();
                    
                }
                     zleceniodawca.remove(); 
               odebrane_zamowienia.remove();
               dostawcy.remove(this);
               aktywni_dost.put(this.PESEL, this);
               this.rozwozi=true;
               
            
             
           
         
            } 
              else{
                
               lock.lock();
                    if(odebrane_zamowienia.size()>1){
                         this.sleep(150);
                         celX = zleceniodawca.element().getX();
                         celY = zleceniodawca.element().getY();
                         zleceniodawca.remove(); 
                         cel2X = zleceniodawca.element().getX();
                         cel2Y = zleceniodawca.element().getY();
                         zleceniodawca.remove(); 
                         lock.unlock();
                    odebrane_zamowienia.remove();
                    dostawcy.remove(this);
                    aktywni_dost.put(this.PESEL, this);
                    
                    this.rozwozi=true;
                          
                    }else{
                        this.sleep(100);
                         celX = zleceniodawca.element().getX();
                         celY = zleceniodawca.element().getY();
                         zleceniodawca.remove(); 
                         lock.unlock();
                    odebrane_zamowienia.remove();
                    dostawcy.remove(this);
                    aktywni_dost.put(this.PESEL, this);
                    
                    this.rozwozi=true;
                    }
                    
                   }
            
       }            
    
                                            
    }
    public synchronized void sprawdzacz_kolizji() throws InterruptedException{
       
            if((this.X==900 && this.Y==220) || (this.X==1020 && this.Y==220)){
              this.lew_skrzy=true;
                for (Map.Entry<Integer, Dostawca> entry : aktywni_dost.entrySet()) {
                    Integer key = entry.getKey();
                    Dostawca value = entry.getValue();
                    if(value.Y_skrzy==true && key != this.PESEL)
                        this.wait(1000);
                }
              this.lew_skrzy=false;
                
            }
            
            else{
                if((this.X==980 && this.Y==200) || (this.X==980 && this.Y==260)){
              this.Y_skrzy=true;
                for (Map.Entry<Integer, Dostawca> entry : aktywni_dost.entrySet()) {
                    Integer key = entry.getKey();
                    Dostawca value = entry.getValue();
                    if(value.lew_skrzy==true && key != this.PESEL)
                        this.wait(1000);
                }
               this.Y_skrzy = false;
                
            }
            }
    }
    public void setPojazd() throws IOException{
        switch(this.Prawo_jazdy){
            case 0:
                Kuń k = new Kuń();
                k.setObraz();
                ikona=k.kuń;
                this.pojemnosc=k.getPojemność();
                break;
            case 1:
                Smok z = new Smok();
                z.setObraz();
                ikona=z.smok;
                this.pojemnosc=z.getPojemność();
                break;
            
        }
    }
    public void wjazd_na_chate() throws InterruptedException{
          if(celY==120 || celY==300 || celY==550 || cel2Y==120 || cel2Y==300 || cel2Y ==550){
         for (int i = 0; i < 30; i++) {
                   this.jazda_dół();
                   
               }
               this.sleep(100);
                for (int i = 0; i < 30; i++) {
                   this.jazda_gora();
                   
               }
          }
               
              if(celY==390 || celY==630 || cel2Y==390 || cel2Y==630){
                       for (int i = 0; i < 30; i++) {
                   this.jazda_gora();
                   
               }
               this.sleep(100);
                for (int i = 0; i < 30; i++) {
                   this.jazda_dół();
                   
               } 
              }
                        
    }
    public void jazda_prawo() throws InterruptedException{
        
       Thread.sleep(10);
            this.X+=1;
            sprawdzacz_kolizji();
    }
     public void jazda_lewo() throws InterruptedException{
        
       Thread.sleep(10);
            this.X-=1;
            sprawdzacz_kolizji();
    }
      public void jazda_gora() throws InterruptedException{
        
       Thread.sleep(10);
            this.Y-=1;
            sprawdzacz_kolizji();
    }
       public void jazda_dół() throws InterruptedException{
        
       Thread.sleep(10);
            this.Y+=1;
            sprawdzacz_kolizji();
    }
       public void jazda_restauracja() throws InterruptedException{
           if(Y == 20 && X <980){
               while(X!=980){
                   this.jazda_prawo();
               }
               while(Y!=220){
                   this.jazda_dół();
               }
               while(X!=40){
                   this.jazda_lewo();
               }
               while(Y!=100){
                   this.jazda_gora();
               }
           }
           else{
               if(Y == 20 && X >980){
                     while(X!=1480){
                   this.jazda_prawo();
               }
               while(Y!=220){
                   this.jazda_dół();
               }
               while(X!=40){
                   this.jazda_lewo();
               }
               while(Y!=100){
                   this.jazda_gora();
               }
               }
               else{
                   if(Y == 220 && X <980){
                      while(X!=980){
                   this.jazda_prawo();
               }
               while(Y!=20){
                   this.jazda_gora();
               }
               while(X!=200){
                   this.jazda_lewo();
               }
             
                   }
                   else{
                        if(Y == 220 && X >980){
                      while(X!=1480){
                   this.jazda_prawo();
               }
               while(Y!=20){
                   this.jazda_gora();
               }
               while(X!=200){
                   this.jazda_lewo();
               }
             
                   }
                        else{
                           if(Y == 460 && X <980){
                      while(X!=980){
                   this.jazda_prawo();
               }
               while(Y!=700){
                   this.jazda_dół();
               }
               while(X!=40){
                   this.jazda_lewo();
               }
               while(Y!=100){
                   this.jazda_gora();
               }
             
                   }
                           else{
                                 if(Y == 460 && X >980){
                      while(X!=1480){
                   this.jazda_prawo();
               }
               while(Y!=700){
                   this.jazda_dół();
               }
               while(X!=40){
                   this.jazda_lewo();
               }
               while(Y!=100){
                   this.jazda_gora();
               }
             
                   }
                                 else{
                                       if(Y == 700 && X <980){
                      while(X!=980){
                   this.jazda_prawo();
               }
               while(Y!=460){
                   this.jazda_gora();
               }
               while(X!=40){
                   this.jazda_lewo();
               }
               while(Y!=100){
                   this.jazda_gora();
               }
             
                   }else{
                                           if(Y == 700 && X >980){
                      while(X!=1480){
                   this.jazda_prawo();
               }
               while(Y!=460){
                   this.jazda_gora();
               }
               while(X!=40){
                   this.jazda_lewo();
               }
               while(Y!=100){
                   this.jazda_gora();
               }
             
                   }
                                       }
                                 }
                           }
                        }  
                   }
               }
           }
       }
       
       public void jazda_smok() throws InterruptedException{
           while(rozwozi==true){
               
               if(cel2X==0 && cel2Y ==0){
                       if(celY==120 && celX>120){
               this.setY(20);
               this.setX(200);
               while(X!=celX){
                  this.jazda_prawo();
               }
               this.wjazd_na_chate();
               this.jazda_restauracja();
              
             
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
              
           }
           else{
              
           if(celY==300){
               this.setY(100);
               this.setX(40);
               
           
           while(Y!=220){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
                this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                        }
           
           else{
                   if(celY==390){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=460){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
               this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                   else{
                        if(celY==550){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=460){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
             this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                        else{
                            if(celY==630){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=700){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
               this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                            else{
                                 if(celY==120 && celX==120){
                   this.setY(100);
               this.setX(40);
                while(Y!=120){
                  this.jazda_dół();
           }
                for (int i = 0; i < 30; i++) {
                   this.jazda_prawo();
                   
               }
               this.sleep(100);
                for (int i = 0; i < 30; i++) {
                   this.jazda_lewo();
                   
               }
                while(Y!=100){
                  this.jazda_gora();
           }
                dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
               }
                            }
                        }
                   }
                }
               }
               }else{
                  if((celX>cel2X && celY==cel2Y) || (cel2Y==120&&cel2X==120)) {
                      temp = celX;
                        celX = cel2X;
                       cel2X = temp;
                      }
                  if(celY==120 && celX>120){
               this.setY(20);
               this.setX(200);
               while(X!=celX){
                  this.jazda_prawo();
               }
              this.wjazd_na_chate();
                if(celY==cel2Y){
                    while(X!=cel2X){
                  this.jazda_prawo();
               }
                this.wjazd_na_chate();   
                 this.jazda_restauracja();
                }else{
                    if(X<980  && cel2Y==300){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==300){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                     if(X<980  && cel2Y==390){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==390){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                      if(X<980  && cel2Y==550){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==550){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                       if(X<980  && cel2Y==630){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==630){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                }
              
              
             
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
              
           }
           else{
              
           if(celY==300){
               this.setY(100);
               this.setX(40);
               
           
           while(Y!=220){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
            this.wjazd_na_chate();
                 if(celY==cel2Y){
                    while(X!=cel2X){
                  this.jazda_prawo();
               }
                this.wjazd_na_chate();   
                 this.jazda_restauracja();
                }else{
                    if(X<980  && cel2Y==120){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==120){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                     if(X<980  && cel2Y==390){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==390){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                      if(X<980  && cel2Y==550){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==550){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                       if(X<980  && cel2Y==630){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==630){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                }
                
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                        }
           
           else{
                   if(celY==390){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=460){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
              if(celY==cel2Y){
                    while(X!=cel2X){
                  this.jazda_prawo();
               }
                this.wjazd_na_chate();   
                 this.jazda_restauracja();
                }else{
                    if(X<980  && cel2Y==120){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==120){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                     if(X<980  && cel2Y==300){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==300){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                      if(X<cel2X  && cel2Y==550){
                        while(X!=cel2X){
                            this.jazda_prawo();
                        }
                      
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                       
                        
                    }else{
                        if(X>cel2X && cel2Y==550){
                            while(X!=cel2X){
                            this.jazda_lewo();
                        }
                        
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }else{
                            if(X==cel2X && cel2Y==550){
                          this.wjazd_na_chate();
                          this.jazda_restauracja();  
                            }
                        }
                       
                    }
                       if(X<980  && cel2Y==630){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==630){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                }
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                   else{
                        if(celY==550){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=460){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
            this.wjazd_na_chate();
              if(celY==cel2Y){
                    while(X!=cel2X){
                  this.jazda_prawo();
               }
                this.wjazd_na_chate();   
                 this.jazda_restauracja();
                }else{
                    if(X<980  && cel2Y==120){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==120){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                     if(X<980  && cel2Y==300){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==300){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                      if(X<cel2X  && cel2Y==390){
                        while(X!=cel2X){
                            this.jazda_prawo();
                        }
                      
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                       
                        
                    }else{
                        if(X>cel2X && cel2Y==390){
                            while(X!=cel2X){
                            this.jazda_lewo();
                        }
                        
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }else{
                            if(X==cel2X && cel2Y==390){
                          this.wjazd_na_chate();
                          this.jazda_restauracja();  
                            }
                        }
                       
                    }
                       if(X<980  && cel2Y==630){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==630){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=700){
                            this.jazda_dół();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                }
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                        else{
                            if(celY==630){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=700){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
               if(celY==cel2Y){
                    while(X!=cel2X){
                  this.jazda_prawo();
               }
                this.wjazd_na_chate();   
                 this.jazda_restauracja();
                }else{
                    if(X<980  && cel2Y==300){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==300){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=220){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                     if(X<980  && cel2Y==390){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==390){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                      if(X<980  && cel2Y==550){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==550){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=460){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                       if(X<980  && cel2Y==120){
                        while(X!=980){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                      if(cel2X<980){
                          while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } else{
                          while(X!=cel2X){
                              this.jazda_prawo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                      } 
                        
                    }else{
                        if(X>980 && cel2Y==120){
                            while(X!=1480){
                            this.jazda_prawo();
                        }
                        while(Y!=20){
                            this.jazda_gora();
                        }
                        while(X!=cel2X){
                              this.jazda_lewo();
                          }
                          this.wjazd_na_chate();
                          this.jazda_restauracja();
                        
                        }
                       
                    }
                }
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                            else{
                                 if(celY==120 && celX==120){
                   this.setY(100);
               this.setX(40);
                while(Y!=120){
                  this.jazda_dół();
           }
                 for (int i = 0; i < 30; i++) {
                   this.jazda_prawo();
                   
               }
               this.sleep(100);
                for (int i = 0; i < 30; i++) {
                   this.jazda_lewo();
                   
               }
                if(cel2Y==300){
                    while(Y!=220){
                        this.jazda_dół();
                    }
                    while(X!=cel2X){
                        this.jazda_prawo();
                    }
                    this.wjazd_na_chate();
                    this.jazda_restauracja();
                }else{
                    if(cel2Y==390 || cel2Y==550){
                         while(Y!=460){
                        this.jazda_dół();
                    }
                    while(X!=cel2X){
                        this.jazda_prawo();
                    }
                    this.wjazd_na_chate();
                    this.jazda_restauracja();
                    }
                    else{
                         if(cel2Y==630){
                    while(Y!=700){
                        this.jazda_dół();
                    }
                    while(X!=cel2X){
                        this.jazda_prawo();
                    }
                    this.wjazd_na_chate();
                    this.jazda_restauracja();
                }
                    }
                }
                dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
               }
                            }
                        }
                   }
                }
     } 
                
                  
                  
                  
               }
           }
}
       
       
       public void jazda() throws InterruptedException{
           while(rozwozi==true){
          sprawdzacz_kolizji();
           if(celY==120 && celX>120){
               this.setY(20);
               this.setX(200);
               while(X!=celX){
                  this.jazda_prawo();
               }
             this.wjazd_na_chate();
               this.jazda_restauracja();
              
             
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
              
           }
           else{
              
           if(celY==300){
               this.setY(100);
               this.setX(40);
               
           
           while(Y!=220){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
                this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                        }
           
           else{
                   if(celY==390){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=460){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
               this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                   else{
                        if(celY==550){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=460){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
             this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                        else{
                            if(celY==630){
                      this.setY(100);
               this.setX(40);
               
           
           while(Y!=700){
                  this.jazda_dół();
           }
          while(X!=celX){
              this.jazda_prawo();
          }
           this.wjazd_na_chate();
               this.jazda_restauracja();
              dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
                   }
                            else{
                                 if(celY==120 && celX==120){
                   this.setY(100);
               this.setX(40);
                while(Y!=120){
                  this.jazda_dół();
           }
                 for (int i = 0; i < 30; i++) {
                   this.jazda_prawo();
                   
               }
               this.sleep(100);
                for (int i = 0; i < 30; i++) {
                   this.jazda_lewo();
                   
               }
                while(Y!=100){
                  this.jazda_gora();
           }
                dostawcy.add(this);
              aktywni_dost.remove(this.PESEL);
              rozwozi=false;
               }
                            }
                        }
                   }
                }
     }
    }
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
    @Override
    public synchronized void run(){
    while(true){
      
        try {
            odbierzZamowienie();
            
            Mapa.repaint();
            switch(this.Prawo_jazdy){
                case 0:   
            jazda();
            break;
                case 1:
                    jazda_smok();
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Dostawca.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
    }
      
            
}
}