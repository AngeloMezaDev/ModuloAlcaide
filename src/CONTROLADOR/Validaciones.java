/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Yordan
 */
public class Validaciones {
    //Método para validar usuarios

    public String validarNombreUsuario(String nombre) {
        // Verificar que el nombre de usuario no exceda el límite de 12 caracteres
        if (nombre.length() > 12) {
            JOptionPane.showMessageDialog(null,
                    "El nombre de usuario excede el límite de 12 caracteres.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return ""; // Detener el evento o la función si el nombre es demasiado largo
        }
        // Verificar que el nombre de usuario tenga al menos 8 caracteres
        if (nombre.length() < 8) {
            JOptionPane.showMessageDialog(null,
                    "El nombre de usuario debe tener al menos 8 caracteres.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return ""; // Detener el evento o la función si el nombre es demasiado corto
        }
        return nombre;
    }
    // Método para validar que solo se ingresen letras

    public void validarSoloLetras(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != ' ') {
            evt.consume();
            // Mostrar un JOptionPane informativo.
            JOptionPane.showMessageDialog(null,
                    "Solo se permiten letras y espacios, no ingrese símbolos ni números.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para validar que solo se ingresen números y un máximo de 10 dígitos
    public void validarCedula(KeyEvent evt, String cedula) {
        char c = evt.getKeyChar();
        // Verificar si la tecla presionada es un número y si ya hay 10 dígitos en el campo.
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE || cedula.length() >= 10) {
            evt.consume();
            // Mostrar un JOptionPane informativo.
            JOptionPane.showMessageDialog(null,
                    "Solo se permiten números y máximo 10 dígitos.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public Date ValidarFecha(Date fecha) {
        Calendar calFechaNacimiento = Calendar.getInstance();
        calFechaNacimiento.setTime(fecha);

        // Calcular la fecha mínima permitida (18 años después de la fecha actual)
        Calendar calFechaMinima = Calendar.getInstance();
        calFechaMinima.add(Calendar.YEAR, -18);

        // Verificar si la fecha de nacimiento es mayor a 18 años
        if (calFechaNacimiento.before(calFechaMinima)) {
            return null;
        }

        // Si la fecha es válida, retornarla
        return fecha;
    }

    // Método para validar que la contraseña cumpla con ciertas condiciones
    public String validadContrasena(String contrasena) {
        // Verificar que la contraseña tenga al menos 8 caracteres
        if (contrasena.length() < 8) {
            JOptionPane.showMessageDialog(null,
                    "La contraseña debe tener al menos 8 caracteres.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }

        // Verificar que la contraseña contenga al menos una letra y un número
        boolean contieneLetra = false;
        boolean contieneNumero = false;
        for (char c : contrasena.toCharArray()) {
            if (Character.isLetter(c)) {
                contieneLetra = true;
            } else if (Character.isDigit(c)) {
                contieneNumero = true;
            }

            if (contieneLetra && contieneNumero) {
                break; // Ya se cumple con las condiciones, no es necesario seguir buscando
            }
        }

        if (!contieneLetra || !contieneNumero) {
            JOptionPane.showMessageDialog(null,
                    "La contraseña debe contener al menos una letra y un número.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
        return contrasena;
    }

    // Método para validar correos electrónicos utilizando una expresión regular
    public String validarCorreoElectronico(String correo) {
        // Expresión regular para validar correos electrónicos
        String patronCorreo = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        // Compilar la expresión regular en un objeto Pattern
        Pattern pattern = Pattern.compile(patronCorreo);
        // Crear un objeto Matcher para comparar el correo con el patrón
        Matcher matcher = pattern.matcher(correo);
        // Verificar si el correo coincide con el patrón
        if (matcher.matches()) {
            return correo;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Correo Electronico Invalido. Ingrese un correo valido.",
                    "Advertencia: Correo Invalido",
                    JOptionPane.WARNING_MESSAGE);
            return ""; // Si el correo no es válido, se retorna una cadena vacía
        }
    }

}
