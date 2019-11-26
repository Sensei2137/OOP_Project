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
public class Klient_okazjonalny extends Klient {

    public static BufferedImage dom;
    
    
   @Override
   public void setDom() throws IOException{
    dom = ImageIO.read(getClass().getResource("klient_okazjonalny.png"));
    
    }  
    @Override
     public void setID(){
      this.ID=0;  
    }
    
        
    
}
