/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

/**
 *
 * @author usuario
 */
public class Escudo extends Defensa {

    public Escudo() {
        this.PorcentajeVida = 0.1f;
    }

    @Override
    void ActivarProteccion(personaje pj) {
        pj.setProteccionArquero(true);
    }

    @Override
    public void equiparPersonaje(personaje pj) {

        ActivarProteccion(pj);
    }

}
