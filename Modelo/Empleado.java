package desafio2.Modelo;

import java.util.ArrayList;

public abstract class Empleado {
    private int numLegajo;
    private String nombre;
    private String apellido;
    private ArrayList<Empleado> listaEmpleados;
    private double sueldo;

    public Empleado(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados) {
        this.numLegajo = numLegajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaEmpleados = listaEmpleados;
    }

    public Empleado(){}

    public int getNumLegajo() {
        return numLegajo;
    }

    public void setNumLegajo(int numLegajo) {
        this.numLegajo = numLegajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public double getSueldo() { return sueldo; }

    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    public abstract double calcularSueldo();

    public void mostrarInfo(){
        System.out.println("  Legajo: " + numLegajo);
        System.out.println("  Nombre: " + nombre);
        System.out.println("  Apellido: " + apellido);
        System.out.println("  Sueldo: " + sueldo);
    }
}
