package ejercicios;

// ? Imports
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import funciones.ConsoleManager;

public class Ejercicio5 extends ConsoleManager {
    private static final char SALIR = '0';

    public static void main(String[] args) { clear(); // ? Limpiamos la consola nada más entrar
        // ^ Definimos un HashMap de Strings y Doubles
        HashMap<String, Float> productos = new HashMap<String, Float>();

        // ^ Definimos una instancia de la clase Scanner
        Scanner read = new Scanner(System.in).useLocale(Locale.US);

        // ^ Definimos variables para el nombre y el precio así como una para la opción
        String nombre;
        float precio;
        char opcion;

        // ^ Definimos una variable Objeto para recolectar el código de error y otra de tipo int
        Object code;

        do { // ? Mostramos el menú
            System.out.println("PRODUCTOS");
            System.out.println("1. Alta de Producto");
            System.out.println("2. Baja de Producto");
            System.out.println("4. Listar Existencias");
            System.out.printf("%s. Salir\n", SALIR);
            System.out.print(">>> ");

            try { // ? Intentamos leer un char
                opcion = read.nextLine().charAt(0);
            } catch (Exception e) { // ? Si captura una excepción quiere decir que algo inválido ha sido introducido
                // ! Para evitar errores le vamos a poner la opción 'a' de forma que en el switch entre en el default y vuelva a comenzar el bucle
                opcion = 'a';
            }

            switch (opcion) { // ? Procesamos la opción introducida por el usuario
                case SALIR: // * Salir
                    System.out.println("Saliendo del Programa...");
                    break;

                case '1': // * Alta
                    System.out.print("Introduce un nombre para el nuevo producto: ");
                    nombre = read.nextLine();

                    System.out.print("Introduce un precio para el nuevo producto: ");
                    precio = read.nextFloat(); read.nextLine(); // ? Limpiamos el Búffer

                    // ! Introducimos los datos en el array
                    code = productos.put(nombre, precio);

                    if (code == null) { // ? Si el codigo es null quiere decir que no habrá habido problemas al insertar el dato
                        System.out.println("Operación realizada correctamente");
                    } else { // ? Si el código es diferente a null debemos avisar al usuario que el producto ya se encuentra en el array
                        System.out.printf("El producto \"%s\" ya se encuentra en la lista!\n", nombre);
                    } break;

                case '2': // * Baja
                    System.out.print("Introduce el nombre del producto a eliminar: ");
                    nombre = read.nextLine();

                    code = productos.remove(nombre);

                    if (code != null) { // ? Si el codigo es diferente a null quiere decir que no habrá habido problemas al eliminar el dato
                        System.out.println("Operación realizada correctamente");
                    } else { // ? Si el código es null debemos avisar al usuario que el producto no se encuentra en el array
                        System.out.printf("El producto \"%s\" no se encuentra en la lista!\n", nombre);
                    } break;

                case '4': // * Listado
                    System.out.printf("Format: nombre=precio\n%s\n", productos);
                    break;
            
                default: // * Cualquier Otra Opción
                    System.out.printf("La opción '%s' es inválida\n", opcion);
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
