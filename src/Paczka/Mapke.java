package Paczka;

import static Paczka.Klient_firmowy.dom1;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import static Paczka.Klient_okazjonalny.dom;
import static Paczka.Klient_stały.dom2;
import static Paczka.Kuń.kuń;
import static Paczka.Menu.aktywni_dost;
import static Paczka.Menu.klienci;
import static Paczka.Smok.smok;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Mapke extends JPanel {

	/**
	 * No comment.
	 */
	private BufferedImage mapa;
   
       Random generator = new Random();
      
	public  int m = 0;
	/**
	 
	 */
	
    private int l;
	
	
        
	@Override
	public void paintComponent(Graphics g) {
        
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(mapa, 0, 0, null);
             
                    for (Map.Entry<Integer, Klient> entry : klienci.entrySet()) {
                        Integer key = entry.getKey();
                        Klient value = entry.getValue();
                        
                    
                switch(value.getID()){
                        case 0:
                            
                            g.drawImage(dom, value.getX(), value.getY(), null);
                              break;
                        case 1:
                            g.drawImage(dom1, value.getX(), value.getY(), null);
                            break;
                        case 2:
                            g.drawImage(dom2, value.getX(), value.getY(), null);
                            break;
                        default:
                            break;
           
                }
                }
                for (Map.Entry<Integer, Dostawca> entry : aktywni_dost.entrySet()) {
                Integer key = entry.getKey();
                Dostawca value = entry.getValue();
                         switch(value.getPrawko()){
                        case 0:
                            
                            g.drawImage(kuń, value.getX(), value.getY(), null);
                              break;
                        case 1:
                            g.drawImage(smok, value.getX(), value.getY(), null);
                            break;
            }
                  
                    
           
        }
                repaint(); 
        }

	
	public Mapke() throws IOException {
		mapa = ImageIO.read(getClass().getResource("mapa_2.png"));
              
}
}