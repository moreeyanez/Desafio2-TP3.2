package desafio2.Modelo;

import java.util.ArrayList;

public class EmpleadoBaseMasComision extends Empleado{
    private double sueldoBase;
    private double tasaComision;
    private int numVentas;
    private double sueldo;

    public EmpleadoBaseMasComision(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados, double sueldoBase, double tasaComision, int numVentas, double sueldo) {
        super(numLegajo, nombre, apellido, listaEmpleados);
        this.sueldoBase = sueldoBase;
        this.tasaComision = tasaComision;
        this.numVentas = numVentas;
        this.sueldo = sueldo;
    }

    public EmpleadoBaseMasComision () {}

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getTasaComision() {
        return tasaComision;
    }

    public void setTasaComision(double tasaComision) {
        this.tasaComision = tasaComision;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public double getSueldo() { return sueldo; }

    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
}
