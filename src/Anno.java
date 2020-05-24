/*
 * Gamba Lorenzo
 * 4CI informatica
 * 19.03.2020
 */
package opendata2;

/**
 * classe anno
 * @author Gamba
 */
public class Anno {
    
    private int year;
    private int day;
    private int night;
    
   /**
    * metodo costruttore
    * @param y years
    * @param d day
    * @param n night
    */
    public void Anno(int y, int d, int n)
    {
        this.year = y;
        this.day = d;
        this.night = n;
    }
    
    /**
     * costruttore di copia
     * @param y Anno
     */
    public void Anno(Anno y)
    {
        this.year = y.getYear();
        this.day = y.getDay();
        this.night = y.getNight();
    }
    
    //-------------------------------- GET E SET PER L'ANNO
    
    /**
     * metodo get per l'anno
     * @return year 
     */
    public int getYear()
    { return year; }
    
    /**
     * metodo set per l'anno
     * @param y year
     */
    public void setYear(int y)
    { this.year = y; }
    
    //-------------------------------- GET E SET PER I GIORNI
    
    /**
     * metodo get per i giorni
     * @return day 
     */
    public int getDay()
    { return day; }
    
    /**
     * metodo set per i giorni
     * @param d day
     */
    public void setDay(int d)
    { this.day = d; }
    
    //-------------------------------- GET E SET PER LE NOTTI
    
    /**
     * metodo get per le notti
     * @return night 
     */
    public int getNight()
    { return night; }
    
    /**
     * metodo set per le notti
     * @param n night
     */
    public void setNight(int n)
    { this.night = n; }
    
}
