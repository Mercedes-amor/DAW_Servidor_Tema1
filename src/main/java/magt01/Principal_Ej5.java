/*
 * TEMA 1: Ejercicio 1.5 (Opcional)
 */
package magt01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mercedes Amor Gallart
 */
public class Principal_Ej5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creamos un arrayList con los 3 dispositivos
        ArrayList<Dispositivo> dispositivosEdificio = new ArrayList<>();

        //Añadimos los dispositivos al arrayList
        dispositivosEdificio.add(new Termostato());
        dispositivosEdificio.add(new Ascensor());
        dispositivosEdificio.add(new Radio());

        int opcion;

        // Menú Principal
        do {
            System.out.println("Operación a realizar:");
            System.out.println("0. Salir programa");
            System.out.println("1. Subir un dispositivo");
            System.out.println("2. Bajar un dispositivo");
            System.out.println("3. Resetear un dispositivo");
            System.out.println("4. Revisar Termostato");
            System.out.println("5. Estado dispositivos");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea después de nextInt()

            switch (opcion) {
                case 1: {
                    //Subir dispositivo 
                    int select;

                    System.out.println("Seleccione el dispositivo que desea subir");
                    mostrarDispositivos(dispositivosEdificio);

                    select = scanner.nextInt();
                    scanner.nextLine(); // Consume la nueva línea después de nextInt()

                    dispositivosEdificio.get(select - 1).subir();

                    break;

                }

                case 2: {
                    //Bajar dispositivo
                    int select;

                    System.out.println("Seleccione el dispositivo que desea bajar");
                    mostrarDispositivos(dispositivosEdificio);

                    select = scanner.nextInt();
                    scanner.nextLine(); // Consume la nueva línea después de nextInt()

                    dispositivosEdificio.get(select - 1).bajar();

                    break;

                }

                case 3: {
                    int select;

                    System.out.println("Seleccione el dispositivo que desea resetear");
                    mostrarDispositivos(dispositivosEdificio);

                    select = scanner.nextInt();
                    scanner.nextLine(); // Consume la nueva línea después de nextInt()

                    dispositivosEdificio.get(select - 1).reset();
                    break;
                }

                case 4: {
                    //Establecer fecha revisión termostato

                    //Como el método revisar() es propio de Termostato, debemos confirmar que
                    //el dispositivo es una instancia de Termostato.
                    for (Dispositivo dispositivo : dispositivosEdificio) {
                        if (dispositivo instanceof Termostato) {
                            Termostato termostato = (Termostato) dispositivo; //casting para acceder al método
                            termostato.revisar();
                        }
                    }

                    break;
                }
                case 5: {
                    //Estado dispositivos

                    mostrarEstadoDispositivos(dispositivosEdificio);

                    break;
                }

            }

        } while (opcion != 0);
        System.out.println("Cerrando programa ¡Hasta la vista!");

    } //Fin main

    //Métodos
    public static void mostrarDispositivos(ArrayList dispositivosEdificio) {

        int position = 0;
        for (var dispositivo : dispositivosEdificio) {
            position += 1;
            System.out.println(position + ". " + dispositivo.toString());
            
        }

    }
    
    //Aquí debemos indicar que el arrayList contiene instancias de Dispositivo para poder llamar al método verEstado()
       public static void mostrarEstadoDispositivos(ArrayList<Dispositivo> dispositivosEdificio) {

        int position = 0;
        for (var dispositivo : dispositivosEdificio) {
            position += 1;
            System.out.println(position + ". " + dispositivo.verEstado());
            
        }

    }

}
