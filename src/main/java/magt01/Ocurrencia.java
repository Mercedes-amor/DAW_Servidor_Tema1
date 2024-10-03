/*
 * Ejercicio 1.7
 */
package magt01;

/**
 *
 * @author Mercedes Amor Gallart
 */

public class Ocurrencia {

    private Character letra;
    private Integer cantidad;

    //Constructor
    public Ocurrencia(Character letra, Integer cantidad) {
        this.letra = letra;
        this.cantidad = cantidad;
    }
    
    
    //Getters y Setters

    public Character getLetra() {
        return letra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    

@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ocurrencia other = (Ocurrencia) obj;
        if (letra == null) {
            if (other.letra != null)
                return false;
        } else if (!letra.equals(other.letra))
            return false;
        return true;
    }

    //Tengo muchas dudas del uso de hashCode(), no sé para qué sirve. 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((letra == null) ? 0 : letra.hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "La letra "+ letra + " aparece " + cantidad + " veces";
    }
    
    public int compareTo(Ocurrencia o) {
        return this.letra.compareTo(o.letra);
    }
}