package ejercicios.ejercicio1;

import java.util.ArrayList;

import funciones.Mathematics;

public class Main {
    public static void main(String[] args) {
        // ^ Definimos un arrayList
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        // ! Rellenamos el array con 20 números aleatorios menores a 100
        for (int i = 0; i < 20; i++) {
            numeros.add(Mathematics.rng(99));
        }

        System.out.printf("Longitud del Array: %s\n", numeros.size());
        System.out.println(numeros);
    }
}
