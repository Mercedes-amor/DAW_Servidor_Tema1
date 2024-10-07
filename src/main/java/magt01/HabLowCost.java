/*
 * TEMA 1: Ejercicio 1.4 (Opcional)
 */
package magt01;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Mercedes Amor
 */
public class HabLowCost extends Habitacion {

    private double price;

    public HabLowCost(int numHab) {
        super(numHab);
        this.price = 50;
    }

    //Métodos
    public double checkOut() {

        if (!isChecked()) {
            System.out.println("La habitación está libre, no se puede hacer el checkOut");
            return 0;
        } else {
            //Tomamos los segundos como días para el ejercicio
            long diasEstancia = ChronoUnit.SECONDS.between(getFechaCheckIn(), LocalDateTime.now());

            double facturacion = diasEstancia * price;

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
        return "Habitación " + getNumHab() + " - tipo: LowCost" + " - Estado: " + estado;
    }

}

