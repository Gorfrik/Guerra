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
        System.out.println("3).Quitar arma del inventario");
        System.out.println("4).Comenzar combate");
        System.out.println("5).");
        System.out.println("6).");
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
        String elec;
        Arma weepon;
        do {
            MENU();
            caso = sn.nextInt();
            switch (caso) {
                case 1:

                    personaje pj = new personaje("nombre");
                    personajes.add(pj);
                    break;
                case 2:
                    weepon = null;
                    buscar = buscarpj(personajes);
                    if (buscar != -1) {
                        System.out.println("Que arma vas a añadir");
                        elec = sn.next();
                        if (elec.equalsIgnoreCase("arco")) {
                            weepon = new Arco();
                        }
                        if (elec.equalsIgnoreCase("espada")) {
                            weepon = new Espada();
                        }
                        if (elec.equalsIgnoreCase("escudo")) {
                            weepon = new Escudo();
                        }
                        if (elec.equalsIgnoreCase("armadura")) {
                            weepon = new Armadura();
                        } else {
                            System.out.println("No se reconoce arma");
                        }
                        if (weepon != null) {
                            personajes.get(buscar).añadirArm(weepon);
                        }
                    } else {
                        System.out.println("No se encontro personaje");
                    }

                    break;

                case 3:
                    weepon = null;
                    buscar = buscarpj(personajes);
                    if (buscar != -1) {
                        System.out.println("Que arma vas a quitar");
                        elec = sn.next();

                        personajes.get(buscar).quitarArm(elec);
                    } else {
                        System.out.println("No se encontro personaje");
                    }
                    break;
                case 4:
                    int jug1;
                    int jug2;
                    System.out.println("Comienza el combate!!");
                    System.out.println("Selecciona jugador 1");
                    buscar = buscarpj(personajes);
                    if (buscar != -1) {
                        jug1 = buscar;
                        System.out.println("Selecciona jugador 2");
                        buscar = buscarpj(personajes);
                        if (buscar != -1) {
                            jug2 = buscar;
                            System.out.println(personajes.get(jug1) + " VS " + personajes.get(jug2));
                            combate();

                        } else {
                            System.out.println("No se encontro personaje");
                        }

                    } else {
                        System.out.println("No se encontro personaje");
                    }
                    break;
            }
        } while (caso != 5);
        System.out.println("Fin");

    }

    public static int buscarpj(ArrayList<personaje> personajes) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Nombre:");
        String nombre = sn.next();
        for (int i = 0; i < personajes.size(); i++) {
            if (nombre.equalsIgnoreCase(personajes.get(i).getNombre())) {
                return i;
            }
        }

        return -1;
    }

    public static void combate(ArrayList<personaje> personajes,int jug1,int jug2) {
        System.out.println("Comienza "+personajes.get(1));
        System.out.println("Escoge un arma:");
        
        
    }

    public void reset() {
        
        
    }
}
