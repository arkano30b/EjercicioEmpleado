/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioempleado;

import java.time.LocalDate;
import modeloDatos.Empleado;
import modeloDatos.EmpleadoATiempoParcial;     
import modeloDatos.Persona;
import recursos.Utilidades;



/**
 *
 * @author arkanos
 */
public class EjercicioEmpleado {
    
    final static int MAX_NUM_EMPLEADOS = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[MAX_NUM_EMPLEADOS];
        
        try {
            empleados[0] = new Empleado("Juan", "Calzo Nazos", 634456321, LocalDate.of(1980,2,4), (short) 1,  2000.0);
            empleados[1] = new Empleado("Arturo", "Riro Lero", 657342891, LocalDate.of(1977,2,4), (short) 501,  1200.0);
            
            empleados[2] = new EmpleadoATiempoParcial("Pablo", "Col Etas", 657342891, LocalDate.of(1973,12,4),  //datos de Persona
                                                        (short) 2001,  1200.0,    //idEmpleado, salarioMensual  - datos de Empleado
                                                        6.0, (byte)10);              //precioXHora, horasTrabajadas - datos EmpleadoATiempoParcial

            añadirEmpleado(empleados);

            Utilidades.limpiarPantalla();
            
            Persona nuevaPersona = new Persona("Raul","Fortes Rejilla", 654783221, LocalDate.of(1998,2,8) );
            empleados[4]= new Empleado(nuevaPersona, (short) 506, 1100.0);
            
            mostrarEmpleados(empleados);
            
            
            /*      
            nuevaPersona.setNombre("Antonia");
            System.out.println(nuevaPersona);
            System.out.println(empleados[4]);
            */
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Utilidades.dormir(5000);
            Empleado.setNumEmpleados(1);
            
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado");
            System.out.println("La aplicación se cerrará ordenadamente");
            System.out.println(e.getMessage());
            Utilidades.dormir(5000);
        }

    }//fin del main
    
    static void añadirEmpleado(Empleado[] misEmpleados){
        String nombre=Utilidades.pedirString("introduzca el nombre del Empleado");
        String apellidos=Utilidades.pedirString("Introduzca los apellidos del Empleado");
        int telefono=Utilidades.pedirEntero("Teléfono del Empleado");
        LocalDate fNacimiento=Utilidades.pedirFecha("Fecha de nacimiento del Empleado");
        short idEmpeado=Utilidades.pedirByte("Número de Identificación de Empleado");
        double salarioMensual=Utilidades.pedirDouble("Salario mensual");
        boolean colocado=false;
        
        for (int i=0;i<MAX_NUM_EMPLEADOS && !colocado;i++){
            if (misEmpleados [i]==null){
                misEmpleados[i]= new Empleado(nombre, apellidos, telefono, fNacimiento, idEmpeado, salarioMensual);
                colocado=true;
                
                System.out.println("Se ha guardado el empleado");
            }    
        }
        if (!colocado){
            System.out.println("No podemos contratar más empleados");
            Utilidades.dormir(5000);
            Utilidades.limpiarPantalla();
        }
    }
    /**
     * Metodo que muestra la información personal y profesional del empleado. Para ello
     * usa un bucle foreach que recorre todo el array de empleados que recibe como parametro.
     * @param arrayEmpleados 
     */
    static void mostrarEmpleados(Empleado[] arrayEmpleados) {

        for (Empleado emplead : arrayEmpleados) {
            if (emplead != null) {
             //   System.out.println(comoYoQuiera.toString2());                 
                System.out.println(emplead);
            }
        }

        System.out.println("El total de empleados de la empresa es:.. " + Empleado.getNumEmpleados());

    }
}
