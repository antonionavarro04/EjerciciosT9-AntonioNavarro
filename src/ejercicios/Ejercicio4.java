package ejercicios;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import funciones.ConsoleManager;

public class Ejercicio4 extends ConsoleManager {
    private static final char SALIR = '3';

    public static void main(String[] args) {
        // ^ Definimos dos TreeSet de Integers, uno para numeros y otros para estrellas(numeros)
        TreeMap<Integer, Integer> numeros = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> estrellas = new TreeMap<Integer, Integer>();

        // ^ Definimos una instancia de la clase Scanner
        final Scanner read = new Scanner(System.in).useLocale(Locale.US);

        int num;
        char opcion;
        
        do {
            System.out.println("1. Introducir serie de Euromillon");
            System.out.println("2. Ver numeros acumulados");
            System.out.printf("%s. Salir\n", SALIR);
            System.out.print(">>> ");
            try { // ? Intentamos leer un char
                opcion = read.nextLine().charAt(0);
            } catch (Exception e) { // ? Si se ha introducido algo invalido, como una cadena vacia. Cambiaremos la opcion a '0'
                opcion = '0';
            }

            switch (opcion) {
                case '1':
                int newValue;
                boolean state;

                for (int i = 1; i <= 5; i++) {
                    Object code;
                    int intCode = -1;

                    System.out.printf("Introduce el Nº%s: ", i);
                    num = read.nextInt(); read.nextLine(); // ? Limpiamos Búffer
                    code = numeros.put(num, 1);
                    
                    if (code != null) {
                        intCode = (Integer) code;
                    } if (intCode > 0) {
                        newValue = numeros.get(num);
                        state = numeros.replace(num, newValue, newValue + 1);

                        System.out.print(state ? "" : "Se ha producido un error");
                    }
                } for (int i = 1; i <= 2; i++) {
                    Object code;
                    int intCode = -1;

                    System.out.printf("Introduce la estrella Nº%s: ", i);
                    num = read.nextInt(); read.nextLine(); // ? Limpiamos Búffer
                    code = estrellas.put(num, 1);
                    
                    if (code != null) {
                        intCode = (Integer) code;
                    } if (intCode > 0) {
                        newValue = estrellas.get(num);
                        state = estrellas.replace(num, newValue, newValue + 1);
                    }
                } break;

                case '2':
                    System.out.printf("Numeros:\n%s\n\nEstrellas:\n%s\n", numeros, estrellas);
                    break;

                case SALIR:
                    System.out.println("Saliendo del programa...");
                    break;
            
                default:
                    System.out.printf("Opción '%s' inválida\n", opcion);
                    continue;
            } if (opcion != SALIR) {
                System.out.print("\nPresiona 'enter' para continuar...");
                read.nextLine();
                System.out.println(RESET);
            }
        } while (opcion != SALIR);

        // ^ Cerramos el Scanner
        read.close();
    }
}
