/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author arkano
 */
public class Utilidades {
    /**
     * Metodo que limpia la pantalla, imprimiendo 30 lineas en blanco
     */
    public static void limpiarPantalla() {
        for (byte i = 0; i < 30; i++) {
            System.out.println("\n");
        }
    }

    /**
     * Metodo que detiene la ejecución durante un tiempo
     *
     * @param x
     */
    public static void dormir(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            System.out.println("...");
        }
    }

    /**
     * Metodo que pide un dato de tipo entero mostrando un mensaje
     *
     * @param mensaje lo que va a mostrar por pantalla para pedir el dato
     * @return entero
     */
    public static int pedirEntero(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar;
        int numero = 0;
        do {
            continuar = true;
            try {
                System.out.println(mensaje);
                numero = teclado.nextInt();
            } catch (InputMismatchException e) {
                continuar = false;
                teclado.nextLine();
                System.err.println("Debe introducir un número entero.");
            }
        } while (!continuar);
        return numero;
    }

    /**
     * Metodo que pide un dato de tipo String mostrando un mensaje
     *
     * @param mensaje lo que va a mostrar por pantalla para pedir el dato
     * @return String
     */
    public static String pedirString(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar;
        String cadena = "";
        do {
            continuar = true;
            try {
                System.out.println(mensaje);
                cadena = teclado.nextLine();
            } catch (InputMismatchException e) {
                continuar = false;
                teclado.nextLine();
                System.err.println("Debe introducir una cadena de texto correcta.");
            }
        } while (!continuar);
        return cadena;
    }

    /**
     * Metodo que pide un dato de tipo double mostrando un mensaje
     *
     * @param mensaje lo que va a mostrar por pantalla para pedir el dato
     * @return double
     */
    public static double pedirDouble(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar;
        double real = 0;
        do {
            continuar = true;
            try {
                System.out.println(mensaje);
                real = teclado.nextDouble();
            } catch (InputMismatchException e) {
                continuar = false;
                teclado.nextLine();
                System.err.println("Debe introducir un número real.");
            }
        } while (!continuar);
        return real;
    }

    public static byte pedirByte(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar;
        byte valor = 0;
        do {
            continuar = true;
            try {
                System.out.println(mensaje);
                valor = teclado.nextByte();
            } catch (InputMismatchException e) {
                continuar = false;
                teclado.nextLine();
                System.err.println("Debe introducir un byte.");
            }
        } while (!continuar);
        return valor;
    }
    
    /**
     * Metodo que pide un dato de tipo short mostrando un mensaje
     * @param mensaje pasado como parámetro
     * @return 
     */
    public static short pedirShort(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar;
        short valor = 0;
        do {
            continuar = true;
            try {
                System.out.println(mensaje);
                valor = teclado.nextShort();
            } catch (InputMismatchException e) {
                continuar = false;
                teclado.nextLine();
                System.err.println("Debe introducir un valor correcto.");
            }
        } while (!continuar);
        return valor;
    }

    /**
     * Metodo que pide 3 datos de tipo entero dia,mes y año y devuelve un objeto
     * LocalDate con la fecha dada.
     * @param mensaje que mostrará por pantalla antes de pedir dia, mes y año.
     * @return 
     */
    public static LocalDate pedirFecha(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar;
        short valor = 0;
        int anio = 0;
        int mes = 0;
        int dia = 0;

        do {
            continuar = true;
            try {
                System.out.println(mensaje);
                dia = pedirEntero("dime el dia");
                mes = pedirEntero("dime el mes");
                anio = pedirEntero("dime el año");

            } catch (InputMismatchException e) {
                continuar = false;
                teclado.nextLine();
                System.err.println("Debe introducir valores adecuados");
            }
        } while (!continuar);
        return LocalDate.of(anio, mes, dia);
    }
}
