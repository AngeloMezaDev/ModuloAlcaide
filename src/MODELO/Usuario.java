
package MODELO;

/**
 *
 * @author Yordan
 */
public class Usuario {
    private String cedula;
    private String Nombres;
    private String Apellidos;
    private String User;
    private String password;
    private String correo;
    public Usuario(String cedula,String Nombres, String Apellidos, String User, String password, String correo) {
        this.cedula=cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.User = User;
        this.password = password;
        this.correo = correo;
    }
    /*Getter y setters*/

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
