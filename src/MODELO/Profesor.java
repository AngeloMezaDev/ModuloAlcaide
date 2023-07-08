package MODELO;

/**
 *
 * @author Yordan valdiviezo
 */
public class Profesor extends Usuario {

    private String CodigoProfesor;
    private String especialidad;
    private int añosExperiencia;

    public Profesor(String CodigoProfesor, String especialidad, int añosExperiencia, String cedula, String Nombres, String Apellidos, String User, String password, String correo) {
        super(cedula, Nombres, Apellidos, User, password, correo);
        this.CodigoProfesor = CodigoProfesor;
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }


    // Getters y setters específicos de la clase Profesor
    public String GenerarIdProfesor(String cedula) {
        String id = "";
        //concaternar #P´+ 4 ultimos digitos de cedula
        id = ("#P" + cedula.substring(cedula.length() - 4));
        return id;
    }

    public String getCodigoProfesor() {
        return CodigoProfesor;
    }

    public void setCodigoProfesor(String CodigoProfesor) {
        this.CodigoProfesor = CodigoProfesor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    // Otros métodos específicos de la clase Profesor
}
