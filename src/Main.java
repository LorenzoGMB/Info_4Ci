/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opendata2;


import javax.swing.UIManager;
import javax.swing.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Vector;

/**
 *
 * @author User
 */
public class Main {
    
    public static void main (String[] args)
    {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) { System.out.println(e.getMessage()); }
        
        Anno tempAnno;
        Vector<Anno> years = new Vector<Anno>();
        years = Main.vetCharge();
        String[] columnNames = new String[3]; 
        columnNames[0] = "Anno";
        columnNames[1] = "Giorni tropicali";
        columnNames[2] = "Notti tropicali";
        int size = years.size();
        String[][] data = new String[size][3];
        for (int i = 0; i < years.size(); i++) {
            tempAnno = years.get(i);
            data[i][0] = String.valueOf(tempAnno.getYear());
            data[i][1] = String.valueOf(tempAnno.getDay());
            data[i][2] = String.valueOf(tempAnno.getNight());
        }
        
        JFrame jf = new JFrame();
        jf.setTitle("Gamba");
        jf.addWindowListener(new GestoreFinestra());
        jf.setLocation(100, 100);
        jf.setVisible(true);
        
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints ly = new GridBagConstraints();
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Giorni e notti tropicali"));
        
        Container c = jf.getContentPane();
        c.add(p);
        
        
        JLabel year = new JLabel("",JLabel.RIGHT);
        Font bold = new Font("Arial", Font.BOLD,12);
        year.setFont(bold);
        year.setText("  Anno");
        ly.insets = new Insets(10,10,0,0);
        ly.gridx = 0;
        ly.gridy = 0;
        p.add(year,ly);
        JLabel day = new JLabel("",JLabel.RIGHT);
        day.setFont(bold);
        day.setText("         Giorni");
        ly.gridx = 1;
        ly.gridy = 0;
        p.add(day,ly);
        JLabel night = new JLabel("",JLabel.RIGHT);
        night.setFont(bold);
        night.setText("Notti");
        ly.insets = new Insets(10,-10,0,0);
        ly.gridx = 2;
        ly.gridy = 0;
        p.add(night,ly);
        
        JTable tb = new JTable(data, columnNames); 
        tb.disable();
        ly.insets = new Insets(0,10,10,5);
        ly.weightx = 0.5;
        ly.gridwidth = 3;
        ly.gridheight = 20;
        ly.gridx = 0;
        ly.gridy = 1;
        p.add(tb,ly);
        
        JLabel msg = new JLabel("",JLabel.RIGHT);
        msg.setText("Nella tabella qui accanto sono riportati in");
        ly.insets = new Insets(10,10,0,10);
        ly.gridheight = 1;
        ly.gridx = 3;
        ly.gridy = 2;
        p.add(msg,ly);
        JLabel msg1 = new JLabel("",JLabel.RIGHT);
        msg1.setText("ordine cronologico i giorni e le notti con");
        ly.insets = new Insets(0,10,0,10);
        ly.gridx = 3;
        ly.gridy = 4;
        p.add(msg1,ly);
        JLabel msg2 = new JLabel("",JLabel.RIGHT);
        msg2.setText("temperature tropicali registrate negli anni");
        ly.gridx = 3;
        ly.gridy = 5;
        p.add(msg2,ly);
        JLabel msg3 = new JLabel("",JLabel.RIGHT);
        msg3.setText("dal 1991 al 2017.");
        ly.gridx = 3;
        ly.gridy = 6;
        p.add(msg3,ly);
        JLabel msg4 = new JLabel("",JLabel.RIGHT);
        msg4.setText("I dati sono stati presi del sito ufficiale");
        ly.gridheight = 1;
        ly.gridx = 3;
        ly.gridy = 7;
        p.add(msg4,ly);
        JLabel msg5 = new JLabel("",JLabel.RIGHT);
        msg5.setText("dell'Arpa Piemonte nella sezione open Data.");
        ly.gridx = 3;
        ly.gridy = 8;
        p.add(msg5,ly);
        JLabel msg6 = new JLabel("",JLabel.RIGHT);
        msg6.setText("Non sono stati modificati in alcun modo");
        ly.insets = new Insets(0,10,10,10);
        ly.gridx = 3;
        ly.gridy = 9;
        p.add(msg6,ly);
        
        JComboBox type = new JComboBox();
        type.addItem("                      Grafico ad area               ");
        type.addItem("              Diagramma cartesiano            ");
        ly.insets = new Insets(5,10,5,10);
        ly.gridx = 3;
        ly.gridy = 11;
        p.add(type,ly);
        
        JButton show = new JButton("Visualizza grafico");
        ly.insets = new Insets(5,10,10,10);
        ly.gridx = 3;
        ly.gridy = 12;
        p.add(show,ly);
        
        show.addActionListener(new GestoreBottoni(type));
        
        jf.pack();
    }
    
    /**
     * lettura del file e caricamento del vettore
     * @return 
     */
    public static Vector vetCharge()
    {
        String File = "file.csv";                                               // nome del file
        String line;                                                            // stringa che conterra ogni linea del file
        String cvsSplit = ",";                                                  // separatore
        String[] data;                                                          // arr di stringhe conterra i dati di ogni riga
        
        int counter = 0;                                                        // contatore
        Vector<Anno> years = new Vector<>(27,1);                                // vettore di anni
        
        try (BufferedReader br = new BufferedReader(new FileReader(File)))      // apertura del file
        {
            line = br.readLine();                                               // leggo la prima riga e la uso per indicare
            
            while ((line = br.readLine()) != null)                              // legge una riga per volta fino alla fine del file 
            {
                data = line.split(cvsSplit);                                    // divide ogni linea in tante stringhe ogni volta che incontra un ;
                
                years.add(new Anno());                                          // aggiungo un nuovo anno al vettore e uno i dati di prima per costruirlo
                years.get(counter).setNight(Integer.valueOf(data[2]));
                years.get(counter).setDay(Integer.valueOf(data[1]));
                years.get(counter).setYear(Integer.valueOf(data[0]));
                
                counter ++;
            }
        } 
        catch (IOException e) 
        { System.out.println(e.getMessage()); }
        
        return years;
    }
}
