/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opendata2;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Classe per gestire i bottoni della finestra
 * @author Gamba
 */
class GestoreFinestra implements WindowListener
{
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowClosing(WindowEvent e) 
    {
        System.out.println("Programma terminato");
        System.exit(0);
    }
}