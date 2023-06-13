/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MODELO;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;

/**
 *
 * @author Angelo Meza
 */
public class ConnectionBDTest {

    private ConnectionBD connectionBD;

    @Before
    public void setUp() {
        connectionBD = new ConnectionBD();
    }

    @After
    public void tearDown() {
        try {
            connectionBD.closeConnection();
        } catch (SQLException e) {
            fail("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    @Test 
    public void testOpenConnection() {
        System.out.println("Prueba de apertura de conexión");
        try {
            connectionBD.openConnection();
            assertNotNull("La conexión no debe ser nula", connectionBD.getConnection());
            System.out.println("Conexión establecida exitosamente");
        } catch (SQLException | ClassNotFoundException e) {
            fail("Error al abrir la conexión: " + e.getMessage());
        }
    }

}
