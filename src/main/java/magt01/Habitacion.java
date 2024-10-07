/*
 * TEMA 1: Ejercicio 1.4 (Opcional)
 */
package magt01;

import java.time.LocalDateTime;

/**
 *
 * @author Mercedes Amor
 */
public abstract class Habitacion {

    private int numHab;
    private boolean isChecked;
    private LocalDateTime fechaCheckIn;

    //Constructor
    public Habitacion(int numHab) {
        this.numHab = numHab;
        this.isChecked = false;
    }

    //Métodos
    public void checkIn() {
        if (isChecked) {
            System.out.println("La habitación número " + numHab + " ya está ocupada");
        } else {
            isChecked = true;
            fechaCheckIn = LocalDateTime.now();
        }
    }

    public abstract double checkOut();

    //Reinscribimos el método toString()
    @Override
    public String toString() {

        String estado = "Libre";
        
        if (isChecked) {
            estado = "Ocupado";
        }
        return "Habitación " + getNumHab() + " - Estado: " + estado;
    }

    //Getters y Setters
    public int getNumHab() {
        return numHab;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public LocalDateTime getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public void setIsChecked(boolean ocupado) {
        this.isChecked = ocupado;
    }

    public void setFechaCheckIn(LocalDateTime fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

}

