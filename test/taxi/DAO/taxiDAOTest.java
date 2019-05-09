/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import taxi.metier.taxi;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michel
 */
public class taxiDAOTest {

    static Connection dbConnect;

    public taxiDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

    }

    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class taxiDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        taxi obj = new taxi(0, "TestImmatriculation", "TestCarburant", 25, "TestDescription");
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        taxi expResult = obj;
        taxi result = instance.create(obj);

        assertEquals("immatriculations différentes", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("prix au km différents", expResult.getPrixkm(), result.getPrixkm(),0);
        
        assertEquals("id non généré", expResult.getIdtaxi(), result.getIdtaxi());
        int idtaxi = result.getIdtaxi();
        obj = new taxi(0, "TestImmatriculation", "TestCarburant", 25, "TestDescription2");
        try {
            taxi result2 = instance.create(obj);
            fail("exception de doublon non déclenchée");
            instance.delete(result2);
        } catch (SQLException e) {
        }
        instance.delete(result);

    }

    /**
     * Test of read method, of class taxiDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idtaxi = 0;
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        taxi obj = new taxi(0, "TestImmatriculation", "TestCarburant", 25, "TestDescription");
        taxi expResult = instance.create(obj);
        idtaxi = expResult.getIdtaxi();
        taxi result = instance.read(idtaxi);
        assertEquals("immatriculations différentes", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("prix au km différents", expResult.getPrixkm(), result.getPrixkm(),0);
        
        assertEquals("id différents", expResult.getIdtaxi(), result.getIdtaxi());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class taxiDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        taxi obj = new taxi(0, "TestImmatriculation", "TestCarburant", 25, "TestDescription");
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setImmatriculation("TestImmatriculation2");
        
        obj.setCarburant("TestCarburant2");
       
        taxi expResult = obj;
        taxi result = instance.update(obj);
        assertEquals(toUpperCase(expResult.getImmatriculation()), toUpperCase(result.getImmatriculation()));
        
        assertEquals(expResult.getCarburant(), result.getCarburant());

        instance.delete(obj);

    }

    /**
     * Test of delete method, of class taxiDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        taxi obj = new taxi(0, "TestImmatriculation", "TestCarburant", 25, "TestDescription");
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdtaxi());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        
    }

    /**
     * Test of rechDesc method, of class taxiDAO.
     */
    @Test
    public void testRechDesc() throws Exception {
        System.out.println("rechDesc");
        taxi obj1 = new taxi(0, "TestImmatriculation", "TestCarburant", 25, "TestDescription");
        taxi obj2 = new taxi(0, "TestImmatriculation2", "TestCarburant2", 40, "TestDescription");
        String descrech = "TestDescription";
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);

        List<taxi> result = instance.rechDesc(descrech);
        if (result.indexOf(obj1) < 0) {
            fail("record introuvable " + obj1);
        }
        if (result.indexOf(obj2) < 0) {
            fail("record introuvable" + obj2);
        }
        instance.delete(obj1);
        instance.delete(obj2);
    }

}
