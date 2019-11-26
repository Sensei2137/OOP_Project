package Paczka;

import static Paczka.Klient.zamowienie;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author ASUS
 */
public class Restauracja extends Thread {
        public static Queue<Posiłek> odebrane_zamowienia = new ArrayDeque<>();
         public static Queue<Klient> zleceniodawca = new ArrayDeque<>();
        public final Lock restLock = new ReentrantLock();
        public synchronized void odbierz_zamowienie() throws InterruptedException{
            while(true){
            
           
                for (Map.Entry<Klient, Posiłek> entry : zamowienie.entrySet()) {
                    Klient key = entry.getKey();
                    Posiłek value = entry.getValue();
                    
                    Thread.sleep(value.getCzas());
                    restLock.lock();
                    try {
                        zleceniodawca.add(key);
                        odebrane_zamowienia.add(value);
                        zamowienie.remove(key);
                    } finally {
                        restLock.unlock();
                    }
                    break;
                }
                
             
                    
                Thread.sleep(100);
            }
        }
    
        @Override
    public void run(){
        
        while(true){
            try {
                odbierz_zamowienie();
            } catch (InterruptedException ex) {
                Logger.getLogger(Restauracja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

