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
    private int PuntosVida;
    private double PuntosAtaque;
    private boolean proteccionArquero;
    private boolean proteccionCuerpoACuerpo;
    private boolean ataqueArquero;
    private boolean ataqueCuerpoACuerpo;
    private ArrayList<Arma> Armaspj = new ArrayList();

    public personaje(String nombre) {
        this.nombre = nombre;
        this.PuntosVida = 100;
        this.PuntosAtaque = 5;
        this.ataqueArquero = false;
        this.ataqueArquero = false;
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
                    if(Armaspj.get(i) instanceof Arco ar)
                        ar.ActivarAtaque(this);
                        ar.equiparPersonaje(this);
                        
                    break;
                case "espada":
                    if(Armaspj.get(i) instanceof Espada es)
                        es.equiparPersonaje(this);
                    break;
                case "escudo":
                    
                    break;
                case "armadura":
                    
                    break;
            }
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

    public int getPuntosVida() {
        return PuntosVida;
    }

    public void setPuntosVida(int PuntosVida) {
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
