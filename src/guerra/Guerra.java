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
        System.out.println("2).A�adir arma al inventario");
        System.out.println("3).Quitar arma del inventario");
        System.out.println("4).Comenzar combate");
        System.out.println("5).");
        System.out.println("6).");
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<personaje> personajes = new ArrayList();

        personajes.add(new personaje("Paco"));
        personajes.add(new personaje("Manolo"));

        personajes.get(0).a�adirArm(new Espada());
        personajes.get(0).a�adirArm(new Arco());
        personajes.get(0).a�adirArm(new Escudo());
        personajes.get(0).a�adirArm(new Armadura());

        personajes.get(1).a�adirArm(new Espada());
        personajes.get(1).a�adirArm(new Arco());
        personajes.get(1).a�adirArm(new Escudo());
        personajes.get(1).a�adirArm(new Armadura());

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
                        System.out.println("Que arma vas a a�adir");
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
                            personajes.get(buscar).a�adirArm(weepon);
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
                            System.out.println("-=" + personajes.get(jug1).getNombre() + " VS " + personajes.get(jug2).getNombre() + "=-");
                            combate(personajes, jug1, jug2);

                        } else {
                            System.out.println("No se encontro personaje");
                        }

                    } else {
                        System.out.println("No se encontro personaje");
                    }
                    break;
                case 5:

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

    public static void combate(ArrayList<personaje> personajes, int jug1, int jug2) {

        System.out.println("\n-Comienza " + personajes.get(0).getNombre() + "\n");

        int contadorRondas = 0;
        do {
            int atacante;
            int defensor;
            if (contadorRondas % 2 == 0) {
                atacante = jug1;
                defensor = jug2;
            } else {
                atacante = jug2;
                defensor = jug1;
            }
//Atacante
            verArmasVida(personajes, atacante, 0);
            int consultaata=suvirStats(personajes.get(atacante), 0);

//Defensor
            verArmasVida(personajes, defensor, 1);
            int consultadef = suvirStats(personajes.get(defensor), 1);

//Comienzo combate
            double vida = personajes.get(defensor).getPuntosVida();

            if (personajes.get(defensor).getArmaspj().get(consultadef)
                    instanceof Defensa def ) {
                
                double da�o =vida - personajes.get(atacante).getPuntosAtaque()
                        -(personajes.get(atacante).getPuntosAtaque()*def.PorcentajeVida);
                personajes.get(defensor).setPuntosVida(vida-da�o);
                

                
            } else {
                personajes.get(defensor).setPuntosVida(vida-personajes.get(atacante).getPuntosAtaque());
            }

            contadorRondas++;
        } while (true);

    }

    public static int suvirStats(personaje pj, int roll) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escoge un arma:");
        String Arma = sn.next();
        int consulta = -1;
        if (roll % 2 == 0) {
            for (int i = 0; i < pj.getArmaspj().size(); i++) {
                if (Arma.equalsIgnoreCase("Espada")) {
                    if (pj.getArmaspj().get(i) instanceof Espada esp) {
                        System.out.println("Espada equipada");
                        esp.equiparPersonaje(pj);
                        consulta = 1;
                    }
                } else if (Arma.equalsIgnoreCase("Arco")) {
                    if (pj.getArmaspj().get(i) instanceof Arco arc) {
                        System.out.println("Arco equipado!");
                        arc.equiparPersonaje(pj);
                        consulta = 2;
                    }

                } else {
                    System.out.println("No se encontro arma vas a pu�os");
                }

            }
            System.out.println("P.Ata= " + pj.getPuntosAtaque());
        } else {
            for (int i = 0; i < pj.getArmaspj().size(); i++) {
                if (pj.getArmaspj().get(i) instanceof Armadura arm) {
                    System.out.println("Armadura equipada");
                    arm.equiparPersonaje(pj);
                    consulta = 3;

                } else if (pj.getArmaspj().get(i) instanceof Escudo esc) {
                    System.out.println("Escudo equipado");
                    esc.equiparPersonaje(pj);
                    consulta = 4;
                } else {
                    System.out.println("No se encontro defensa vas en faldita");
                }

            }

        }
        return consulta;
    }

    public static void resetStats() {

    }

    public static void verArmasVida(ArrayList<personaje> personajes, int jugador, int roll) {
        System.out.println(personajes.get(jugador).getNombre());
        System.out.println("Vida: " + personajes.get(jugador).getPuntosVida());
        System.out.println("Armas/Defensa:");

        for (int i = 0; i < personajes.get(jugador).getArmaspj().size(); i++) {
            if (roll % 2 == 0) {
                if (personajes.get(jugador).getArmaspj().get(i) instanceof Arco) {
                    System.out.println("- Arco");
                }

                if (personajes.get(jugador).getArmaspj().get(i) instanceof Espada) {
                    System.out.println("- Espada");
                }
            } else {
                if (personajes.get(jugador).getArmaspj().get(i) instanceof Escudo) {
                    System.out.println("- Escudo");
                }

                if (personajes.get(jugador).getArmaspj().get(i) instanceof Armadura) {
                    System.out.println("- Armadura");
                }
            }
        }
    }
}
