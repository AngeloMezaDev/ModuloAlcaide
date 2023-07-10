package MODELO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    private Date fechaNacimiento;

    public Usuario(String cedula, String Nombres, String Apellidos, String User, String password, String correo, Date fechaNacimiento) {
        this.cedula = cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.User = User;
        this.password = password;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int CalcularEdad(Date fechaNac) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(new SimpleDateFormat("dd/MM/yyyy").format(fechaNac), fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, ahora);

        return periodo.getYears();
    }
}

