package findspot.almac.myapplication.model;

import java.io.Serializable;

public class Mesa implements Serializable {

    private String id;
    private boolean ocupada;

    public Mesa(String id, boolean ocupada) {
        this.id = id;
        this.ocupada = ocupada;
    }

    public Mesa(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
