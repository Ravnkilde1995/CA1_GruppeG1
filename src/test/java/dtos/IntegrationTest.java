//package dtos;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Disabled;
//import utils.EMF_Creator;
//
//import javax.persistence.EntityManagerFactory;
//
//
//@Disabled
//public class IntegrationsTest {
//    private static EntityManagerFactory emf;
//
//
//    @BeforeAll
//    public static void setUpClass() {
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//        // This Cleans the database after tests is done or use a persistence unit with drop-and-create to start up with a clean database on every test.
//    }
//
//    // Setup the DataBase in a known state BEFORE EACH TEST (not needed if you use a clean database)
//    // TODO -- Make sure to change the code below to use YOUR OWN entity class
//    // @BeforeEach
// public void setUp() {
//     EntityManager em = emf.createEntityManager();
//     try {
//         em.getTransaction().begin();
//         em.createQueryName("DELETE From Address").executeUpdate();
//         em.createQueryName("DELETE From CityInfo").executeUpdate();
//         em.createQueryName("DELETE From Hobby").executeUpdate();
//         em.createQueryName("DELETE From HobbyPerson").executeUpdate();
//         em.createQueryName("DELETE From Person").executeUpdate();
//         em.getTransaction().commit();
//     } finally {
//         em.close();
//     }
// }
//
//     Private EntityManager getEntityManager() { return emf.createEntityManager(); }
//
// @Test
// public long getPersonCount() {
//
//     EntityManager em = getEntityManager();
//     try {
//
//         long personCount = (long) em.createQueryName("SELECT COUNT(r) FROM Person r").getSingleResult();
//         if (personCount < 3) {
//             System.out.println("the people count is more than 3");
//         } else if (personCount > 3) {
//             System.out.println("the people count is no more than 3");
//         }
//         return personCount;
//     } finally {
//         em.close();
//     }
// }
//
//}