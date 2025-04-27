package desafio2.Controlador;

import com.fasterxml.jackson.core.type.TypeReference;
import desafio2.Modelo.Empleado;
import desafio2.Modelo.EmpleadoAsalariado;
import desafio2.Modelo.EmpleadoBaseMasComision;
import desafio2.Modelo.EmpleadoPorComision;
import desafio2.Modelo.EmpleadoPorHora;
import desafio2.Vista.VistaEmpleado;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ControladorEmpleado {
    VistaEmpleado vista;
    Empleado empleado1;
    ArrayList<Empleado> listaEmpleados;

    public ControladorEmpleado(VistaEmpleado vista, Empleado empleado1, ArrayList<Empleado> listaEmpleados) {
        this.vista = vista;
        this.empleado1 = empleado1;
        this.listaEmpleados = listaEmpleados;
    }

    public void output (){
        while (vista.getEjecutando()){
            vista.mostrarVista();
            Scanner scanner = vista.getScanner();

            try {
                int opcion = scanner.nextInt();

                if (opcion == 1){
                    ingresarEmpleado();
                } else if (opcion == 2) {
                    buscarDatos();
                } else if (opcion == 3) {
                    //...
                } else if (opcion == 4) {
                    //...
                } else if (opcion == 5) {
                    //...
                } else if (opcion == 6) {
                    //...
                } else if (opcion == 7) {
                    //....
                } else if (opcion == 8) {
                    //....
                } else if (opcion == 9) {
                    vista.setEjecutando(false);
                }
            } catch (InputMismatchException e) {
                vista.setMensajeConsola("\nLa opción ingresada no es válida. Por favor intenta de nuevo!");
                System.out.println(vista.getMensajeConsola());
                scanner.nextLine();
            }
        }
    }

    public void ingresarEmpleado () {
        Scanner scanner = vista.getScanner();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        boolean ejecucion = true;
        while (ejecucion) {
            vista.setMensajeConsola("\n¿Que empleado desea ingresar?");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 1) Empleado Asalariado");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 2) Empleado por hora");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 3) Empleado por comisión");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 4) Empleado base más comisión");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 5) Salir");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola("Opción elegida: ");
            System.out.print(vista.getMensajeConsola());
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) { //Empleado asalariado
                vista.setMensajeConsola("Ingrese el numero de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el sueldo mensual del empleado: ");
                System.out.print(vista.getMensajeConsola());
                double sueldoMensual = scanner.nextDouble();

                double sueldo = sueldoMensual;
                vista.setMensajeConsola("El sueldo del empleado es: " + sueldo);
                System.out.println(vista.getMensajeConsola());

                EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, sueldoMensual, sueldo);
                listaEmpleados.add(empleadoAsalariado);

            } else if (opcion == 2) { //Empleado por hora
                vista.setMensajeConsola("Ingrese el numero de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el sueldo básico del empleado: ");
                System.out.print(vista.getMensajeConsola());
                double sueldoBasico = scanner.nextDouble();

                vista.setMensajeConsola("Ingrese la cantidad de horas trabajadas por el empleado: ");
                System.out.print(vista.getMensajeConsola());
                int horasTrabajadas = scanner.nextInt();

                vista.setMensajeConsola("Ingrese el valor por hora: ");
                System.out.print(vista.getMensajeConsola());
                double valorPorHora = scanner.nextDouble();

                double sueldo = sueldoBasico + horasTrabajadas * valorPorHora;
                vista.setMensajeConsola("El sueldo del empleado es: " + sueldo);
                System.out.println(vista.getMensajeConsola());

                EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, sueldoBasico, horasTrabajadas, valorPorHora, sueldo);
                listaEmpleados.add(empleadoPorHora);

            } else if (opcion == 3) { //Empleado por comision
                vista.setMensajeConsola("Ingrese el numero de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese la tasa de comisión: ");
                System.out.print(vista.getMensajeConsola());
                double tasaDeComision = scanner.nextDouble();

                vista.setMensajeConsola("Ingrese la cantidad de ventas realizadas por el empleado: ");
                System.out.print(vista.getMensajeConsola());
                int ventas = scanner.nextInt();

                double sueldo = (tasaDeComision * ventas) / 100;
                vista.setMensajeConsola("El sueldo del empleado es: " + sueldo);
                System.out.println(vista.getMensajeConsola());

                EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, tasaDeComision, ventas, sueldo);
                listaEmpleados.add(empleadoPorComision);

            } else if (opcion == 4) { //Empleado base mas comision
                vista.setMensajeConsola("Ingrese el numero de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el sueldo base del empleado: ");
                System.out.print(vista.getMensajeConsola());
                double sueldoBase = scanner.nextDouble();

                vista.setMensajeConsola("Ingrese la tasa de comisión: ");
                System.out.print(vista.getMensajeConsola());
                double tasaComision = scanner.nextDouble();

                vista.setMensajeConsola("Ingrese la cantidad de ventas realizadas por el empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numVentas = scanner.nextInt();

                double sueldo = sueldoBase + ((tasaComision * numVentas) / 100);
                vista.setMensajeConsola("El sueldo del empleado es: " + sueldo);
                System.out.println(vista.getMensajeConsola());

                EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, sueldoBase, tasaComision, numVentas, sueldo);
                listaEmpleados.add(empleadoBaseMasComision);
            } else if (opcion == 5) {
                ejecucion = false;
            }
        }

        Empleado empleado1 = new Empleado();
        listaEmpleados.add(empleado1);
        guardarInfo(listaEmpleados);
    }

    public void buscarDatos (){ //Buscar datos de un empleado"; //usando el legajo
        Scanner scanner = vista.getScanner();
        boolean salir = false;

        while (!salir) {
            vista.setMensajeConsola("Ingrese el legajo del empleado que busca: ");
            System.out.print(vista.getMensajeConsola());
            int buscador = scanner.nextInt();

            boolean encontrado = false;

            for (Empleado empleado : listaEmpleados) {
                if (empleado.getNumLegajo() == buscador) {
                    vista.setMensajeConsola("Empleado " + buscador + " encontrado:");
                    System.out.println(vista.getMensajeConsola());
                    vista.setMensajeConsola("Nombre: " + empleado.getNombre());
                    System.out.println(vista.getMensajeConsola());
                    vista.setMensajeConsola("Apellido: " + empleado.getApellido());
                    System.out.println(vista.getMensajeConsola());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                vista.setMensajeConsola("No se encontró ningún empleado con ese legajo.");
                System.out.println(vista.getMensajeConsola());
            }

            try {
                // Preguntar si quiere volver a intentar o salir
                vista.setMensajeConsola("\n¿Desea buscar otro legajo?\n1) Sí\n2) No (salir)");
                System.out.println(vista.getMensajeConsola());
                int opcion = scanner.nextInt();

                if (opcion == 2) {
                    salir = true;
                }
            } catch (InputMismatchException e) {
                vista.setMensajeConsola("\nLa opción ingresada no es válida. Por favor intenta de nuevo!");
                System.out.println(vista.getMensajeConsola());
                scanner.nextLine();
            }
        }
    }


        /*boolean encontrado = false;

        while (!encontrado){
            vista.setMensajeConsola("Ingrese el legajo del empleado que busca: ");
            System.out.print(vista.getMensajeConsola());
            int buscador = scanner.nextInt();

            for (Empleado empleado: listaEmpleados) {
                if(empleado.getNumLegajo() == buscador) {
                    vista.setMensajeConsola("Empleado " + buscador + " encontrado: ");
                    System.out.println(vista.getMensajeConsola());
                    vista.setMensajeConsola("Nombre: " + empleado.getNombre());
                    System.out.println(vista.getMensajeConsola());
                    vista.setMensajeConsola("Apellido: " + empleado.getApellido());
                    System.out.println(vista.getMensajeConsola());

                    //if (empleado == //es un empleado tipo x)

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                vista.setMensajeConsola("No se encontro ningun empleado con ese legajo.");
                System.out.println(vista.getMensajeConsola());
            }
        }*/


    public void guardarInfo(ArrayList<Empleado> listaEmpleados){
        try{
            System.out.println("Info Saved");
            System.out.println(" ");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardada.json"), listaEmpleados);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateList() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            listaEmpleados = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardada.json"), new TypeReference<>(){});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



















}
