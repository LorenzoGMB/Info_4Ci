/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opendata2;


import java.util.Vector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Lettura di un file csv
 * @author Gamba
 */
public class Grafico1 extends Application {

    public static void go() {
        launch();    
    }

    /**
     * metodo per la creazione dell'interfaccia grafica
     * @param stage 
     */
    @Override
    public void start(Stage stage){
        
        Vector<Anno> years = new Vector<Anno>();
        years = Main.vetCharge();
        
        String primoDato = "Giorni tropicali";       // Stringa per la legenda 
        String secondoDato = "Notti tropicali";      // Stringa per la legenda 
        
        stage.setTitle("Grafico giorni tropicali");                             // nome della scheda
        final NumberAxis xAX = new NumberAxis(1991, 2017, 1);                   // asse delle x con gli anni
        final NumberAxis yAX = new NumberAxis();                                // asse delle y con i numeri di giorni e notti
        final AreaChart<Number,Number> bc = new AreaChart<>(xAX,yAX);           // grafico
        bc.setTitle("GIORNI E NOTTI CON TEMPERATURE TROPICALI");                // nome del grafico
        xAX.setLabel("Anno");                                                   // etichetta dell'asse X
        yAX.setLabel("Valore");                                                 // etichetta dell'asse Y
        
        XYChart.Series Night = new XYChart.Series();                            // prima serie di valori pe i GIORNI
        Night.setName(primoDato);
        
        XYChart.Series Day = new XYChart.Series();                              // seconda serie di valori per le NOTTI
        Day.setName(secondoDato);
        
        for (int i = 0; i < years.size(); i++) {                                // inserimento dei valori delle due serie
            Night.getData().add(new XYChart.Data(years.get(i).getYear(), years.get(i).getNight()));
            Day.getData().add(new XYChart.Data(years.get(i).getYear(), years.get(i).getDay()));
        }
        
        Scene scene  = new Scene(bc,1200,600);                                  // creazione e visualizzazione della scena
        bc.getData().addAll(Night, Day);
        stage.setScene(scene);
        stage.show();
    }
}
