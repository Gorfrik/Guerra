/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guerra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Guerra {

    public static void MENU() {
        System.out.println("1).Crear un nuevo personaje.");
        System.out.println("2).Añadir arma al inventario");
        System.out.println("3).Equipar un arma");
        System.out.println("4).");
        System.out.println("5).");
        System.out.println("6).");
        System.out.println("7).");
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<personaje> personajes = new ArrayList();
        /* ArrayList<Arma> Armas = new ArrayList();

        Arco ar = new Arco();
        Armas.add(ar);
        Espada es = new Espada();
        Armas.add(es);*/
        int buscar;
        int caso;
        do {
            MENU();
            caso = sn.nextInt();
            switch (caso) {
                case 1:

                    personaje pj = new personaje("nombre");
                    personajes.add(pj);
                    break;
                case 2:
                    buscar = buscarpj(personajes);
                    System.out.println("Se añade argo [0]");
                    personajes.get(buscar).setArmaspj(new Arco());
                    System.out.println("Se añade espada [1]");
                    personajes.get(buscar).setArmaspj(new Espada());

                    break;
                case 3:
                    buscar = buscarpj(personajes);
                    personajes.get(buscar).equipar();
                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        } while (caso != 5);
        System.out.println("Fin");

    }

    public static int buscarpj(ArrayList<personaje> personajes) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Cual sera su nombre?");
        String nombre = sn.next();
        for (int i = 0; i < personajes.size(); i++) {
            if (nombre.equalsIgnoreCase(personajes.get(i).getNombre())) {
                return i;
            }
        }

        return -1;
    }
}
