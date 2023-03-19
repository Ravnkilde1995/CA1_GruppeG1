package facades;

import dtos.PersonDTO;
import entities.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonFacadeTest {

   /* private static EntityManagerFactory emf;
    private static PersonFacade facade;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = PersonFacade.getPersonFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(new Person("email", "firstname", "lastname", 232323, 1));
            em.persist(new Person("e@e.com", "ole", "Thomsen", 23232323, 1));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method
    @Test
    public void testAFacadeMethod() throws Exception {
        assertEquals(5, facade.getPersonCount(), "Expects five rows in the database");
    }


}*/

    /*
    private EntityManagerFactory emf;
    private PersonDTO personDTO;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test");
        PersonDTO pd = new PersonDTO((Person) emf);
    }

    @After
    public void tearDown() {
        // delete the object created when test is finished

        emf.close();
    }

    @Test
    public void testGetPerson(int id) {
        // insert a new person into the database
        Person p = new Person("John@doe.com", "John", "Doe", 23,1);
        PersonFacade.getPerson(id);

        // retrieve the person by ID
        Person result = PersonFacade.getPerson(p.getId());

        // verify that the retrieved person matches the inserted person
        assertNotNull(result);
        assertEquals(p.getId(), result.getId());
        assertEquals(p.getFirstName(), result.getLastName());
    }*/

}
