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
public class Kuń extends Pojazd{
    private int id;
    public static BufferedImage kuń;
    /**
     *
     */
    @Override
    public void setId(){
    id=0;
}
     @Override
    public void setSpalanie(){
    this.spalanie=2;

    }
    @Override
    public void setZbiornik(){
        this.pojemność_zbiornika=8;
    }
    @Override
       public void setPojemność(){
    this.pojemność=1;
}
    @Override
    public void setObraz() throws IOException{
    kuń = ImageIO.read(getClass().getResource("dostawca_1.png"));
      }
}
