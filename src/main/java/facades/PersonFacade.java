package facades;

import dtos.AddressDTO;
import entities.Address;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Rename Class to a relevant name Add add relevant facade methods
     */



    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = query.getResultList();

        return persons;
    }

    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where p.id = :id", Person.class);
        query.setParameter("id", id);
        Person person = query.getSingleResult();

        return person;
    }

    /**
     lav en adresse som string og et post nummer som int i Person klassen.
     Slet tabellerne i databasen, facade,dtos osv..

     put er tjekket igennem med postman, og der er hul igennem.
     - mangler bare formtag i frontend før det er sat ordentligt op..

     lad os lige breake opgaven ud i bidder i morgen, da vi nu er en 4 mands gruppe bliver vi nok nød til at udele
     arbejds opgaver.

     * få styr på fetch & AJAX - Jorg er tilrådighed på zoom.
     * få styr på databasen eventuelt med ny implimentering af overstående.
     * mangler edit metode i personFacade
     * mangler en del get metoder i  personFacade
     *
     *
     *
     *
     * tilføje hobbies (Tjek om vi overholder normalisering i databasen)
     * gøre os tanker om hvordan vi laver en search engine
     * lave tests på de metoder vi laver - så vi kan følge CI pipeline strukturen.

     **/

    public Person addPerson(String firstName, String lastName, String email) {
        EntityManager em = emf.createEntityManager();
        Person person = new Person(firstName, lastName, email);
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();

        return person;
    }

    /*
    public PersonDTO editPerson(int id) {
        EntityManager em = emf.createEntityManager();
    }*/


}
