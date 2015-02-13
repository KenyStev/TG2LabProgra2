/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

/**
 *
 * @author KenyStev
 */
public abstract class RentItem {
    protected int code;
    protected String name;
    protected double precio;

    public RentItem(int code, String name, double precio) {
        this.code = code;
        this.name = name;
        this.precio = precio;
    }
    
    protected abstract double pagoRenta(int días);

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "code=" + code + ", name=" + name + ", precio=" + precio;
    }
}
