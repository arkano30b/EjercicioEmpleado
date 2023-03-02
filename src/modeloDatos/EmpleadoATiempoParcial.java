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
public class EmpleadoATiempoParcial extends Empleado{
    protected double precioXHora;
    protected byte horasTrabajadas;
    
    //<editor-fold desc="Contructores">
    public EmpleadoATiempoParcial(String nombre, String apellidos, int telefono, LocalDate fechaNacimiento, short idEmpleado,
                    double salario, double precioXHora, byte horasTrabajadas) throws IllegalArgumentException{
        super(nombre,apellidos,telefono,fechaNacimiento);
        if (idEmpleado<2000) throw new IllegalArgumentException("El id de un empleado a tiempo parcial debe ser mayor de 2000");
         
        super.setIdEmpleado(idEmpleado);
        super.setSalario(salario);
        this.precioXHora=precioXHora;
        this.horasTrabajadas=horasTrabajadas;             
    }
    //</editor-fold>
    
    //<editor-fold desc="Métodos">
    private double sueldoMensual(byte mes){
        double precioHoraExtra=super.getSalario()/30/8;
        precioHoraExtra=precioHoraExtra + precioHoraExtra * 0.05;
        
        return horasTrabajadas * precioXHora + super.horasExtraMes(mes) * precioHoraExtra;
        
    }
    
        
    //<editor-fold desc="Getter/Setter">

    public double getPrecioXHora() {
        return precioXHora;
    }

    public byte getHorasTrabajadas() {
        return horasTrabajadas;
    }
    public void setPrecioXHora(double precioXHora) {
        this.precioXHora = precioXHora;
    }

    public void setHorasTrabajadas(byte horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    
    //</editor-fold>
    //</editor-fold>

   
    
    
}
