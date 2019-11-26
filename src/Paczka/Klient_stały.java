/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paczka;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS
 */
public class Klient_stały extends Klient{
   int punkty;
   int zniżka;
    public static BufferedImage dom2;
   public void setPunkty(int punkty){
       this.punkty=punkty;
   }
   public void setZniżka(int zniżka){
       this.zniżka=zniżka;
   }
   public int getZniżka(){
       return zniżka;
   }
   public int getPunkty(){
       return punkty;
   }
   @Override
    public void setID(){
      this.ID=2;  
    }
    
   @Override
      public void setDom() throws IOException{
    dom2 = ImageIO.read(getClass().getResource("klient_stały.png"));
      }
}