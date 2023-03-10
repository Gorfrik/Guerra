/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerra;

/**
 *
 * @author usuario
 */
public class Armadura extends Defensa{

    public Armadura() {
        this.PorcentajeVida=0.5f;
    }
    
    @Override
    void ActivarProteccion(personaje pj) {
        pj.setProteccionCuerpoACuerpo(true);
    }

    @Override
    public void equiparPersonaje(personaje pj) {
       

        ActivarProteccion(pj);
    }
    
}
