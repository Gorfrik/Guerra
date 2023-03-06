/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class personaje{
    private String nombre;
    private int PuntosVida;
    private double PuntosAtaque;
    private boolean proteccionArquero;
    private boolean proteccionCuerpoACuerpo;
    private boolean ataqueArquero;
    private boolean ataqueCuerpoACuerpo;
    private ArrayList<Arma> Armaspj=new ArrayList();

    

    public personaje(String nombre) {
        this.nombre = nombre;
        this.PuntosVida=100;
        this.PuntosAtaque=5;
        this.ataqueArquero=false;
        this.ataqueArquero=false;
        this.proteccionArquero=false;
        this.proteccionCuerpoACuerpo=false;
    }
            
    public void equipar (){
        equiparPersonaje(this);
    }

    public ArrayList<Arma> getArmaspj() {
        return Armaspj;
    }

    public void setArmaspj(ArrayList<Arma> Armaspj) {
        this.Armaspj = Armaspj;
    }
 
}
