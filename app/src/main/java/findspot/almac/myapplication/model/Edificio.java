package findspot.almac.myapplication.model;

public class Edificio {

    private String nombreEdificio;
    private int cantidadMesas;
    private int cantidadMesasDisponibles;
    private int cantidadPisos;


    public Edificio(String nombreEdifico, int cantidadMesas, int logoEdifico, int cantidadPisos) {
        this.nombreEdificio = nombreEdifico;
        this.cantidadMesas = cantidadMesas;
        this.cantidadMesasDisponibles = logoEdifico;
        this.cantidadPisos = cantidadPisos;
    }

    public Edificio() {}

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public int getCantidadMesas() {
        return cantidadMesas;
    }

    public void setCantidadMesas(int cantidadMesas) {
        this.cantidadMesas = cantidadMesas;
    }

    public int getCantidadMesasDisponibles() {
        return cantidadMesasDisponibles;
    }

    public void setCantidadMesasDisponibles(int logoEdifico) {
        this.cantidadMesasDisponibles = logoEdifico;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }
}
