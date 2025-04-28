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
import java.util.Iterator;
import java.util.Scanner;


public class ControladorEmpleado {
    VistaEmpleado vista;
    ArrayList<EmpleadoAsalariado> listaEmpleadosAsalariados = new ArrayList<>();
    ArrayList<EmpleadoPorHora> listaEmpleadosPorHora = new ArrayList<>();
    ArrayList<EmpleadoPorComision> listaEmpleadosPorComision = new ArrayList<>();
    ArrayList<EmpleadoBaseMasComision> listaEmpleadosBaseMasComision = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    //Constructor
    public ControladorEmpleado(VistaEmpleado vista, ArrayList<Empleado> listaEmpleados) {
        this.vista = vista;
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
                    buscarDatos ();
                } else if (opcion == 3) {
                    eliminarEmpleado ();
                } else if (opcion == 4) {
                    cantidadEmpleados();
                } else if (opcion == 5) {
                    cantidadEmpleadosEspecificos();
                } else if (opcion == 6) {
                    mostrarEmpleadosEspecificos();
                } else if (opcion == 7) {
                    mostrarTodosEmpleados();
                } else if (opcion == 8) {
                    vista.setEjecutando(false);
                }
            } catch (InputMismatchException e) {
                vista.setMensajeConsola("\nLa opción ingresada no es válida. Por favor intentá de nuevo!");
                System.out.println(vista.getMensajeConsola());
                scanner.nextLine();
            }
        }
    }

    public void ingresarEmpleado () {
        Scanner scanner = vista.getScanner();

        boolean ejecucion = true;
        while (ejecucion) {
            vista.setMensajeConsola("\n¿Que empleado desea ingresar?");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 1) Empleado asalariado");
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
                vista.setMensajeConsola("Ingrese el número de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese el sueldo mensual del empleado: ");
                System.out.print(vista.getMensajeConsola());
                double sueldoMensual = scanner.nextDouble();
                scanner.nextLine();

                EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, sueldoMensual);
                empleadoAsalariado.setSueldo(empleadoAsalariado.calcularSueldo()); // Calcula el sueldo
                vista.setMensajeConsola("El sueldo del empleado es: " + empleadoAsalariado.calcularSueldo());
                System.out.println(vista.getMensajeConsola());
                listaEmpleadosAsalariados.add(empleadoAsalariado);
                guardarInfoEmpleadoAsalariado(listaEmpleadosAsalariados);
                mostrarEmpleadosAsalariados();


            } else if (opcion == 2) { //Empleado por hora
                vista.setMensajeConsola("Ingrese el número de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese el sueldo básico del empleado: ");
                System.out.print(vista.getMensajeConsola());
                double sueldoBasico = scanner.nextDouble();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese la cantidad de horas trabajadas por el empleado: ");
                System.out.print(vista.getMensajeConsola());
                int horasTrabajadas = scanner.nextInt();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el valor por hora: ");
                System.out.print(vista.getMensajeConsola());
                double valorPorHora = scanner.nextDouble();
                scanner.nextLine();

                EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, sueldoBasico, horasTrabajadas, valorPorHora);
                empleadoPorHora.setSueldo(empleadoPorHora.calcularSueldo()); // Calcula el sueldo
                vista.setMensajeConsola("El sueldo del empleado es: " + empleadoPorHora.calcularSueldo());
                System.out.println(vista.getMensajeConsola());
                listaEmpleadosPorHora.add(empleadoPorHora);
                guardarInfoEmpleadoPorHora(listaEmpleadosPorHora);
                mostrarEmpleadosPorHora ();


            } else if (opcion == 3) { //Empleado por comision
                vista.setMensajeConsola("Ingrese el número de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese la tasa de comisión: ");
                System.out.print(vista.getMensajeConsola());
                double tasaComision = scanner.nextDouble();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el monto total (pesos) de las ventas realizadas por el empleado: ");
                System.out.print(vista.getMensajeConsola());
                int ventas = scanner.nextInt();
                scanner.nextLine();

                EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, tasaComision, ventas);
                empleadoPorComision.setSueldo(empleadoPorComision.calcularSueldo()); // Calcula el sueldo
                vista.setMensajeConsola("El sueldo del empleado es: " + empleadoPorComision.calcularSueldo());
                System.out.println(vista.getMensajeConsola());
                listaEmpleadosPorComision.add(empleadoPorComision);
                guardarInfoEmpleadoPorComision(listaEmpleadosPorComision);
                mostrarEmpleadosPorComision();

            } else if (opcion == 4) { //Empleado base mas comision
                vista.setMensajeConsola("Ingrese el número de legajo del empleado: ");
                System.out.print(vista.getMensajeConsola());
                int numLegajo = scanner.nextInt();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el nombre del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String nombreEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese el apellido del empleado: ");
                System.out.print(vista.getMensajeConsola());
                String apellidoEmpleado = scanner.nextLine();

                vista.setMensajeConsola("Ingrese el sueldo base del empleado: ");
                System.out.print(vista.getMensajeConsola());
                double sueldoBase = scanner.nextDouble();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese la tasa de comisión: ");
                System.out.print(vista.getMensajeConsola());
                double tasaComision = scanner.nextDouble();
                scanner.nextLine();

                vista.setMensajeConsola("Ingrese el monto total (pesos) de las ventas realizadas por el empleado: ");
                System.out.print(vista.getMensajeConsola());
                int ventas = scanner.nextInt();
                scanner.nextLine();

                EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision(numLegajo, nombreEmpleado, apellidoEmpleado, listaEmpleados, sueldoBase, tasaComision, ventas);
                empleadoBaseMasComision.setSueldo(empleadoBaseMasComision.calcularSueldo()); // Calcula el sueldo
                vista.setMensajeConsola("El sueldo del empleado es: " + empleadoBaseMasComision.calcularSueldo());
                System.out.println(vista.getMensajeConsola());

                listaEmpleadosBaseMasComision.add(empleadoBaseMasComision);
                guardarInfoEmpleadoBasePorComision(listaEmpleadosBaseMasComision);
                mostrarEmpleadosBaseMasComision();

            } else if (opcion == 5) {
                ejecucion = false;
            }
        }
    }


    public void buscarDatos (){ //Buscar datos de un empleado"; //usando el legajo
        Scanner scanner = vista.getScanner();

        boolean ejecucion = true;
        while (ejecucion) {
            vista.setMensajeConsola("\n¿Que tipo de empleado desea buscar?");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 1) Empleado asalariado");
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

            if (opcion == 1) {
                ArrayList<EmpleadoAsalariado> conListaEmpleadosA = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();

                boolean encontrado = false;

                try{
                    ObjectMapper mapper = new ObjectMapper();
                    conListaEmpleadosA = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaAsalariado.json"), new TypeReference<>(){});
                    for (EmpleadoAsalariado e: conListaEmpleadosA){
                        if (e.getNumLegajo() == buscador){
                            vista.setMensajeConsola("El empleado encontrado con ese legajo es:");
                            System.out.println(vista.getMensajeConsola());
                            e.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un empleado con ese legajo.");
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcion == 2) {
                ArrayList<EmpleadoPorHora> conListaEmpleadosPH = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();

                boolean encontrado = false;

                try{
                    ObjectMapper mapper = new ObjectMapper();
                    conListaEmpleadosPH = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorHora.json"), new TypeReference<>(){});

                    for (EmpleadoPorHora e: conListaEmpleadosPH){
                        if (e.getNumLegajo() == buscador){
                            vista.setMensajeConsola("El empleado encontrado con ese legajo es:");
                            System.out.println(vista.getMensajeConsola());
                            e.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un empleado con ese legajo.");
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcion == 3) {
                ArrayList<EmpleadoPorComision> conListaEmpleadosPC = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();

                boolean encontrado = false;

                try{
                    ObjectMapper mapper = new ObjectMapper();
                    conListaEmpleadosPC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorComision.json"), new TypeReference<>(){});

                    for (EmpleadoPorComision e: conListaEmpleadosPC){
                        if (e.getNumLegajo() == buscador){
                            vista.setMensajeConsola("El empleado encontrado con ese legajo es:");
                            System.out.println(vista.getMensajeConsola());
                            e.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un empleado con ese legajo.");
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcion == 4) {
                ArrayList<EmpleadoBaseMasComision> conListaEmpleadosBMC = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();

                boolean encontrado = false;

                try{
                    ObjectMapper mapper = new ObjectMapper();
                    conListaEmpleadosBMC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaBasePorComision.json"), new TypeReference<>(){});

                    for (EmpleadoBaseMasComision e: conListaEmpleadosBMC){
                        if (e.getNumLegajo() == buscador){
                            vista.setMensajeConsola("El empleado encontrado con ese legajo es:");
                            System.out.println(vista.getMensajeConsola());
                            e.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un empleado con ese legajo.");
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcion == 5) {
                ejecucion = false;
            }

        }
    }

    public void eliminarEmpleado (){ //Buscar datos de un empleado"; //usando el legajo
        Scanner scanner = vista.getScanner();

        boolean ejecucion = true;
        while (ejecucion) {
            vista.setMensajeConsola("\n¿Que tipo de empleado desea eliminar?");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 1) Empleado asalariado");
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

            if (opcion == 1) {
                ArrayList<EmpleadoAsalariado> conListaEmpleadosA = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();
                eliminarEmpleadoAsalariado(buscador);

            } else if (opcion == 2) {
                ArrayList<EmpleadoPorHora> conListaEmpleadosPH = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();
                eliminarEmpleadoPorHora(buscador);

            } else if (opcion == 3) {
                ArrayList<EmpleadoPorComision> conListaEmpleadosPC = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();
                eliminarEmpleadoPorComision(buscador);

            } else if (opcion == 4) {
                ArrayList<EmpleadoBaseMasComision> conListaEmpleadosBMC = new ArrayList<>();
                vista.setMensajeConsola("Ingrese el número de legajo a buscar: ");
                System.out.print(vista.getMensajeConsola());
                int buscador = scanner.nextInt();
                eliminarEmpleadoBaseMasComision(buscador);

            } else if (opcion == 5) {
                ejecucion = false;
            }

        }
    }

    public void eliminarEmpleadoAsalariado(int legajoAEliminar) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<EmpleadoAsalariado> listaEmpleadosA = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaAsalariado.json"), new TypeReference<>(){});

            boolean eliminado = false;

            Iterator<EmpleadoAsalariado> iterator = listaEmpleadosA.iterator();
            while (iterator.hasNext()) {
                EmpleadoAsalariado empleado = iterator.next();
                if (empleado.getNumLegajo() == legajoAEliminar) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }

            if (eliminado) {
                mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaAsalariado.json"), listaEmpleadosA);
                System.out.println("Empleado asalariado eliminado correctamente.");
            } else {
                System.out.println("No se encontró un empleado asalariado con ese legajo.");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEmpleadoPorHora(int legajoAEliminar) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<EmpleadoPorHora> listaEmpleadosPH = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorHora.json"), new TypeReference<>(){});

            boolean eliminado = false;

            Iterator<EmpleadoPorHora> iterator = listaEmpleadosPH.iterator();
            while (iterator.hasNext()) {
                EmpleadoPorHora empleado = iterator.next();
                if (empleado.getNumLegajo() == legajoAEliminar) {
                    iterator.remove(); // Elimina el empleado de la lista
                    eliminado = true;
                    break;
                }
            }

            if (eliminado) {
                mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorHora.json"), listaEmpleadosPH);
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("No se encontró un empleado con ese legajo.");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEmpleadoPorComision(int legajoAEliminar) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<EmpleadoPorComision> listaEmpleadosPC = mapper.readValue(
                    new File("src/main/java/desafio2/assets/informacionGuardadaPorComision.json"),
                    new TypeReference<>(){}
            );

            boolean eliminado = false;

            Iterator<EmpleadoPorComision> iterator = listaEmpleadosPC.iterator();
            while (iterator.hasNext()) {
                EmpleadoPorComision empleado = iterator.next();
                if (empleado.getNumLegajo() == legajoAEliminar) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }

            if (eliminado) {
                mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorComision.json"), listaEmpleadosPC);
                System.out.println("Empleado por comisión eliminado correctamente.");
            } else {
                System.out.println("No se encontró un empleado por comisión con ese legajo.");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEmpleadoBaseMasComision(int legajoAEliminar) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<EmpleadoBaseMasComision> listaEmpleadosBMC = mapper.readValue(
                    new File("src/main/java/desafio2/assets/informacionGuardadaBasePorComision.json"),
                    new TypeReference<>(){}
            );

            boolean eliminado = false;

            Iterator<EmpleadoBaseMasComision> iterator = listaEmpleadosBMC.iterator();
            while (iterator.hasNext()) {
                EmpleadoBaseMasComision empleado = iterator.next();
                if (empleado.getNumLegajo() == legajoAEliminar) {
                    iterator.remove();
                    eliminado = true;
                    break;
                }
            }

            if (eliminado) {
                mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaBasePorComision.json"), listaEmpleadosBMC);
                System.out.println("Empleado base más comisión eliminado correctamente.");
            } else {
                System.out.println("No se encontró un empleado base más comisión con ese legajo.");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guardarInfo(ArrayList<Empleado> listaEmpleados){
        try{
            System.out.println("Info Saved");
            System.out.println(" ");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(listaEmpleados);
            mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardada.json"), listaEmpleados);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarTodosEmpleados(){
        vista.setMensajeConsola("\nLos empleados asalariados son:");
        System.out.println(vista.getMensajeConsola());
        mostrarEmpleadosAsalariados();
        vista.setMensajeConsola("\nLos empleados por hora son:");
        System.out.println(vista.getMensajeConsola());
        mostrarEmpleadosPorHora();
        vista.setMensajeConsola("\nLos empleados por comisión son:");
        System.out.println(vista.getMensajeConsola());
        mostrarEmpleadosPorComision();
        vista.setMensajeConsola("\nLos empleados base más comisión son:");
        System.out.println(vista.getMensajeConsola());
        mostrarEmpleadosBaseMasComision();
    }

    public void mostrarEmpleadosEspecificos(){
        Scanner scanner = vista.getScanner();

        boolean ejecucion = true;
        while (ejecucion) {
            vista.setMensajeConsola("\n¿Que tipo de empleado desea ver?");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 1) Empleado asalariado");
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

            if (opcion == 1) {
                vista.setMensajeConsola("\nLos empleados asalariados son:");
                System.out.println(vista.getMensajeConsola());
                mostrarEmpleadosAsalariados();
            } else if (opcion == 2) {
                vista.setMensajeConsola("\nLos empleados por hora son:");
                System.out.println(vista.getMensajeConsola());
                mostrarEmpleadosPorHora();
            } else if (opcion == 3) {
                vista.setMensajeConsola("\nLos empleados por comisión son:");
                System.out.println(vista.getMensajeConsola());
                mostrarEmpleadosPorComision();
            } else if (opcion == 4) {
                vista.setMensajeConsola("\nLos empleados base más comisión son:");
                System.out.println(vista.getMensajeConsola());
                mostrarEmpleadosBaseMasComision();
            } else if (opcion == 5) {
                ejecucion = false;
            }
        }
    }

    public void cantidadEmpleados(){
        ArrayList<EmpleadoAsalariado> conListaEmpleadosA = new ArrayList<>();
        ArrayList<EmpleadoPorHora> conListaEmpleadosPH = new ArrayList<>();
        ArrayList<EmpleadoPorComision> conListaEmpleadosPC = new ArrayList<>();
        ArrayList<EmpleadoBaseMasComision> conListaEmpleadosBMC = new ArrayList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();

            conListaEmpleadosA = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaAsalariado.json"), new TypeReference<>(){});
            conListaEmpleadosPH = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorHora.json"), new TypeReference<>(){});
            conListaEmpleadosPC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorComision.json"), new TypeReference<>(){});
            conListaEmpleadosBMC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaBasePorComision.json"), new TypeReference<>(){});

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int totalEmpleados = conListaEmpleadosA.size() +
                conListaEmpleadosPH.size() +
                conListaEmpleadosPC.size() +
                conListaEmpleadosBMC.size();

        vista.setMensajeConsola("Cantidad total de empleados: " + totalEmpleados);
        System.out.println(vista.getMensajeConsola());
    }



    public void cantidadEmpleadosEspecificos() {
        Scanner scanner = vista.getScanner();

        boolean ejecucion = true;
        while (ejecucion) {
            vista.setMensajeConsola("\n¿De que tipo de empleado desea calcular la cantidad?");
            System.out.println(vista.getMensajeConsola());
            vista.setMensajeConsola(" 1) Empleado asalariado");
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

            if (opcion == 1) {
                ArrayList<EmpleadoAsalariado> conListaEmpleadosA = new ArrayList<>();
                try{
                    ObjectMapper mapper = new ObjectMapper();

                    conListaEmpleadosA = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaAsalariado.json"), new TypeReference<>(){});
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                vista.setMensajeConsola("\nHay " + conListaEmpleadosA.size() + " empleado/s asalariados!");
                System.out.println(vista.getMensajeConsola());

            } else if (opcion == 2) {
                ArrayList<EmpleadoPorHora> conListaEmpleadosPH = new ArrayList<>();
                try{
                    ObjectMapper mapper = new ObjectMapper();

                    conListaEmpleadosPH = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorHora.json"), new TypeReference<>(){});
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                vista.setMensajeConsola("\nHay " + conListaEmpleadosPH.size() + " empleado/s por hora!");
                System.out.println(vista.getMensajeConsola());

            } else if (opcion == 3) {
                ArrayList<EmpleadoPorComision> conListaEmpleadosPC = new ArrayList<>();
                try{
                    ObjectMapper mapper = new ObjectMapper();

                    conListaEmpleadosPC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorComision.json"), new TypeReference<>(){});
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                vista.setMensajeConsola("\nHay " + conListaEmpleadosPC.size() + " empleado/s por comisión");
                System.out.println(vista.getMensajeConsola());

            } else if (opcion == 4) {
                ArrayList<EmpleadoBaseMasComision> conListaEmpleadosBMC = new ArrayList<>();
                try{
                    ObjectMapper mapper = new ObjectMapper();

                    conListaEmpleadosBMC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaBasePorComision.json"), new TypeReference<>(){});
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                vista.setMensajeConsola("\nHay " + conListaEmpleadosBMC.size() + " empleado/s base más comisión");
                System.out.println(vista.getMensajeConsola());
            } else if (opcion == 5) {
                ejecucion = false;
            }
        }
    }


    public void guardarInfoEmpleadoAsalariado(ArrayList<EmpleadoAsalariado> listaEmpleadosAsalariados){
        try{
            System.out.println("Info Saved");
            System.out.println(" ");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaAsalariado.json"), listaEmpleadosAsalariados);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarEmpleadosAsalariados (){
        ArrayList<EmpleadoAsalariado> mosListaEmpleadosA = new ArrayList<>();
        int contador = 1;

        try{
            ObjectMapper mapper = new ObjectMapper();

            mosListaEmpleadosA = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaAsalariado.json"), new TypeReference<>(){});
            for (Empleado empleado: mosListaEmpleadosA){
                vista.setMensajeConsola(" El empleado " + contador + " es:");
                System.out.println(vista.getMensajeConsola());
                empleado.mostrarInfo();
                contador +=1;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guardarInfoEmpleadoPorHora(ArrayList<EmpleadoPorHora> listaEmpleadosPorHora){
        try{
            System.out.println("Info Saved");
            System.out.println(" ");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorHora.json"), listaEmpleadosPorHora);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarEmpleadosPorHora (){
        ArrayList<EmpleadoPorHora> mosListaEmpleadosPH = new ArrayList<>();
        int contador = 1;

        try{
            ObjectMapper mapper = new ObjectMapper();

            mosListaEmpleadosPH = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorHora.json"), new TypeReference<>(){});
            for (Empleado empleado: mosListaEmpleadosPH){
                vista.setMensajeConsola(" El empleado " + contador + " es:");
                System.out.println(vista.getMensajeConsola());
                empleado.mostrarInfo();
                contador +=1;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void guardarInfoEmpleadoPorComision(ArrayList<EmpleadoPorComision> listaEmpleadosPorComision){
        try{
            System.out.println("Info Saved");
            System.out.println(" ");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorComision.json"), listaEmpleadosPorComision);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarEmpleadosPorComision (){
        ArrayList<EmpleadoPorComision> mosListaEmpleadosPC = new ArrayList<>();
        int contador = 1;

        try{
            ObjectMapper mapper = new ObjectMapper();

            mosListaEmpleadosPC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaPorComision.json"), new TypeReference<>(){});
            for (Empleado empleado: mosListaEmpleadosPC){
                vista.setMensajeConsola(" El empleado " + contador + " es:");
                System.out.println(vista.getMensajeConsola());
                empleado.mostrarInfo();
                contador +=1;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void guardarInfoEmpleadoBasePorComision(ArrayList<EmpleadoBaseMasComision> listaEmpleadosBaseMasComision){
        try{
            System.out.println("Info Saved");
            System.out.println(" ");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/java/desafio2/assets/informacionGuardadaBasePorComision.json"), listaEmpleadosBaseMasComision);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarEmpleadosBaseMasComision (){
        ArrayList<EmpleadoBaseMasComision> mosListaEmpleadosBMC = new ArrayList<>();
        int contador = 1;

        try{
            ObjectMapper mapper = new ObjectMapper();

            mosListaEmpleadosBMC = mapper.readValue(new File("src/main/java/desafio2/assets/informacionGuardadaBasePorComision.json"), new TypeReference<>(){});
            for (Empleado empleado: mosListaEmpleadosBMC){
                vista.setMensajeConsola(" El empleado " + contador + " es:");
                System.out.println(vista.getMensajeConsola());
                empleado.mostrarInfo();
                contador +=1;
            }
        } catch (IOException e) {
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
