package desafio2;

import desafio2.Controlador.ControladorEmpleado;
import desafio2.Modelo.Empleado;
import desafio2.Modelo.EmpleadoAsalariado;
import desafio2.Modelo.EmpleadoBaseMasComision;
import desafio2.Modelo.EmpleadoPorComision;
import desafio2.Modelo.EmpleadoPorHora;
import desafio2.Vista.VistaEmpleado;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VistaEmpleado vistaEmpleado = new VistaEmpleado();

        Empleado empleado1 = new Empleado();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        ControladorEmpleado controlador = new ControladorEmpleado(vistaEmpleado, empleado1, listaEmpleados);

        controlador.output();
    }
}