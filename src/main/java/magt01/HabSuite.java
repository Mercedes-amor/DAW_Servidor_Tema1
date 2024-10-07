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
public class HabSuite extends Habitacion {

    private double price;

    public HabSuite(int numHab) {
        super(numHab);
        this.price = 200;
    }

    public double checkOut() {
        if (!isChecked()) {
            System.out.println("La habitación está libre, no se puede hacer el checkOut");
            return 0;
        } else {

            //Tomamos los segundos como días para el ejercicio
            long diasEstancia = ChronoUnit.SECONDS.between(getFechaCheckIn(), LocalDateTime.now());
            double facturacion;

            //Tenemos que convertir el mes a tipo entero con getValue para hacer la comparación
            if (diasEstancia >= 10) {
                System.out.println("Se aplica un descuento del 20% por estancia de 10 o más días");

                facturacion = diasEstancia * price * 0.80;
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
        return "Habitación " + getNumHab() + " - tipo: Suite" + " - Estado: " + estado;
    }
}

