package desafio2.Modelo;

import java.util.ArrayList;

public class EmpleadoBaseMasComision extends Empleado{
    private double sueldoBase;
    private double tasaComision;
    private int ventas;

    public EmpleadoBaseMasComision(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados, double sueldoBase, double tasaComision, int ventas) {
        super(numLegajo, nombre, apellido, listaEmpleados);
        this.sueldoBase = sueldoBase;
        this.tasaComision = tasaComision;
        this.ventas = ventas;
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

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int numVentas) {
        this.ventas = numVentas;
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBase + ((this.tasaComision * this.ventas) / 100); // Cálculo de sueldo base más comisión
    }

}
