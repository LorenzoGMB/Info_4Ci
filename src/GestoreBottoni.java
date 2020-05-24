/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opendata2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 * Classe per gestire i bottoni della GUI
 * @author Gamba
 */
class GestoreBottoni implements ActionListener
{  
    private final JComboBox typeG;
    
    public GestoreBottoni(JComboBox type)
    {
        this.typeG = type;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String content = e.getActionCommand();
        if(content.equals("Visualizza grafico"))
        {
            switch(typeG.getSelectedIndex())
            {
                case 0: 
                {
                    Grafico1.go();
                }break;
                    
                case 1:
                {
                    Grafico2.go();
                }break;
            }
        }
    }
}
   

