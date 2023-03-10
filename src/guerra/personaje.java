/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class personaje {

    private String nombre;
    private double PuntosVida;
    private double PuntosAtaque;
    private boolean proteccionArquero;
    private boolean proteccionCuerpoACuerpo;
    private boolean ataqueArquero;
    private boolean ataqueCuerpoACuerpo;
    private ArrayList<Arma> Armaspj = new ArrayList();

    public personaje(String nombre) {
        this.nombre = nombre;
        this.PuntosVida = 1000;
        this.PuntosAtaque = 50;
        this.ataqueArquero = false;
        this.ataqueCuerpoACuerpo = false;
        this.proteccionArquero = false;
        this.proteccionCuerpoACuerpo = false;
    }

    public void equipar() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Que arma quieres equipar?");
        String resp = sn.next();
        for (int i = 0; i < Armaspj.size(); i++) {

            switch (resp) {
                case "arco":
                    if (Armaspj.get(i) instanceof Arco ar) {
                        ar.equiparPersonaje(this);
                    }
                    break;
                case "espada":
                    if (Armaspj.get(i) instanceof Espada es) {
                        es.equiparPersonaje(this);
                    }
                    break;
                case "escudo":
                         if(Armaspj.get(i) instanceof Escudo esc)
                        esc.equiparPersonaje(this);
                    break;
                case "armadura":
                         if(Armaspj.get(i) instanceof Armadura ar)
                        ar.equiparPersonaje(this);
                    break;
            }
        }
    }

    public void añadirArm(Arma arm) {
        Armaspj.add(arm);
    }

    public void quitarArm(String armaTirar) {
        boolean noEncontrado = true;
        for (int i = 0; i < Armaspj.size(); i++) {
            if (armaTirar.equalsIgnoreCase("arco")) {
                if (Armaspj.get(i) instanceof Arco) {
                    Armaspj.remove(i);
                    noEncontrado=false;
                    break;
                }
            } else if (armaTirar.equalsIgnoreCase("espada")) {
                if (Armaspj.get(i) instanceof Espada) {
                    Armaspj.remove(i);
                    noEncontrado=false;
                    break;
                }
            } else if (armaTirar.equalsIgnoreCase("armadura")) {
                if (Armaspj.get(i) instanceof Armadura) {
                    Armaspj.remove(i);
                    noEncontrado=false;
                    break;
                }
            } else if (armaTirar.equalsIgnoreCase("escudo")) {
                if (Armaspj.get(i) instanceof Escudo) {
                    Armaspj.remove(i);
                    noEncontrado=false;
                    break;
                }
            }
        }
        if (noEncontrado) {
            System.out.println("No se encontro arma");
        }
    }

    public ArrayList<Arma> getArmaspj() {
        return Armaspj;
    }

    public void setArmaspj(Arma Arm) {
        Armaspj.add(Arm);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPuntosVida() {
        return PuntosVida;
    }

    public void setPuntosVida(double PuntosVida) {
        this.PuntosVida = PuntosVida;
    }

    public double getPuntosAtaque() {
        return PuntosAtaque;
    }

    public void setPuntosAtaque(double PuntosAtaque) {
        this.PuntosAtaque = PuntosAtaque;
    }

    public boolean isProteccionArquero() {
        return proteccionArquero;
    }

    public void setProteccionArquero(boolean proteccionArquero) {
        this.proteccionArquero = proteccionArquero;
    }

    public boolean isProteccionCuerpoACuerpo() {
        return proteccionCuerpoACuerpo;
    }

    public void setProteccionCuerpoACuerpo(boolean proteccionCuerpoACuerpo) {
        this.proteccionCuerpoACuerpo = proteccionCuerpoACuerpo;
    }

    public boolean isAtaqueArquero() {
        return ataqueArquero;
    }

    public void setAtaqueArquero(boolean ataqueArquero) {
        this.ataqueArquero = ataqueArquero;
    }

    public boolean isAtaqueCuerpoACuerpo() {
        return ataqueCuerpoACuerpo;
    }

    public void setAtaqueCuerpoACuerpo(boolean ataqueCuerpoACuerpo) {
        this.ataqueCuerpoACuerpo = ataqueCuerpoACuerpo;
    }

}
