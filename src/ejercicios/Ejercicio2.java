package ejercicios;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        // ^ Definimos un LinkedHashSet que guarde Strings
        LinkedHashSet<String> names = new LinkedHashSet<String>();

        // ^ Definimos una instancia de la clase Scanner
        Scanner read = new Scanner(System.in).useLocale(Locale.US);

        // ^ Definimos una String
        String name;

        // ! Comenzamos a pedir nombres hasta que el usuario introduzca "fin"
        do {
            System.out.print("Introduce un nombre: ");
            name = read.nextLine();
            if (name.equalsIgnoreCase("fin")) { // ? Si el usuario introduce fin saldremos del programa
                break;
            } else { // ? En caso contrario agregaremos el nombre al array
                boolean state = names.add(name); // ! Recogemos el estado de la operacion

                if (!state) { // ? Si la operación no se ha podido completar mostraremos un mensaje de error
                    System.out.printf("El nombre %s ya se encuentra en el Array\n", name);
                }
            }
        } while (true);

        // ^ Cerramos el Scanner
        read.close();

        // ? Mostramos el contenido de names
        System.out.println(names);
    }
}
