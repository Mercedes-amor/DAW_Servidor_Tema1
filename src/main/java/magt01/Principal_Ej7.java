/*
Ejercicio 1.7: Contador de letras en un String

 */
package magt01;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Mercedes Amor
 */
public class Principal_Ej7 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Solicitar al usuario que introduzca un string
        System.out.print("Introduce un texto: ");
        String texto = teclado.nextLine().toLowerCase(); // Convertimos a minúsculas para ignorar distinción entre mayúsculas/minúsculas

        // Usamos TreeMap para mantener las letras ordenadas alfabéticamente
        Map<Character, Ocurrencia> contadorLetras = new TreeMap<>();

        // Recorrer el string una sola vez
        //Usamos .toCharArray() para covertir el String texto en un Array de caracteres
        for (char letra : texto.toCharArray()) {
            if (Character.isLetter(letra)) { // Solo consideramos letras
                // Si la letra ya está en el map, incrementamos la cantidad
                if (contadorLetras.containsKey(letra)) { //comprueba si el map ya tiene una entrada con esa letra como clave
                    Ocurrencia ocurrencia = contadorLetras.get(letra);
                    ocurrencia.setCantidad(ocurrencia.getCantidad() + 1);
                } else {
                    // Si es la primera vez que aparece la letra, la añadimos al map con cantidad 1
                    contadorLetras.put(letra, new Ocurrencia(letra, 1));
                }
            }
        }

        // Mostrar el resultado (TreeMap ya está ordenado alfabéticamente)
        System.out.println("Frecuencia de letras:");
        //contadorLetras.values() devuelve una colección que contiene todos los objetos Ocurrencia del map. 
        for (Ocurrencia ocurrencia : contadorLetras.values()) {
            System.out.println(ocurrencia.toString());
        }
    }
}