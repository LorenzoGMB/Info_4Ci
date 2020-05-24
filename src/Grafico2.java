/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opendata2;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JFrame;

/**
 * classe per disegnare i PC
 * @author Gamba
 */
public class Grafico2 extends Canvas
{   
    @Override
    public void paint(Graphics g)
    {
        Vector<Anno> years = new Vector<Anno>();
        years = Main.vetCharge();
        Anno tempAnno;
        int[] scala = new int[2];
        int[] Xpoints = new int[years.size()];
        int[] Ypoints = new int[years.size()];
        
        g.drawLine(70,50,70,500);                                               // asse y
        g.drawLine(70,500,1100,500);                                            // asse x
        
        
        Font bold = new Font("Courier", Font.BOLD,12);                          // scala asse y
        g.setFont(bold);
        for (int i = 0; i < 19; i++) {
            scala[0] = i * 5;
            scala[1] = 503 - (i * 25);
            g.drawString(String.valueOf(scala[0]) + " -", 50 , scala[1]);       
        }
        
        for (int i = 0; i < years.size(); i++) {                                // scala asse x  
            scala[0] = 1991 + i;
            scala[1] = 70 + (i * 39);
            Xpoints[i] = scala[1] + 15;
            g.drawString(String.valueOf(scala[0]), scala[1] , 515);
        }
        
        for (int i = 0; i < years.size(); i++) {                                // linea giorni in rosso
           tempAnno = (Anno)years.get(i);
           Ypoints[i] = (500 - (450 * tempAnno.getDay()) / 90);
        }
        g.setColor(Color.RED);
        g.drawPolyline(Xpoints, Ypoints, years.size());
        
        for (int i = 0; i < years.size(); i++) {                                // linea giorni in rosso
           tempAnno = (Anno)years.get(i);
           Ypoints[i] = (500 - (450 * tempAnno.getNight()) / 90);
        }
        g.setColor(Color.BLUE);
        g.drawPolyline(Xpoints, Ypoints, years.size());
        
        Font bold1 = new Font("Arial", Font.BOLD,30);                           // TITOLO
        g.setFont(bold1);
        g.setColor(Color.BLACK);
        g.drawString("Grafico giorni e notti tropicali",380,40);
        Font bold2 = new Font("Arial", Font.BOLD,16);
        g.setFont(bold2);

        g.setColor(Color.BLUE);                                                 // legenda
        g.fillRect(653 , 555, 115, 27);
        g.setColor(Color.WHITE);
        g.drawString("Notti tropicali",660,575);
        g.setColor(Color.RED);
        g.fillRect(433 , 555, 125, 27);
        g.setColor(Color.WHITE);
        g.drawString("Giorni tropicali",440,575);
    }
    
    /**
     * metodo per la creazione della GUI con il grafico
     * @param ys years
     */
    public static void go()
    {
        JFrame jf = new JFrame("Grafico");
        jf.setLocation(650,100);
        jf.setSize(1200,650);
        jf.setVisible(true);
        Grafico2 cnvsD = new Grafico2();
        jf.add(cnvsD);
    }
}
