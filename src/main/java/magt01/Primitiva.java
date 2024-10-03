/*
 * Ejercicio 1.6:
 */
package magt01;



import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Mercedes Amor
 */

//Utilicé  la interfaz Set que desconocía, muy práctico para estos casos al no adminitr duplicados
//tenía dudas al no tener posiciones definidas pero vi que con TreeSet se solucionaba para este caso.


public class Primitiva {
    private Set<Integer> numerosPremiados = new TreeSet<>(); // TreeSet para mantener los números ordenados de forma ascendente

    // Constructor para generar los 6 números premiados aleatoriamente entre 1 y 49
    public Primitiva() {
        Random random = new Random();
        while (this.numerosPremiados.size() < 6) {
            this.numerosPremiados.add(random.nextInt(49) + 1); // Genera números entre 1 y 49, de ahí el +1
        }
    }

    //MÉTODOS 
    
    // Método para comprobar cuántos números acertó el jugador
        public int comprobarAciertos(Set<Integer> combinacionJugada) {
        int aciertos = 0; //iniciamos el contador a 0
        for (Integer numero : combinacionJugada) {
            if (this.numerosPremiados.contains(numero)) { // Comprobamos si el número está en los premiados
                aciertos++;
            }
        }
        return aciertos; // Retornamos el número de aciertos
    }

     //GETTERS (no hay setters ya que son números randoms)
        
    // Método para obtener los números premiados
    public Set<Integer> getNumerosPremiados() {
        return numerosPremiados;
    }
        
}

    

    
    
    
    

