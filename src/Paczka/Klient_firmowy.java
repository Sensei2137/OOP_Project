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
public class Klient_firmowy extends Klient{
    private int REGON;
    private int konto;
    private String adres;
   public static BufferedImage dom1;
    public void setRegon(){
        int rand = generator.nextInt(899999999) + 100000000;
        this.REGON=rand;
    }
    public int getRegon(){
        return REGON;
    }
    public void setKonto(int konto){
        this.konto=konto;
    }
    public int getKonto(){
        return konto;
    }
   
    @Override
     public void setDom() throws IOException{
    dom1 = ImageIO.read(getClass().getResource("klient_firmowy.png"));
    
    }
    @Override
    public void setID(){
      this.ID=1;  
    }
}
