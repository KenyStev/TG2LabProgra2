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

    static ArrayList<RentItem> items = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int opt;
        do {
            System.out.print(
                    "1. Add Item\n"
                    + "2. Rentar\n"
                    + "3. Ejecutar Submenu\n"
                    + "4. Imprimir todo\n"
                    + "5. Salir\n"
                    + "Escoja su opcion: ");
            opt = scan.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Ingrese el codigo, nombre y tipo(PS3/MOVIE) separado por espacios: ");
                    addItem(scan.nextInt(), scan.next(), scan.next());
                    break;
                case 2:
                    System.out.print("Ingrese el codigo: ");
                    rent(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Ingrese el codigo");
                    submenu(scan.nextInt());
                case 4:
                    print();
            }
        } while (opt != 5);
    }

    static void addItem(int code, String name, String tipo) {
        switch (tipo.toLowerCase()) {
            case "movie":
                System.out.print("Ingrese el Precio: ");
                items.add(new Movie(code, name, scan.nextDouble()));
                break;
            case "ps3":
                items.add(new PS3Game(code, name));
                break;
        }
    }

    private static void rent(int code) {
        boolean exist = false;
        for (RentItem item : items) {
            if (item.getCode() == code) {
                System.out.print("Dias a Rentar: ");
                System.out.println("Total a Pagar: " + item.pagoRenta(scan.nextInt()));
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Item no Existe!");
        }

    }

    private static void submenu(int cod) {
        boolean existe = false;
        for (RentItem item : items) {
            if (item.getCode() == cod) {
                if (item instanceof MenuActions) {
                    ((MenuActions) item).submenu();
                    System.out.println("Escoja Opcion");
                    ((MenuActions) item).ejecutarOpcion(scan.nextInt());
                }
                existe = true;
            }
        }

    }

    private static void print() {
        for (RentItem rentItem : items) {
            System.out.println(rentItem.toString());
        }
    }

}
