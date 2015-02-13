/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KenyStev
 */
public class main {
    static ArrayList<RentItem> items;
    static Scanner scan = new Scanner(System.in);
        
    public static void main(String[] args) {
        
        int opt;
        do{
            System.out.println(
                    "1. Add Item\n"
                            + "2. Rentar\n"
                            + "3. Ejecutar Submenu\n"
                            + "4. Imprimir todo\n"
                            + "Escoja su opcion: ");
            opt = scan.nextInt();
            
            switch(opt){
                case 1:
                    System.out.print("Ingrese el codigo, nombre y tipo(PS3/MOVIE) separado por espacios");
                    addItem(scan.nextInt(), scan.next(), scan.next());
                    break;
            }
        }while(opt!=5);
    }
    
    static void addItem(int code, String name, String tipo){
        switch(tipo.toLowerCase()){
            case "movie":
                
                break;
            case "ps3":
                items.add(new PS3Game(code, name));
                break;
        }
    }
}
