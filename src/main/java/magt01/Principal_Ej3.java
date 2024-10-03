/*
 * TEMA 1: Ejercicio 1.3
 */
package magt01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mercedes Amor Gallart
 */
public class Principal_Ej3 {

    public static void main(String[] args) {

        ArrayList<Persona> arrayPersonas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        arrayPersonas.add(new Persona("11111111L", "Indiana Jones", 32));
        arrayPersonas.add(new Persona("22222222Ñ", "Henri Jones", 65));
        arrayPersonas.add(new Persona("33333333F", "Marcus", 57));
        arrayPersonas.add(new Persona("44444444L", "Henri Jones 3º", 17));
        arrayPersonas.add(new Persona("55555555L", "Sofía Hapgood", 28));

        /*Método para añadir personas que comentamos
                       
		do {
			System.out.println("introduzca el dni");
			String dni = teclado.nextLine();
			System.out.println("introduzca el nombre");
			String name = teclado.nextLine();
			System.out.println("introduzca la edad");
			int edad = Integer.parseInt(teclado.nextLine());
			Persona persona = new Persona(dni, name, edad);

			arrayPersonas.add(persona);

		} while (arrayPersonas.size() <= 5);
         */
        System.out.println("Las personas del arrayList son:");
        System.out.println(arrayPersonas.toString());
        System.out.println("");

        System.out.println("La edad del mayor es de " + obtenerEdadMayor(arrayPersonas) + " años");
        System.out.println("");
        
        System.out.println("La media de edad es de " + obtenermediaEdad(arrayPersonas) + " años");
        System.out.println("");
        
        System.out.println("El nombre del mayor es  " + obtenerNombreMayor(arrayPersonas));
        System.out.println("");
        
        System.out.println("La persona mayor es: " + obtenerPersonaMayor(arrayPersonas).toString());
        System.out.println("");
        
        System.out.println("Las personas mayores de edad son: ");
        for (Persona p : obtenerMayoresDeEdad(arrayPersonas)) {
            System.out.println(p);
        }
        System.out.println("");
        
        System.out.println("Las personas mayores de la edad media: ");
        for (Persona p : obtenerMayoresMedia(arrayPersonas)) {
            System.out.println(p);
        }
    }

    /*MÉTODOS*/
 /*Método para devolver la edad del mayor*/
    public static int obtenerEdadMayor(ArrayList<Persona> personas) {
        int edadMayor = personas.get(0).getEdad(); // El contador inicia con la edad de la primera persona

        for (int i = 1; i < personas.size(); i++) { // Comienza el bucle desde la segunda persona
            if (personas.get(i).getEdad() > edadMayor) {
                edadMayor = personas.get(i).getEdad(); // Actualiza el contador si encuentra una edad mayor
            }
        }

        return edadMayor;
    }

    /*Método para devolver la media de edad*/
    public static int obtenermediaEdad(ArrayList<Persona> personas) {
        int sumaEdad = 0; //inicimos a 0

        for (int i = 0; i < personas.size(); i++) {
            sumaEdad += personas.get(i).getEdad(); // vamos sumando las edades         
        }
        int media = sumaEdad / 5;

        return media;
    }

    /*Método para devolver el nombre del mayor*/
    //Pendiente añadir condicional para el caso de 2 personas con la misma edadMayor
    public static String obtenerNombreMayor(ArrayList<Persona> personas) {
        int edadMayor = obtenerEdadMayor(personas);
        String nombreMayor = "";

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getEdad() == edadMayor) {
                nombreMayor = personas.get(i).getNombre();
            }
        }
        return nombreMayor;
    }

    /*Método para devolver la persona mayor*/
    //Pendiente añadir condicional para el caso de 2 personas con la misma edadMayor
    public static Persona obtenerPersonaMayor(ArrayList<Persona> personas) {
        int edadMayor = obtenerEdadMayor(personas);
        Persona personaMayor = null; // Inicializamos la persona mayor a null

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getEdad() == edadMayor) {
                personaMayor = personas.get(i); // Actualizamos la persona mayor si coincide con la edad mayor
            }
        }

        return personaMayor;
    }

    /* Método para devolver todas las personas mayores de edad */
    public static ArrayList<Persona> obtenerMayoresDeEdad(ArrayList<Persona> personas) {
        ArrayList<Persona> mayoresDeEdad = new ArrayList<>(); // Array para almacenar los mayores de edad

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getEdad() >= 18) {
                mayoresDeEdad.add(personas.get(i)); // Agregamos a la lista si es mayor de edad
            }
        }

        return mayoresDeEdad;
    }

    /* Método para devolver todas las personas mayores de la media */
    public static ArrayList<Persona> obtenerMayoresMedia(ArrayList<Persona> personas) {
        ArrayList<Persona> mayoresMedia = new ArrayList<>(); // Array para almacenar los mayores de la edad media
        int edadMedia = obtenermediaEdad(personas);

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getEdad() >= edadMedia) {
                mayoresMedia.add(personas.get(i)); // Agregamos a la lista si es mayor de edad media
            }
        }

        return mayoresMedia;
    }

}
