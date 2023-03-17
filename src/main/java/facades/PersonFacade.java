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
    // tag id med fra resuresen
    // tag parametre med til a sette de nye attributer.
    public Person editPerson(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class, id);
        System.out.println("person id :: " + person.getId());
        System.out.println("person firstname :: " + person.getFirstName());
        System.out.println("person lastname :: " + person.getLastName());
        System.out.println("person email :: " + person.getEmail());
        System.out.println("person phoneNumber :: " + person.getPhoneNumber());
        //System.out.println("person adress :: " + person.getIdAddress());

        // The entity object is physically updated in the database when the transaction
        // is committed
        person.setFirstName("ole");
        person.setLastName("lukøje");
        person.setEmail("nat@nat.dk");
        person.setPhoneNumber(29292929);
        person.setIdAddress(1);
        entityManager.getTransaction().commit();
        entityManager.close();

        return person;
    }


}
