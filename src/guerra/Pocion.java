/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

/**
 *
 * @author usuario
 */
public class Pocion {

    private int nivel;
    //Curacion,PotenciaAtak,BajaAtak
    private String tipo;
    private int CantHechizos;

    public Pocion(String tipo,  int CantHechizos) {
        this.nivel = 0;
        this.tipo = tipo;
        this.CantHechizos = CantHechizos;
    }

    public void IncNivel(int nivel) {
        this.nivel += nivel;
    }

    public int getCantHechizos() {
        return CantHechizos;
    }

    public void setCantHechizos(int CantHechizos) {
        this.CantHechizos = CantHechizos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCuracion(String curacion) {
        this.tipo = curacion;
    }

   

}
