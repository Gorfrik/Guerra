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
        System.out.println("5).Crear pocion");
        System.out.println("6).Suvir nivel a una pocion");
        System.out.println("7).Salir");

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
        personajes.get(0).EquiparPocion(new Pocion("Curacion", 1));
        personajes.get(0).EquiparPocion(new Pocion("PotenciaAtak", 5));
        personajes.get(0).EquiparPocion(new Pocion("BajaAtak", 5));

        personajes.get(1).añadirArm(new Espada());
        personajes.get(1).añadirArm(new Arco());
        personajes.get(1).añadirArm(new Escudo());
        personajes.get(1).añadirArm(new Armadura());
        personajes.get(1).EquiparPocion(new Pocion("Curacion", 5));
        personajes.get(1).EquiparPocion(new Pocion("PotenciaAtak", 5));
        personajes.get(1).EquiparPocion(new Pocion("BajaAtak", 5));

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
                    System.out.println("Que personaje va a crear la pocion?");
                    buscar = buscarpj(personajes);
                    if (buscar != -1) {
                        System.out.println("Que Tipo de pocion es? \n1.Curacion\n2.Ataque\n3.BajaAtaque");
                        String tipo = sn.next();
                        System.out.println("Que cantidad de pociones vas a crear");
                        int cant = sn.nextInt();
                        if (tipo.equalsIgnoreCase("curacion") || tipo.equalsIgnoreCase("ataque") || tipo.equalsIgnoreCase("bajaataque")) {

                            Pocion poc = new Pocion(tipo, cant);
                            personajes.get(buscar).EquiparPocion(poc);
                        } else {
                            System.out.println("No se reconoce la pocion");
                        }
                    } else {
                        System.out.println("No se encontro personaje");
                    }
                    break;
                case 6:
                    buscar = buscarpj(personajes);
                    if (buscar != -1) {
                        verPociones(personajes.get(buscar));
                        //personajes.get(buscar).getPociones().
                    } else {
                        System.out.println("No se encontro personaje");
                    }
                    break;
                case 7:

                    break;
            }
        } while (caso != 7);
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
        double nivelPocion;
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
            int usaPocion = verPocion(personajes.get(atacante));

            //Uso de pociones
            if (usaPocion != -1) {

                nivelPocion = personajes.get(atacante).getPociones().get(usaPocion - 1).getNivel();
                nivelPocion = nivelPocion * 0.05;

                if (personajes.get(atacante).getPociones().get(usaPocion - 1).getTipo().equalsIgnoreCase("Curacion")) {
                    //curacion
                    if (personajes.get(atacante).getPociones().get(usaPocion - 1).getCantHechizos() > 0) {
                        System.out.println("antes - " + personajes.get(atacante).getPuntosVida());
                        double vidaAtak = personajes.get(atacante).getPuntosVida() + (personajes.get(atacante).getPuntosVida() * nivelPocion);
                        personajes.get(atacante).setPuntosVida(vidaAtak);
                        System.out.println("Ahora tu vida es de: " + personajes.get(atacante).getPuntosVida());
                    } else {
                        System.out.println("No te quedan pociones");
                    }
                }
                if (personajes.get(atacante).getPociones().get(usaPocion - 1).getTipo().equalsIgnoreCase("PotenciaAtak")) {
                    //PotenciaAtak
                    if (personajes.get(atacante).getPociones().get(usaPocion - 1).getCantHechizos() > 0) {
                        System.out.println("antes - " + personajes.get(atacante).getPuntosAtaque());
                        double atk = personajes.get(atacante).getPuntosAtaque() + personajes.get(atacante).getPuntosAtaque() * nivelPocion;
                        personajes.get(atacante).setPuntosAtaque(atk);
                        System.out.println("Ahora tu ataque es de: " + personajes.get(atacante).getPuntosAtaque());
                    } else {
                        System.out.println("No te quedan pociones");
                    }
                }
                if (personajes.get(atacante).getPociones().get(usaPocion - 1).getTipo().equalsIgnoreCase("BajaAtak")) {
                    //BajaAtak del contrincante
                    if (personajes.get(atacante).getPociones().get(usaPocion - 1).getCantHechizos() > 0) {
                        System.out.println("antes - " + personajes.get(defensor).getPuntosAtaque());
                        double atk = personajes.get(defensor).getPuntosAtaque() - personajes.get(atacante).getPuntosAtaque() * nivelPocion;
                        personajes.get(defensor).setPuntosAtaque(atk);
                        System.out.println("Ahora el ataque del defensor es de: " + personajes.get(defensor).getPuntosAtaque());
                    } else {
                        System.out.println("No te quedan pociones");
                    }
                }

                int cantidad = personajes.get(atacante).getPociones().get(usaPocion - 1).getCantHechizos();
                personajes.get(atacante).getPociones().get(usaPocion - 1).setCantHechizos(cantidad - 1);

            } else {
                System.out.println("No usas ninguna pocion");
            }

//Defensor
            verArmasVida(personajes, defensor, 1);
            int consultadef = suvirStats(personajes.get(defensor), 1);

//Comienzo combate
            if (consultaAta == -1) {
                personajes.get(atacante).setPuntosAtaque(0);
            }
            double vida = personajes.get(defensor).getPuntosVida();
            if (consultadef != -1) {
                if (personajes.get(defensor).getArmaspj().get(consultadef) instanceof Defensa def) {

                    double daño = personajes.get(atacante).getPuntosAtaque()
                            - (personajes.get(atacante).getPuntosAtaque() * def.PorcentajeVida);

//resistencias
                    int res = valorarResistencias(personajes.get(atacante), personajes.get(defensor));
                    daño = daño / res;
                    personajes.get(defensor).setPuntosVida(vida - daño);

                }
            } else {
                personajes.get(defensor).setPuntosVida(vida - personajes.get(atacante).getPuntosAtaque());
            }

            contadorRondas++;

            resetStats(personajes, jug1, jug2);

        } while (!(personajes.get(jug1).getPuntosVida() < 0 || personajes.get(jug2).getPuntosVida() < 0));
        System.out.println("Vida: " + personajes.get(jug1).getPuntosVida() + " - " + personajes.get(jug1).getNombre());
        System.out.println("Vida: " + personajes.get(jug2).getPuntosVida() + " - " + personajes.get(jug2).getNombre());
        if (personajes.get(jug1).getPuntosVida() > personajes.get(jug2).getPuntosVida()) {
            System.out.println("El ganador es " + personajes.get(jug1).getNombre());
        } else {
            System.out.println("El ganador es " + personajes.get(jug2).getNombre());
        }

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
                        consulta = 0;
                        comp = false;
                    }
                } else if (Arma.equalsIgnoreCase("Arco")) {
                    if (pj.getArmaspj().get(i) instanceof Arco arc) {
                        System.out.println("Arco equipado!");
                        arc.equiparPersonaje(pj);
                        consulta = 1;
                        comp = false;
                    }
                }
            }
            System.out.println("P.Ata= " + pj.getPuntosAtaque());
        } else {
            for (int i = 0; i < pj.getArmaspj().size(); i++) {
                if (Arma.equalsIgnoreCase("Armadura")) {
                    if (pj.getArmaspj().get(i) instanceof Armadura arm) {
                        System.out.println("Armadura equipada");
                        arm.equiparPersonaje(pj);
                        consulta = 2;
                        comp = false;
                    }
                } else if (Arma.equalsIgnoreCase("Escudo")) {
                    if (pj.getArmaspj().get(i) instanceof Escudo esc) {
                        System.out.println("Escudo equipado");
                        esc.equiparPersonaje(pj);
                        consulta = 3;
                        comp = false;

                    }
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

    public static int valorarResistencias(personaje pj1, personaje pj2) {

        if (pj1.isAtaqueArquero() && pj2.isProteccionArquero()) {
            System.out.println("Tengo resistencia a arquero");
            return 2;

        }
        if (pj1.isAtaqueCuerpoACuerpo() && pj2.isProteccionCuerpoACuerpo()) {
            System.out.println("Tengo resistencia a cuerpo a cuerpo");
            return 2;
        }
        System.out.println("No tienes resitencia al ataque");
        return 1;
    }

    public static void verArmasVida(ArrayList<personaje> personajes, int jugador, int roll) {

        System.out.println("\n------==== " + personajes.get(jugador).getNombre() + " ====------");
        System.out.println("Vida: " + personajes.get(jugador).getPuntosVida() + " - " + personajes.get(jugador).getNombre());

        System.out.println("\nArmas/Defensa:");

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

    public static int verPocion(personaje pj) {
        Scanner sn = new Scanner(System.in);
        verPociones(pj);
        if (pj.getPociones().size() != 0) {
            System.out.println("\tQue pocion deseas utilizar [1-3]");
            int usaPocion = sn.nextInt();
            return usaPocion;

        } else {
            System.out.println("No tienes pociones");
        }
        return -1;
    }

    public static void verPociones(personaje pj) {
        for (int i = 0; i < pj.getPociones().size(); i++) {

            System.out.println("\n\t" + (i + 1) + ". " + pj.getPociones().get(i).getTipo());
            System.out.println("\tCantidad de pociones: " + pj.getPociones().get(i).getCantHechizos());
            System.out.println("\tNivel de pocion: "+pj.getPociones().get(i).getNivel()+"\n");
        }
    }
}
