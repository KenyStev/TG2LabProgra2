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
    protected double pagoRenta(int días) {
        
    }
    
    @Override
    public String toString(){
        return super.toString() + getEstado() + " - Movie"; 
    }
    
    public String getEstado(){
        Calendar now = Calendar.getInstance();
        now.getTime();
        if (fecha.get(Calendar.MONTH) < now.get(Calendar.MONTH)) {
            return "ESTRENO";
        }
        return "NORMAL";
    }
    
    
    
}
