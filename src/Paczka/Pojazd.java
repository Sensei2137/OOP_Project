/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paczka;

import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Pojazd {
    int pojemność;
    int prędkość;
    String nr_rejestracyjny;
    int zbiornik_paliwa;
    int spalanie;
    int pojemność_zbiornika;
    public void setPojemność(){
        
        }
    public void setPrędkość(int prędkość){
        this.prędkość=prędkość;
    }
    public void setNr_rejestracyjny(String nr_rejestracyjny){
        this.nr_rejestracyjny=nr_rejestracyjny;
    }
    public void setId(){
    
    }
    public int getPrędkość(){
        return prędkość;
    }
    public int getPojemność(){
        return pojemność;
    }
    public String getNr_rejestracyjny(){
        return nr_rejestracyjny;
    }
    public int getZbiornik(){
        return zbiornik_paliwa;
    }
   public void jedz(){
       zbiornik_paliwa=zbiornik_paliwa-spalanie;
   }
    
    public void tankuj(){
        this.zbiornik_paliwa=pojemność_zbiornika;
    }
    public void setZbiornik(){
        
    }
    public void setSpalanie(){
        }
    
     public void setObraz()throws IOException {
    
      }
}
