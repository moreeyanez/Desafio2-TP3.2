package desafio2.Vista;

import java.util.Scanner;

public class VistaEmpleado {
    private String mensajeConsola;
    private Scanner campo;
    private boolean ejecutando;

    //Variable para usar de opcion
    private int opcion;

    //Inputs de clase padre
    private int numLegajoInput;
    private String nombreInput;
    private String apellidoInput;

    //Inputs de clases hijas
    private double sueldoMensualInput;

    private double sueldoBasicoInput;
    private int horasTrabajadasInput;
    private double valorPorHoraInput;

    private double tasaDeComisionInput;
    private int ventasInput;

    private double sueldoBaseInput;
    private double tasaComisionInput;
    private int numVentasInput;

    public VistaEmpleado(){
        campo = new Scanner(System.in);
        ejecutando = true;
        mensajeConsola = "";

        numLegajoInput = 0;
        nombreInput = "";
        apellidoInput = "";

        sueldoMensualInput = 0d;

        sueldoBasicoInput = 0d;
        horasTrabajadasInput = 0;
        valorPorHoraInput = 0d;

        tasaDeComisionInput = 0d;
        ventasInput = 0;

        sueldoBaseInput = 0d;
        tasaComisionInput = 0d;
        numVentasInput = 0;
    }

    public void mostrarVista(){
        mensajeConsola = "\n----Bienvenido----";
        System.out.println(mensajeConsola);
        System.out.println("##################");

        mensajeConsola = "----MENÚ----";
        System.out.println(mensajeConsola);
        mensajeConsola = " 1) Ingresar un empleado para calcular su sueldo";
        System.out.println(mensajeConsola);
        mensajeConsola = " 2) Buscar datos de un empleado"; //usando el legajo
        System.out.println(mensajeConsola);
        mensajeConsola = " 3) Modificar datos de un empleado";
        System.out.println(mensajeConsola);
        mensajeConsola = " 4) Eliminar un empleado";
        System.out.println(mensajeConsola);
        mensajeConsola = " 5) Cantidad total de empleados";
        System.out.println(mensajeConsola);
        mensajeConsola = " 6) Cantidad de empleados X";
        System.out.println(mensajeConsola);
        mensajeConsola = " 7) Mostrar lista de empleados x";
        System.out.println(mensajeConsola);
        mensajeConsola = " 8) Mostrar lista de empleados";
        System.out.println(mensajeConsola);
        mensajeConsola = " 9) Salir";
        System.out.println(mensajeConsola);

        mensajeConsola = "Elija una opción del menú:";
        System.out.println(mensajeConsola);
    }

    public String getMensajeConsola() {
        return mensajeConsola;
    }

    public void setMensajeConsola(String mensajeConsola) {
        this.mensajeConsola = mensajeConsola;
    }

    public Scanner getScanner() {
        return campo;
    }

    public void setScanner(Scanner campo) {
        this.campo = campo;
    }

    public boolean getEjecutando() {
        return ejecutando;
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int getNumLegajoInput() {
        return numLegajoInput;
    }

    public void setNumLegajoInput(int numLegajoInput) {
        this.numLegajoInput = numLegajoInput;
    }

    public String getNombreInput() {
        return nombreInput;
    }

    public void setNombreInput(String nombreInput) {
        this.nombreInput = nombreInput;
    }

    public String getApellidoInput() {
        return apellidoInput;
    }

    public void setApellidoInput(String apellidoInput) {
        this.apellidoInput = apellidoInput;
    }

    public double getSueldoMensualInput() {
        return sueldoMensualInput;
    }

    public void setSueldoMensualInput(double sueldoMensualInput) {
        this.sueldoMensualInput = sueldoMensualInput;
    }

    public double getSueldoBasicoInput() {
        return sueldoBasicoInput;
    }

    public void setSueldoBasicoInput(double sueldoBasicoInput) {
        this.sueldoBasicoInput = sueldoBasicoInput;
    }

    public int getHorasTrabajadasInput() {
        return horasTrabajadasInput;
    }

    public void setHorasTrabajadasInput(int horasTrabajadasInput) {
        this.horasTrabajadasInput = horasTrabajadasInput;
    }

    public double getValorPorHoraInput() {
        return valorPorHoraInput;
    }

    public void setValorPorHoraInput(double valorPorHoraInput) {
        this.valorPorHoraInput = valorPorHoraInput;
    }

    public double getTasaDeComisionInput() {
        return tasaDeComisionInput;
    }

    public void setTasaDeComisionInput(double tasaDeComisionInput) {
        this.tasaDeComisionInput = tasaDeComisionInput;
    }

    public int getVentasInput() {
        return ventasInput;
    }

    public void setVentasInput(int ventasInput) {
        this.ventasInput = ventasInput;
    }

    public double getSueldoBaseInput() {
        return sueldoBaseInput;
    }

    public void setSueldoBaseInput(double sueldoBaseInput) {
        this.sueldoBaseInput = sueldoBaseInput;
    }

    public double getTasaComisionInput() {
        return tasaComisionInput;
    }

    public void setTasaComisionInput(double tasaComisionInput) {
        this.tasaComisionInput = tasaComisionInput;
    }

    public int getNumVentasInput() {
        return numVentasInput;
    }

    public void setNumVentasInput(int numVentasInput) {
        this.numVentasInput = numVentasInput;
    }
}
