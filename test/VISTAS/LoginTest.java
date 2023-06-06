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

        // Caso de prueba 1: usuario y contraseña válidos para el administrador
        boolean resultado = (boolean) method.invoke(login, "Alcaide", "admin");
        Assert.assertTrue(resultado);

        // Caso de prueba 2: usuario válido y contraseña incorrecta para el administrador
        resultado = (boolean) method.invoke(login, "admin", "contraseñaIncorrecta");
        Assert.assertFalse(resultado);

        // Caso de prueba 3: usuario y contraseña incorrectos para el administrador
        resultado = (boolean) method.invoke(login, "usuarioIncorrecto", "contraseñaIncorrecta");
        Assert.assertFalse(resultado);
    }

    @Test
    public void testValidarProfesores() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Login login = new Login();

        Method method = Login.class.getDeclaredMethod("validarProfesores", String.class, String.class);
        method.setAccessible(true);

        // Caso de prueba 1: usuario y contraseña válidos para el profesor
        boolean resultado = (boolean) method.invoke(login, "Profesor", "profesor");
        Assert.assertTrue(resultado);

        // Caso de prueba 2: usuario válido y contraseña incorrecta para el profesor
        resultado = (boolean) method.invoke(login, "Profesor", "contraseñaIncorrecta");
        Assert.assertFalse(resultado);

        // Caso de prueba 3: usuario y contraseña incorrectos para el profesor
        resultado = (boolean) method.invoke(login, "usuarioIncorrecto", "contraseñaIncorrecta");
        Assert.assertFalse(resultado);
    }

    @Test
    public void testValidarReclusos() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Login login = new Login();

        Method method = Login.class.getDeclaredMethod("validarReclusos", String.class, String.class);
        method.setAccessible(true);

        // Caso de prueba 1: usuario y contraseña válidos para el recluso
        boolean resultado = (boolean) method.invoke(login, "Recluso", "recluso");
        Assert.assertTrue(resultado);

        // Caso de prueba 2: usuario válido y contraseña incorrecta para el recluso
        resultado = (boolean) method.invoke(login, "Recluso", "contraseñaIncorrecta");
        Assert.assertFalse(resultado);

        // Caso de prueba 3: usuario y contraseña incorrectos para el recluso
        resultado = (boolean) method.invoke(login, "usuarioIncorrecto", "contraseñaIncorrecta");
        Assert.assertFalse(resultado);
    }
}
