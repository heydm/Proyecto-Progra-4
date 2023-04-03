package proyecto.progra.resources.logic;

public class Cliente {
    String cedula;
    String nombre;
    Usuario usuario;
    Tarjeta tarjeta;
    String telefono;
    String correo;

    public Cliente(String cedula, String nombre, Usuario usuario, Tarjeta tarjeta, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.tarjeta = tarjeta;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }   
}