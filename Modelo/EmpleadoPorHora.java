package desafio2.Modelo;

import java.util.ArrayList;

public class EmpleadoPorHora extends Empleado{
    private double sueldoBasico;
    private int horasTrabajadas;
    private double valorPorHora;

    public EmpleadoPorHora(int numLegajo, String nombre, String apellido, ArrayList<Empleado> listaEmpleados, double sueldoBasico, int horasTrabajadas, double valorPorHora) {
        super(numLegajo, nombre, apellido, listaEmpleados);
        this.sueldoBasico = sueldoBasico;
        this.horasTrabajadas = horasTrabajadas;
        this.valorPorHora = valorPorHora;
    }

    public EmpleadoPorHora () {}

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * this.valorPorHora); // Cálculo de sueldo por hora
    }

}
