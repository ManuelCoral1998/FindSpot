package findspot.almac.myapplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Piso implements Serializable {

    private String nombrePiso;
    private ArrayList<Mesa> mesas;
    private int mesasDisponibles;

    public Piso(String nombrePiso, ArrayList<Mesa> mesas, int mesasDisponibles) {
        this.nombrePiso = nombrePiso;
        this.mesas = mesas;
        this.mesasDisponibles = mesasDisponibles;
    }

    public void cambiarDatos(int posMesa) {

        if (mesas.get(posMesa).isOcupada()) {
            mesasDisponibles++;
        } else {
            mesasDisponibles--;
        }

        mesas.get(posMesa).cambiarValores();
    }

    public  Piso(){}

    public String getNombrePiso() {
        return nombrePiso;
    }

    public void setNombrePiso(String nombrePiso) {
        this.nombrePiso = nombrePiso;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public int getMesasDisponibles() {
        return mesasDisponibles;
    }

    public void setMesasDisponibles(int mesasDisponibles) {
        this.mesasDisponibles = mesasDisponibles;
    }
}
