package findspot.almac.myapplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Edificio implements Serializable{

    private String nombreEdificio;
    private int cantidadMesas;
    private int cantidadMesasDisponibles;
    private int cantidadPisos;
    private ArrayList<Piso> pisos;

    public Edificio(String nombreEdifico, int cantidadMesas, int cantidadMesasDisponibles, int cantidadPisos, ArrayList<Piso> pisos) {
        this.nombreEdificio = nombreEdifico;
        this.cantidadMesas = cantidadMesas;
        this.cantidadMesasDisponibles = cantidadMesasDisponibles;
        this.cantidadPisos = cantidadPisos;
        this.pisos = pisos;
    }

    public void cambiarDatos (int posPiso, int posMesa) {

        if (pisos.get(posPiso).getMesas().get(posMesa).isOcupada()) {
            cantidadMesasDisponibles++;
        } else {
            cantidadMesasDisponibles--;
        }

        pisos.get(posPiso).cambiarDatos(posMesa);

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

    public ArrayList<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(ArrayList<Piso> pisos) {
        this.pisos = pisos;
    }
}
