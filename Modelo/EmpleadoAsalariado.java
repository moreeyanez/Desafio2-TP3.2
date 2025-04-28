package desafio2.Modelo;

import java.util.ArrayList;

public class EmpleadoAsalariado extends Empleado{
    private double sueldoMensual;

    public EmpleadoAsalariado(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados, double sueldoMensual) {
        super(numLegajo, nombre, apellido, listaEmpleados);
        this.sueldoMensual = sueldoMensual;
    }

    public EmpleadoAsalariado() {}

    public double getSueldoMensual() { return sueldoMensual; }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo() {
        return sueldoMensual; // Sueldo mensual ya calculado
    }

}
