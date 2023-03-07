/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

/**
 *
 * @author usuario
 */
public class Arco extends Ataque {

    public Arco() {
        this.PorcentajeAtq=0.15f;
    }

    @Override
    void ActivarAtaque(personaje pj) {
        pj.setAtaqueArquero(true);
    }

    @Override
    public void equiparPersonaje(personaje pj) {

        float nuevoAt = (float) pj.getPuntosAtaque() + ((float) pj.getPuntosAtaque() * this.PorcentajeAtq);
        pj.setPuntosAtaque(nuevoAt);
        ActivarAtaque(pj);

    }

}
