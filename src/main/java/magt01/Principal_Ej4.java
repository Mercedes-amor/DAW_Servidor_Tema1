/*
 * TEMA 1: Ejercicio 1.4 (Opcional)

Cuestión 1: ¿Habitación debería ser una clase abstracta o una interfaz? ¿Por qué?
    Hago la clase Habitacion como abstracta ya que los atributos numHab, checked y fechaCheckIn 
  son comunes, luego en cada subclase implemento el método checkOut() con los diferentes precios
  y descuentos para cada tipo de habitación.

Cuestión 2: ¿Es útil que el método toString () en la clase Habitación?
    Sobreescribo aquí el método toString() para que muestre el numero de habitacion y el estado, 
   que es lo que me interesa... podría poner también la fecha del checkIn.
*/
package magt01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mercedes Amor Gallart
 */
public class Principal_Ej4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creamos una instancia de la clase Hotel
        Hotel hotel = new Hotel();

        //Creamos un arrayList de habitaciones
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        //Añadimos las habitaciones al arrayList y luego este a la instancia de Hotel
        habitaciones.add(new HabLowCost(123));
        habitaciones.add(new HabLowCost(124));
        habitaciones.add(new HabLowCost(125));

        habitaciones.add(new HabDoble(230));
        habitaciones.add(new HabDoble(231));
        habitaciones.add(new HabDoble(232));
        habitaciones.add(new HabDoble(233));
        habitaciones.add(new HabDoble(234));
        habitaciones.add(new HabDoble(235));
        habitaciones.add(new HabDoble(236));
        habitaciones.add(new HabDoble(237));
        habitaciones.add(new HabDoble(238));
        habitaciones.add(new HabDoble(239));

        habitaciones.add(new HabSuite(371));
        habitaciones.add(new HabSuite(372));
        habitaciones.add(new HabSuite(373));
        habitaciones.add(new HabSuite(374));
        habitaciones.add(new HabSuite(375));
        
        
        //Añadimos el ArrayList de habitaciciones a la instancia de Hotel     
        hotel.setListaHabitaciones(habitaciones);

        //Creamos variable facturación
        double facturacionHotel = 0;

        int opcion;

        // Menú Principal
        do {
            System.out.println("Seleccione acción:");
            System.out.println("1. Check in");
            System.out.println("2. Check out");
            System.out.println("3. Listado habitaciones");
            System.out.println("4. Salir programa");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea después de nextInt()

            switch (opcion) {
                case 1: {
                    //Check in- Mostramos habitaciones libres                    

                    if (todasHabitacionesOcupadas(habitaciones)) {
                        System.out.println("No hay habitaciones libres");
                    } else {
                        System.out.println("Habitaciones libres:");

                        for (Habitacion habitacion : habitaciones) {
                            if (!habitacion.isChecked()) {
                                System.out.println(habitacion.toString());
                            }
                        }

                        System.out.println("Introduzca el número de la habitación para el Check in");
                        int numHab = scanner.nextInt();
                        for (Habitacion habitacion : habitaciones) {
                            if (!habitacion.isChecked()) {

                                if (habitacion.getNumHab() == numHab) {

                                    habitacion.checkIn();
                                    System.out.println("Realizado el Check in de la habitación " + habitacion.getNumHab());
                                }
                            }
                        }

                    }
                    break;

                }

                case 2: {
                    //Check out - Mostramos habitaciones ocupadas

                    if (todasHabitacionesLibres(habitaciones)) {

                        System.out.println("No hay habitaciones ocupadas para el check out");

                    } else {
                        System.out.println("Habitaciones ocupadas:");

                        for (Habitacion habitacion : habitaciones) {
                            if (habitacion.isChecked()) {
                                System.out.println(habitacion.toString());
                            }
                        }

                        System.out.println("Introduzca el número de la habitación para el Check out");
                        int numHab = scanner.nextInt();

                        for (Habitacion habitacion : habitaciones) {
                            if (habitacion.isChecked()) {

                                if (habitacion.getNumHab() == numHab) {

                                    double factHab = habitacion.checkOut();

                                    System.out.println("Realizado el Check out de la habitación " + habitacion.getNumHab());
                                    System.out.println("Facturación: " + factHab);

                                    facturacionHotel += factHab;
                                    System.out.println("Facturación total Hotel: " + facturacionHotel);
                                }
                            }
                        }

                    }

                    break;

                }

                case 3: {
                    //Listado habitaciones

                    mostrarListado(habitaciones);
                    break;
                }

            }

        } while (opcion != 4);
        System.out.println("Cerrando programa ¡Hasta la vista!");

    } //Fin main

    //Métodos
    public static void mostrarListado(ArrayList habitaciones) {

        for (var habitacion : habitaciones) {
            System.out.println(habitacion.toString());
        }

    }

    public static boolean todasHabitacionesOcupadas(ArrayList<Habitacion> habitaciones) {

        for (Habitacion habitacion : habitaciones) {

            if (!habitacion.isChecked()) {
                // Si encontramos una habitación no ocupada, devolvemos false
                return false;
            }
        }
        // Si todas las habitaciones están ocupadas, devolvemos true
        return true;
    }

    public static boolean todasHabitacionesLibres(ArrayList<Habitacion> habitaciones) {

        for (Habitacion habitacion : habitaciones) {

            if (habitacion.isChecked()) {
                // Si encontramos una habitación ocupada, devolvemos false
                return false;
            }
        }
        // Si todas las habitaciones están libres, devolvemos true
        return true;
    }
}
