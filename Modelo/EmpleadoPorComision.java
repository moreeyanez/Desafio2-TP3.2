package desafio2.Modelo;

import java.util.ArrayList;

public class EmpleadoPorComision extends Empleado{
    private double tasaComision;
    private int ventas;

    public EmpleadoPorComision(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados, double tasaComision, int ventas) {
        super(numLegajo, nombre, apellido, listaEmpleados);
        this.tasaComision = tasaComision;
        this.ventas = ventas;
    }

    public EmpleadoPorComision () {}

    public double getTasaComision() {
        return tasaComision;
    }

    public void setTasaComision(double tasaComision) {
        this.tasaComision = tasaComision;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    @Override
    public double calcularSueldo() {
        return (this.tasaComision * this.ventas) / 100; // Cálculo de sueldo por comisión
    }

}
