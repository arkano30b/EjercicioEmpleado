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
public class Empleado extends Persona {
    private short idEmpleado;
    private double salario;
    private byte [] horaExtras =new byte[12];
    static int  numEmpleados=0;
    
    
    //<editor-fold desc="Contructores">
    public Empleado(){        
    }
    public Empleado(String nombre, String apellidos, int telefono, LocalDate fechaNacimiento){
        super(nombre,apellidos, telefono, fechaNacimiento);
        llenarHorasExtras();
        numEmpleados++;
    }
    public Empleado(String nombre, String apellidos, int telefono, LocalDate fechaNacimiento, short idEmpleado,
                    double salario) throws IllegalArgumentException {
        this(nombre,apellidos, telefono, fechaNacimiento);
        setIdEmpleado(idEmpleado);
        this.salario=salario;               
        
    }
    
    public Empleado(Persona cliente,
                        short idEmpleado, double salario) throws IllegalArgumentException{
        super(cliente.nombre, cliente.apellidos, cliente.telefono, cliente.fechaNacimiento);
        setIdEmpleado(idEmpleado);
       
        this.salario = salario;
    }
    //</editor-fold>

    
    //<editor-fold desc="Métodos">
    private void llenarHorasExtras(){
        for (int i =0; i<12; i++){
            horaExtras[i]= (byte) (Math.random()*41);
        }
    }
    private double sueldoMensual(byte mes){
        double precioHora= salario/30/8;
        double horaExtra;
        if (idEmpleado<=100){
             horaExtra=precioHora + precioHora * 0.10;
        }else {
            horaExtra=precioHora + precioHora * 0.05;
        }
        return salario + horaExtras[mes] * horaExtra;        
    }
    
    @Override
    public String toString(){
        StringBuilder cadena = new StringBuilder(super.toString());
        for (int i = 0; i < 12; i++) {
            cadena.append("mes.. " + (i+1) + ".....horas trabajadas " +horasExtraMes((byte)i) + ".... sueldo  " + sueldoMensual((byte)(i))+".\n"); 
        }
        
        return cadena.toString();
    }   
    
    //<editor-fold desc="Getter/Setter">
    public short getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(short idEmpleado) throws IllegalArgumentException{
        if (idEmpleado<1 || (idEmpleado>100 && idEmpleado<500)) throw new IllegalArgumentException("Id no comtemplado para empleado");
            else this.idEmpleado = idEmpleado;
    }

    public static void setNumEmpleados(int parametro) {
        numEmpleados = numEmpleados + parametro;
    }
    public static int getNumEmpleados() {
        return numEmpleados;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public byte horasExtraMes(byte mes){
        return horaExtras[mes];
    }
    
    //</editor-fold>
    //</editor-fold>
    
}
