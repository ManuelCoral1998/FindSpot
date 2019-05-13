package findspot.almac.myapplication.model;

public class Usuario {

    private String nombreUsuario;
    private String carrera;
    private String correo;
    private String contrasenha;

    public Usuario(String nombreUsuario, String carrera, String correo, String contrasenha) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.carrera = carrera;
        this.contrasenha = contrasenha;
    }

    public Usuario () {}

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
}
