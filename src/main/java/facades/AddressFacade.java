package facades;

import entities.Address;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressFacade {

    private static AddressFacade instance;
    private static EntityManagerFactory emf;

    public static AddressFacade getAddressFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AddressFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Address> getAllAddresses() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Address> query = em.createQuery("SELECT p FROM Address p", Address.class);
        List<Address> addresses = query.getResultList();

        return addresses;
    }


    public Address getAddress(int id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Address> query = em.createQuery("SELECT p FROM Address p where p.id = :id", Address.class);
        query.setParameter("id", id);
        Address address = query.getSingleResult();

        return address;
    }


    public Address deleteAddress(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address address = em.find(Address.class, id);
        em.remove(address);
        em.getTransaction().commit();
        em.close();

        return address;
    }

    public Address addAddress(String street, int streetNumber, String floor, CityInfo cityInfo) {
        EntityManager em = emf.createEntityManager();
        Address address = new Address(street, streetNumber, floor, cityInfo);
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        em.close();

        return address;
    }

    public Address updateAddress(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address address = em.find(Address.class, 1);
        address.setStreet("tester lige om det her virker");
        em.getTransaction().commit();
        em.close();

        return address;
    }


    public Person getAddressByPerson(String firstname, String lastName) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where p.firstName = :firstName AND p.lastName = :lastName", Person.class);
        query.setParameter("firstName", firstname);
        query.setParameter("lastName", lastName);
        Person person = query.getSingleResult();

        return person;
    }

    public Address getAddressByCity(int city) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Address> query = em.createQuery("SELECT p FROM Address p where p.idCityInfo = :city", Address.class);
        query.setParameter("city", city);
        Address address = query.getSingleResult();

        return address;
    }

    public Person createPersonWithAddress(String email, String firstName, String lastName, int phoneNumber, Address address) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person(email, firstName, lastName, phoneNumber, address);
        em.persist(person);
        em.getTransaction().commit();
        em.close();

        return person;
    }


    public CityInfo createCityInfo(String city, int zipCode) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CityInfo cityInfo = new CityInfo(city, zipCode);
        em.persist(cityInfo);
        em.getTransaction().commit();
        em.close();

        return cityInfo;
    }
}
