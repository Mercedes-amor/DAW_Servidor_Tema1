/*
 * TEMA 1: Ejercicio 1.4 (Opcional)
 */
package magt01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Mercedes Amor
 */
public class HabDoble extends Habitacion {

    private double price;

    public HabDoble(int numHab) {
        super(numHab);
        this.price = 100;
    }

    public double checkOut() {

        if (!isChecked()) {
            System.out.println("La habitación está libre, no se puede hacer el checkOut");
            return 0;
        } else {
            //Tomamos los segundos como días para el ejercicio
            long diasEstancia = ChronoUnit.SECONDS.between(getFechaCheckIn(), LocalDateTime.now());

            LocalDate fechaSalida = LocalDate.now();

            double facturacion;

            //Tenemos que convertir el mes a tipo entero con getValue para hacer la comparación
            //abril=4, julio=7, agosto=8.
            int mesSalida = fechaSalida.getMonth().getValue();

            if (mesSalida == 4 || mesSalida == 7 || mesSalida == 8) {
                System.out.println("Se aplica un incremento del 20%");

                facturacion = diasEstancia * price * 1.20;
            } else {

                facturacion = diasEstancia * price;
            }

            //Y cambiamos el estado de la habitación a no ocupado
            setIsChecked(false);

            return facturacion;
        }
    }

    //Reinscribimos el método toString()
    @Override
    public String toString() {

        String estado = "Libre";

        if (isChecked()) {
            estado = "Ocupado";
        }
        return "Habitación " + getNumHab() + " - tipo: doble" + " - Estado: " + estado;
    }

}
