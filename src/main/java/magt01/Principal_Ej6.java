/*
 * Ejercicio 1.6: Números primitiva
 */

package magt01;

//import java.util.HashSet; (preferí usar TreeSet)
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Mercedes Amor Gallart
 */

public class Principal_Ej6 {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Primitiva primitiva = new Primitiva(); //Creamos una clase Primitiva con una combinación ganadora.

        //Creación del boleto para jugar
        System.out.println("Introduce la combinación de tu boleto (6 números entre 1 y 49, sin repetir):");
        Set<Integer> boleto = new TreeSet<>();
        
        while (boleto.size() < 6) {
            try {
                System.out.print("Introduce un número: ");
                int numero = Integer.parseInt(scanner.nextLine());

                // Verificamos si el número está entre 1 y 49 y si no está repetido
                if (numero < 1 || numero > 49) {
                    System.out.println("Número fuera de rango, debe estar entre 1 y 49.");
                } else if (!boleto.add(numero)) {
                    System.out.println("Número repetido, introduce otro.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor no numérico. Introduce un número válido.");
            }
        }

        // Mostramos los números premiados
        System.out.println("Números premiados: " + primitiva.getNumerosPremiados());

        // Comprobamos los aciertos del usuario
        int aciertos = primitiva.comprobarAciertos(boleto);
        System.out.println("Has acertado " + aciertos + " números.");
    }
}

    