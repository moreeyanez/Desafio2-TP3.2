package desafio2.Modelo;

import java.util.ArrayList;

public class EmpleadoPorComision extends Empleado{
    private double tasaDeComision;
    private int ventas;
    private double sueldo;

    public EmpleadoPorComision(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados, double tasaDeComision, int ventas, double sueldo) {
        super(numLegajo, nombre, apellido, listaEmpleados);
        this.tasaDeComision = tasaDeComision;
        this.ventas = ventas;
        this.sueldo = sueldo;
    }

    public EmpleadoPorComision () {}

    public double getTasaDeComision() {
        return tasaDeComision;
    }

    public void setTasaDeComision(double tasaDeComision) {
        this.tasaDeComision = tasaDeComision;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public double getSueldo() { return sueldo; }

    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
}
