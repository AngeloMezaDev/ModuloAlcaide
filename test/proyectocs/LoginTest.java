package proyectocs;

import VISTAS.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testMain() {
        // Prueba 1: Credenciales correctas
        String[] args1 = {"Alcaide", "admin"};
        assertDoesNotThrow(() -> Login.main(args1));

        // Prueba 2: Credenciales incorrectas
        String[] args2 = {"Alcaide", "Admin"};
        assertDoesNotThrow(() -> Login.main(args2));

        // Prueba 3: Credenciales vacías
        String[] args3 = {"", ""};
        assertDoesNotThrow(() -> Login.main(args3));
    }
}
