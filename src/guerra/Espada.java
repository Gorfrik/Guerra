/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

/**
 *
 * @author usuario
 */
public class Espada extends Ataque{
    

    public Espada() {
        this.PorcentajeAtq=0.4f;
    }

    
    @Override
    void ActivarAtaque(personaje pj) {
        pj.setAtaqueCuerpoACuerpo(true);
    }

    @Override
    public void equiparPersonaje(personaje pj) {
        float nuevoAt = (float) pj.getPuntosAtaque() + ((float) pj.getPuntosAtaque() * this.PorcentajeAtq);
        pj.setPuntosAtaque(nuevoAt);
        ActivarAtaque(pj);
    }
}
