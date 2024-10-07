/*
 * TEMA 1: Ejercicio 1.5 (Opcional)
 */
package magt01;

/**
 *
 * @author Mercedes Amor
 */
public class Ascensor extends Dispositivo {

    private int planta;

    public Ascensor() {
        this.planta = 0;
    }

    //Métodos
    public boolean subir() {
        if (planta >= 8) {
            System.out.println("El ascensor ya se encuentra en la última planta, no puede subir más");
            return false;
        } else {
            planta += 1;
            System.out.println("planta subida");
        }
        return true;
    }

    public boolean bajar() {
        if (planta <= 0) {
            System.out.println("El ascensor ya se encuentra en la planta 0, no puede bajar más");
            return false;
        } else {
            planta -= 1;
            System.out.println("planta bajada");
        }
        return true;
    }

    public void reset() {
        planta = 0;
        System.out.println("dispositivo reseteado");

    }

    public String verEstado() {
        String estado = "El ascensor se encuentra en la planta " + planta;

        return estado;
    }

    //Getters y Setters
    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    @Override
    public String toString() {
        return "Ascensor: " + "planta " + planta;
    }

}
