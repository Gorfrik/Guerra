/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

/**
 *
 * @author usuario
 */
abstract class Ataque implements Arma{
    
     abstract void ActivarAtaque(personaje pj);
     
     public void equiparPersonaje(personaje pj) {
        
        float nuevoAt = (float) pj.getPuntosAtaque() + ((float) pj.getPuntosAtaque() * this.porcentajeAtq);
        pj.setPuntosAtaque(nuevoAt);

    }
}
