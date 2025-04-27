package desafio2.Modelo;

import java.util.ArrayList;

public class EmpleadoAsalariado extends Empleado{
    private double sueldoMensual;
    private double sueldo;

    public EmpleadoAsalariado(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados, double sueldoMensual, double sueldo) {
        super(numLegajo, nombre, apellido, listaEmpleados);
        this.sueldoMensual = sueldoMensual;
        this.sueldo = sueldo;
    }

    public EmpleadoAsalariado() {}

    public double getSueldoMensual() { return sueldoMensual; }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public double getSueldo() { return sueldo; }

    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
}
