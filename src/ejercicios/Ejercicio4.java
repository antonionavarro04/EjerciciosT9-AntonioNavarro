package ejercicios;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import funciones.ConsoleManager;

public class Ejercicio4 extends ConsoleManager {
    private static final char SALIR = '3';

    public static void main(String[] args) { clear(); // ? Limpiamos la consola nada más entrar
        // ^ Definimos dos TreeSet de Integers, uno para numeros y otros para estrellas(numeros)
        TreeMap<Integer, Integer> numeros = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> estrellas = new TreeMap<Integer, Integer>();

        // ^ Definimos una instancia de la clase Scanner
        Scanner read = new Scanner(System.in).useLocale(Locale.US);

        // ^ Definimos variables para los numeros que se van a introducir y la opción del menú
        int num;
        char opcion;

        // ^ Definimos variables para la inserción de los números y las capturas de los códigos de error
        Object code;
        int intCode = -1;
        
        do { // ? Mostramos el menú y esperamos a una respuesta por parte del usuario
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
                case '1': // * Introducir serie
                for (int i = 1; i <= 5; i++) { // * Bucle de los Números
                    System.out.printf("Introduce el Nº%s: ", i);
                    num = read.nextInt(); read.nextLine(); // ? Limpiamos Búffer
                    code = numeros.put(num, 1); // ! Introducimos el número en el mapa de números
                    // TODO | HACER QUE NO SE PUEDAN REPETIR NUMEROS, ARRAY
                    if (code != null) { // ? Si el código es diferente a null quiere decir que el número ya estaba en el mapa
                        intCode = (Integer) code; // ! Parseamos el codigo a Integer
                    } if (intCode > 0) {
                        numeros.replace(num, intCode + 1); // ! Remplazamos el valor de la clave num por su mismo valor +1
                    } intCode = -1; // ! Reseteamos intCode
                } for (int i = 1; i <= 2; i++) { // * Bucle de las estrellas
                    System.out.printf("Introduce la estrella Nº%s: ", i);
                    num = read.nextInt(); read.nextLine(); // ? Limpiamos Búffer
                    code = estrellas.put(num, 1); // ! Introducimos el número en el mapa de estrellas
                    
                    if (code != null) { // ? Si el código es diferente a null quiere decir que el número ya estaba en el mapa
                        intCode = (Integer) code; // ! Parseamos el codigo a Integer
                    } if (intCode > 0) {
                        estrellas.replace(num, intCode + 1); // ! Remplazamos el valor de la clave num por su mismo valor +1
                    }
                } break;

                case '2': // * Ver Números Acumulados
                    System.out.printf("Numeros:\n%s\n\nEstrellas:\n%s\n", numeros, estrellas); // ? Imprimimos los números y estrellas
                    break;

                case SALIR: // * Salir del Programa
                    System.out.println("Saliendo del programa...");
                    break;
            
                default: // * Cualquier opción que no este arriba
                    System.out.printf("Opción '%s' inválida\n", opcion);
                    continue;
            } if (opcion != SALIR) { // ? Si la opción es diferente a salir esperamos a que el usuario presione enter para continuar
                System.out.print("\nPresiona 'enter' para continuar...");
                read.nextLine();
                clear();
            }
        } while (opcion != SALIR);

        // ^ Cerramos el Scanner
        read.close();
    }
}
