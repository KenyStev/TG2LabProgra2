/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author KenyStev
 */
public class PS3Game extends RentItem implements MenuActions{
    private Calendar fechaPublicacion;
    private ArrayList<String> especificaciones;

    public PS3Game(int code, String name) {
        super(code, name, 20);
        fechaPublicacion = Calendar.getInstance();
        especificaciones = new ArrayList<>();
    }
    
    public void setFechaPublicacion(int year, int mes, int dia){
        fechaPublicacion.set(year, mes, dia);
    }

    @Override
    public String toString() {
        return "PS3Game{" + super.toString() + " fechaPublicacion=" + fechaPublicacion + '}';
    }

    @Override
    protected double pagoRenta(int dias) {
        return dias*precio;
    }

    @Override
    public void submenu() {
        System.out.println( "1. Actualizar Fecha de Publicación\n" +
                            "2. Agregar Especificacion\n" +
                            "3. Ver Especificaciones");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        Scanner scan = new Scanner(System.in);
        switch(opcion){
            case 1:
                System.out.print("Ingrese la fecha (year-month-day): ");
                String[] fecha = scan.next().split("-");
                int y = Integer.parseInt(fecha[0]);
                int m = Integer.parseInt(fecha[1]);
                int d = Integer.parseInt(fecha[2]);
                fechaPublicacion.set(y, m, d);
                break;
            case 2:
                System.out.print("Ingrese la Espesificacion: ");
                especificaciones.add(scan.next());
                break;
            case 3:
                for(String s : especificaciones)
                    System.out.println(s);
                break;
        }
    }
}
