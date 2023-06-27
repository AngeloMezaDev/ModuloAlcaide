package VISTAS;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginTest {

    @Test
    public void testValidarAdmin() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Login login = new Login();

        Method method = Login.class.getDeclaredMethod("validarAdmin", String.class, String.class);
        method.setAccessible(true);

        try {
            // Caso de prueba: usuario y contraseña válidos para el administrador
            method.invoke(login, "Alcaide", "admin");
            // Si no se lanza ninguna excepción, la prueba pasa
            Assert.assertTrue(true);
        } catch (Exception e) {
            // Si se lanza una excepción, la prueba falla
            Assert.fail("Error: " + e.getMessage());
        }
    }
}
