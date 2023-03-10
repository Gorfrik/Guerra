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

        personajes.add(new personaje("1"));
        personajes.add(new personaje("2"));

        personajes.get(0).añadirArm(new Espada());
        personajes.get(0).añadirArm(new Arco());
        personajes.get(0).añadirArm(new Escudo());
        personajes.get(0).añadirArm(new Armadura());

        personajes.get(1).añadirArm(new Espada());
        personajes.get(1).añadirArm(new Arco());
        personajes.get(1).añadirArm(new Escudo());
        personajes.get(1).añadirArm(new Armadura());

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
            int consultaAta = suvirStats(personajes.get(atacante), 0);

//Defensor
            verArmasVida(personajes, defensor, 1);
            int consultadef = suvirStats(personajes.get(defensor), 1);

//Comienzo combate
            if (consultaAta == -1) {
                personajes.get(atacante).setPuntosAtaque(0);
            }
            double vida = personajes.get(defensor).getPuntosVida();

            if (personajes.get(defensor).getArmaspj().get(consultadef) instanceof Defensa def) {

                double daño = personajes.get(atacante).getPuntosAtaque()
                        - (personajes.get(atacante).getPuntosAtaque() * def.PorcentajeVida);
                personajes.get(defensor).setPuntosVida(vida - daño);

            } else {
                personajes.get(defensor).setPuntosVida(vida - personajes.get(atacante).getPuntosAtaque());
            }

            contadorRondas++;

            resetStats(personajes, jug1, jug2);

        } while (!(personajes.get(jug1).getPuntosVida() < 0 || personajes.get(jug2).getPuntosVida() < 0));
        resetVida(personajes, jug1, jug2);
    }

    public static int suvirStats(personaje pj, int roll) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escoge un arma:");
        String Arma = sn.next();
        int consulta = -1;
        boolean comp = true;
        if (roll % 2 == 0) {
            for (int i = 0; i < pj.getArmaspj().size(); i++) {
                if (Arma.equalsIgnoreCase("Espada")) {
                    if (pj.getArmaspj().get(i) instanceof Espada esp) {
                        System.out.println("Espada equipada");
                        esp.equiparPersonaje(pj);
                        consulta = 1;
                        comp = false;
                    }
                } else if (Arma.equalsIgnoreCase("Arco")) {
                    if (pj.getArmaspj().get(i) instanceof Arco arc) {
                        System.out.println("Arco equipado!");
                        arc.equiparPersonaje(pj);
                        consulta = 2;
                        comp = false;
                    }
                }
            }
            System.out.println("P.Ata= " + pj.getPuntosAtaque());
        } else {
            for (int i = 0; i < pj.getArmaspj().size(); i++) {
                if (pj.getArmaspj().get(i) instanceof Armadura arm) {
                    System.out.println("Armadura equipada");
                    arm.equiparPersonaje(pj);
                    consulta = 3;
                    comp = false;

                } else if (pj.getArmaspj().get(i) instanceof Escudo esc) {
                    System.out.println("Escudo equipado");
                    esc.equiparPersonaje(pj);
                    consulta = 4;
                    comp = false;
                }
            }
        }
        if (comp) {
            System.out.println("No se encontro defensa vas en faldita");
        }
        return consulta;
    }

    public static void resetStats(ArrayList<personaje> personajes, int jug1, int jug2) {
        int contador = 0;
        int reset;
        for (int i = 0; i < 2; i++) {
            if (contador % 2 == 0) {
                reset = jug1;
            } else {
                reset = jug2;
            }
            personajes.get(reset).setPuntosAtaque(10);
            personajes.get(reset).setAtaqueArquero(false);
            personajes.get(reset).setProteccionCuerpoACuerpo(false);
            personajes.get(reset).setAtaqueArquero(false);
            personajes.get(reset).setAtaqueCuerpoACuerpo(false);
        }

    }

    public static void resetVida(ArrayList<personaje> personajes, int jug1, int jug2) {
        int contador = 0;
        int reset;
        for (int i = 0; i < 2; i++) {
            if (contador % 2 == 0) {
                reset = jug1;
                contador++;
            } else {
                reset = jug2;
            }
            personajes.get(reset).setPuntosVida(1000);

        }

    }

    public static void verArmasVida(ArrayList<personaje> personajes, int jugador, int roll) {
        System.out.println(personajes.get(jugador).getNombre());
        System.out.println("Vida: " + personajes.get(jugador).getPuntosVida()+" - "+personajes.get(jugador).getNombre());
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
