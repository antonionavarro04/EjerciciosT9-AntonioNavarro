package ejercicios;

import java.util.LinkedHashSet;

import funciones.Mathematics;

public class Ejercicio1 {
    public static void main(String[] args) {
        // ^ Definimos un arrayList
        LinkedHashSet<Integer> numeros = new LinkedHashSet<Integer>();

        // ^ Definimos una variable para guardar el tamaño del array
        byte size;

        do { // ! Agregaremos números
            numeros.add(Mathematics.rng(99)); // * Entre el rango 0-99
            size = (byte) numeros.size();
        } while (size != 20); // ? Mientras que el tamaño del array sea diferente a 20

        System.out.printf("Longitud del Array: %s\n", size);
        System.out.println(numeros);
    }
}
