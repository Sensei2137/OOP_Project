/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paczka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class Menu extends javax.swing.JFrame {
public static Karta_dań m = new Karta_dań();
   static List<Integer> pozycjaX = new ArrayList<>();
   static List<Integer> pozycjaY = new ArrayList<>();
   Random generator = new Random();
public static Map<Integer,Klient> klienci = new HashMap<>();
public static List<Dostawca> dostawcy = new ArrayList<>();
public static Map<Integer,Dostawca> aktywni_dost = new HashMap<>();
public static final Lock klientLock = new ReentrantLock();
int temp;
int temp2;

    /**
     * Creates new form Menu
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public Menu() throws IOException, InterruptedException {
        initComponents();
      
       
    }
    
 public static void ustaw_tabliceX(){
    //45 960 1450
       
       pozycjaX.add(120);
       pozycjaX.add(240);
       pozycjaX.add(360);
       pozycjaX.add(480);
       pozycjaX.add(600);
       pozycjaX.add(720);
       pozycjaX.add(840);
       pozycjaX.add(1080);
       pozycjaX.add(1180);
       pozycjaX.add(1280);
       pozycjaX.add(1380);
   }
    
     public static void ustaw_tabliceY(){
         //230 460 700
         pozycjaY.add(120);
          pozycjaY.add(300);
           pozycjaY.add(390);
            pozycjaY.add(550);
            pozycjaY.add(630);
      
 
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton2 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        try {
            Mapa = new Paczka.Mapke();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        jToggleButton3 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton2.setText("Wyjdź");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Dodaj żarło");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Wyświetl karte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Mapa.setName("Mapa"); // NOI18N
        Mapa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MapaMouseMoved(evt);
            }
        });
        Mapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MapaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout MapaLayout = new javax.swing.GroupLayout(Mapa);
        Mapa.setLayout(MapaLayout);
        MapaLayout.setHorizontalGroup(
            MapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        MapaLayout.setVerticalGroup(
            MapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 834, Short.MAX_VALUE)
        );

        jToggleButton3.setText("Dodaj klienta okazjonalnego");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setViewportView(jTextArea1);

        jButton3.setText("Dodaj klienta firmowego");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Dodaj dostawcę");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Dodaj klienta stałego");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Usuń dostwacę");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Usuń klienta");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Zamów");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Aktualne informacje");

        jButton9.setText("Zawróć");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton3)
                        .addGap(41, 41, 41)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jButton2))
                            .addComponent(jButton1))
                        .addGap(31, 31, 31)
                        .addComponent(jButton4)))
                .addGap(33, 33, 33)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(713, 713, 713))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addGap(52, 52, 52)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)))
                        .addContainerGap(967, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(911, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton8))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton9))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(jToggleButton2)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        System.exit(0); // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            m.Dodaj_posiłek();         // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
               
            jTextArea1.setText("Cena"+"    "+"Nazwa"+ "    "+ "Kategoria"+ "\n");
                for (int i = 0; i < m.karta.size(); i++) {
           Posiłek get = m.karta.get(i);
           
           jTextArea1.append(Integer.toString(get.getCena()));
            jTextArea1.append("   " + get.getNazwa()+ "   ");
            jTextArea1.append(get.getkategoria()+"\n");
                
              
                
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    }
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
    try {
        
        Klient_okazjonalny k = new Klient_okazjonalny();
        k.setNazwisko();
        k.setTelefon();
        k.setDom();
        k.setID();
        
        int rand = generator.nextInt(pozycjaX.size());
        
        k.setX(pozycjaX.get(rand));
        int rand1 = generator.nextInt(pozycjaY.size());
        k.setY(pozycjaY.get(rand1));
        k.setAdres();
  
    
            
           klientLock.lock();
        try {
            klienci.put(Integer.parseInt(k.getAdres()),k);
            new Thread(k).start();
            //   Mapa.repaint();
        } finally {
            klientLock.unlock();
        }
        
        
        
        
    } 
    catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    try {
       
        Klient_firmowy k = new Klient_firmowy();
        k.setNazwisko();
        k.setTelefon();
        k.setDom();
        k.setRegon();
        k.setID();
       int rand = generator.nextInt(pozycjaX.size());
        k.setX(pozycjaX.get(rand));
        int rand1 = generator.nextInt(pozycjaY.size());
        k.setY(pozycjaY.get(rand1));
      k.setAdres();
      
            klienci.put(Integer.parseInt(k.getAdres()),k);
               new Thread(k).start();
           
                
           
               
       
               
  
    } catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {
        Dostawca d = new Dostawca();
        d.setNazwisko();
        d.setPESEL();
        d.setPrawko();
        
        d.setPojazd();
        
        dostawcy.add(d);
        new Thread(d).start();
        
       
    } catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    try {
        
        Klient_stały k = new Klient_stały();
        k.setNazwisko();
        k.setTelefon();
        k.setDom();
        k.setID();
        int rand = generator.nextInt(pozycjaX.size());
        k.setX(pozycjaX.get(rand));
        int rand1 = generator.nextInt(pozycjaY.size());
        k.setY(pozycjaY.get(rand1));
        k.setAdres();
         klienci.put(Integer.parseInt(k.getAdres()),k);
        
            new Thread(k).start();
          
            
        
        
       
        
        
     
    } catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
aktywni_dost.remove(temp2); 
                jTextArea1.setText("usunięto");
                jButton6.setVisible(false);
                 jButton9.setVisible(false);
    try {
        synchronized( aktywni_dost.get(temp2)){
        aktywni_dost.get(temp2).wait();}
        
    } catch (InterruptedException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }         
             
    }//GEN-LAST:event_jButton6ActionPerformed

    private void MapaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapaMouseMoved
        
    }//GEN-LAST:event_MapaMouseMoved

    private void MapaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapaMouseReleased
      
        for (Map.Entry<Integer, Klient> entry : klienci.entrySet()) {
            Integer key = entry.getKey();
            Klient value = entry.getValue();
            if((evt.getX()-value.getX()<=70 && evt.getX()-value.getX()>=0) && (evt.getY()-value.getY()<=70&&evt.getY()-value.getY()>=0)){
                jTextArea1.setText("Nazwisko:" + " " + value.getNazwisko()+ "\n" + "Telefon:" + " " + value.getTelefon()+" \n" + "Adres:" + " " + value.getAdres());
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                jButton6.setVisible(false);
                jButton9.setVisible(false);
                temp = key;
            
            }
        
          }
        for (Map.Entry<Integer, Dostawca> entry : aktywni_dost.entrySet()) {
            Integer key = entry.getKey();
            Dostawca value = entry.getValue();
             if((evt.getX()-value.getX()<=70 && evt.getX()-value.getX()>=0) && (evt.getY()-value.getY()<=70&&evt.getY()-value.getY()>=0)){
                jTextArea1.setText("Nazwisko:" + " " +value.getNazwisko()+ "\n" + "PESEL:" + " " +value.getPESEL()+" \n" + "Prawo jazdy (1-smok/0-koń):" + " " +value.getPrawko());
                jButton6.setVisible(true);
                jButton9.setVisible(true);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                temp2 = key;
              
            
            }
            
        }
        
    }//GEN-LAST:event_MapaMouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
                
    
       
    
                klienci.remove(temp); 
                jTextArea1.setText("usunięto");
                jButton7.setVisible(false);
                 jButton8.setVisible(false);
    try {
        synchronized( klienci.get(temp)){
        klienci.get(temp).wait();}
        
    } catch (InterruptedException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }
                
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        klienci.get(temp).zamów(m);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       if(aktywni_dost.get(temp2).getPrawko()==0)
       jTextArea1.setText("Ten rycerz predzej umrze, niż przerwie swoja misje");
       else
    jTextArea1.setText("Naprawde chcesz rozkazywac smokowi, mosci DB?");   
       jButton7.setVisible(false);
       jButton8.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               
               try {
                  Menu z = new Menu();
                   z.setVisible(true);
                   for (int i = 0; i < 10; i++) {
                       m.Dodaj_posiłek();
                       
                   }
                   jButton7.setVisible(false); 
                    jButton8.setVisible(false);
                     jButton6.setVisible(false);
                      jButton9.setVisible(false);
                   ustaw_tabliceX();
                   ustaw_tabliceY();
                   Restauracja r = new Restauracja();
                   r.start();
                  
                       //Mapa.repaint();
                   
                   
               } catch (IOException | InterruptedException ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
             
             
              
             
                
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static Paczka.Mapke Mapa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static final transient javax.swing.JButton jButton7 = new javax.swing.JButton();
    public static javax.swing.JButton jButton8;
    public static javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables

     

    
}