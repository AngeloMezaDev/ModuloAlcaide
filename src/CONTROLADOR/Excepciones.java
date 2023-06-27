package CONTROLADOR;

/**
 *
 * @author Angelo Meza
 */
/**
 * Clase que define las excepciones personalizadas para el sistema de inicio de
 * sesión.
 */
public class Excepciones {

    /**
     * Excepción lanzada cuando el usuario no existe en el sistema.
     */
    public static class UsuarioNoExistenteException extends Exception {

        public UsuarioNoExistenteException(String message) {
            super(message);
        }
    }

    /**
     * Excepción lanzada cuando las credenciales ingresadas son inválidas.
     */
    public static class CredencialesInvalidasException extends Exception {

        public CredencialesInvalidasException(String message) {
            super(message);
        }
    }

    /**
     * Excepción lanzada cuando la cuenta ha sido bloqueada por exceder el
     * número máximo de intentos fallidos.
     */
    public static class CuentaBloqueadaException extends Exception {

        public CuentaBloqueadaException(String message) {
            super(message);
        }
    }
}
