/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDatos;

import java.time.LocalDate;

/**
 *
 * @author arkano
 */
public class Persona {
    protected String nombre;
    protected String apellidos;
    protected int telefono;
    protected LocalDate fechaNacimiento;
    
    //<editor-fold desc="Constructores">  
    public Persona(){        
    }
    
    public Persona(String nombre,String apellidos,int telefono,LocalDate fechaNacimiento){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.telefono=telefono;
        this.fechaNacimiento=fechaNacimiento;      
    }
    //</editor-fold>
    
    //<editor-fold desc="Métodos">  
    
    public boolean esTuDia(){         
        if (fechaNacimiento!=null){
           int hoy= LocalDate.now().getDayOfYear();
           int dia=fechaNacimiento.getDayOfYear();
           if (hoy==dia) return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        
        StringBuilder cadena  = new StringBuilder("Datos del Empleado  ");
        
        if (esTuDia()){ 
            cadena.append("...--HOY CUPLE AÑOS---..");
        }
        
        cadena.append("\nnombre: "+ nombre + " "+ apellidos + ".  Teléfono.: " + telefono+"\n");
        
        return cadena.toString();
    }
    //<editor-fold desc="Getter/Setter">  

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    //</editor-fold>
    //</editor-fold>

    
}
