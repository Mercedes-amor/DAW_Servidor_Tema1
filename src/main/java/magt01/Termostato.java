/*
 * TEMA 1: Ejercicio 1.5 (Opcional)
 */
package magt01;

import java.time.LocalDate;

/**
 *
 * @author Mercedes Amor
 */
public class Termostato extends Dispositivo {

    private LocalDate fechaRevision;
    private int temp;

    public Termostato() {
        this.temp = 20;
    }

    //Métodos
    public boolean subir() {
        if (temp >= 80) {
            System.out.println("Valor máximo 80º alcanzados, no se puede subir más la temperatura");
            return false;
        } else {
            temp += 1;
            System.out.println("temperatura subida");
        }
        return true;
    }

    public boolean bajar() {
        if (temp <= 15) {
            System.out.println("Valor mínimo 15º alcanzados, no se puede bajar más la temperatura");
            return false;
        } else {
            temp -= 1;
            System.out.println("temperatura bajada");
        }
        return true;
    }

    public void reset() {
        temp = 20;
        System.out.println("dispositivo reseteado");

    }

    public String verEstado() {
        String estado = "El termostato está a temperatura " + temp
                + "º Centígrados y todavía no ha tenido ninguna revisión";

        if (fechaRevision != null) {
            estado = "El termostato está a temperatura " + temp
                    + "º Centígrados y la fecha de la última revisión es el " + fechaRevision;
        }

        return estado;
    }

    //Método revisar exclusivo de termostato
    public void revisar() {
        System.out.println("La fecha de revisión se ha actualizado");
        fechaRevision = LocalDate.now();
    }

    //Getters y Setters
    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public int getTemp() {
        return temp;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Termostato:" + " temp " + temp + "ºC";
    }

}
