package facades;

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

    public Person addPerson(String firstName, String lastName, String email , int phoneNumber,  int idAddress) {
        EntityManager em = emf.createEntityManager();
        Person person = new Person(firstName, lastName, email, phoneNumber, idAddress);
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();

        return person;
    }

    public Person updatePerson(Integer id, String firstName, String lastName, String email , int phoneNumber,  int idAddress) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPhoneNumber(phoneNumber);
        person.setIdAddress(idAddress);

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();

        return person;
    }
}
