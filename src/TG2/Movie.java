/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TG2;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author CarlosHaddad
 */
public class Movie extends RentItem {
    private Calendar fecha;
    
    public Movie(int c, String n, double p){
        super(c, n, p);
        fecha = Calendar.getInstance();
        fecha.getTime().toString();
        
    }

    @Override
    protected double pagoRenta(int dias) {
        if (getEstado().equals("ESTRENO") && dias > 2) {
            return precio + 50*dias; 
        } else if (getEstado().equals("NORMAL") && dias > 5) {
            return precio + 30*dias;
        }
        return precio;
    }
    
    @Override
    public String toString(){
        return super.toString() + getEstado() + " - Movie"; 
    }
    
    public String getEstado(){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -3);
        
        if(fecha.compareTo(now)>=0){
            return "ESTRENO";
        }
        return "NORMAL";
    }
    
}
