/*
 * TEMA 1: Ejercicio 1.5 (Opcional)
 */
package magt01;


/**
 *
 * @author Mercedes Amor
 */

public class Radio extends Dispositivo {

   
    private double dial;

    public Radio() {
        this.dial = 88.0;
    }

   

    //Métodos
    public boolean subir() {
        if (dial >= 104.0) {
            System.out.println("La Radio ya se encuentra en la frecuencia máxima, 104.0");
            return false;
        } else {
            dial += 0.1;
            System.out.println("dial subido");
        }
        return true;
    }

    public boolean bajar() {
        if (dial <= 88.0) {
            System.out.println("La Radio ya se encuentra en la frecuencia mínima, 88.0");
            return false;
        } else {
            dial -= 0.1;
            System.out.println("dial bajado");
        }
        return true;
    }

    public void reset() {
        dial = 88.0;
        System.out.println("dispositivo reseteado");
    }

    public String verEstado() {
        String estado = "La Radio está en la frecuencia " + dial; 
        
        return estado;
    }
     
   
    //Getters y Setters

    public double getDial() {
        return dial;
    }

    public void setDial(double dial) {
        this.dial = dial;
    }

    @Override
    public String toString() {
        return "Radio: " + "dial " + dial;
    }

    

}

