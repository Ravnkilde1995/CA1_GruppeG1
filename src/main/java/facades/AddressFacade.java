package facades;

import entities.Address;

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

    public Address addAddress(String street, int streetNumber, String floor, int idCityInfo) {
        EntityManager em = emf.createEntityManager();
        Address address = new Address(street, streetNumber, floor, idCityInfo);
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        em.close();

        return address;
    }


    public Address editAddress(int id, String street, int streetNumber, String floor, int idCityInfo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address address = em.find(Address.class, id);
        address.setStreet(street);
        address.setStreetNumber(streetNumber);
        address.setFloor(floor);
        // address.setIdCityInfo(idCityInfo);
        em.getTransaction().commit();
        em.close();

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


    public Address editPerson(Integer id) {
        EntityManager entityManager;
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Address address = entityManager.find(Address.class, id);
        System.out.println("person id :: " + address.getId());
        System.out.println("street :: " + address.getStreet());
        System.out.println("street number :: " + address.getStreetNumber());
        System.out.println("street floor :: " + address.getFloor());
        System.out.println("street cityinfo :: " + address.getIdCityInfo());

        address.setStreet("ole");
        address.setStreetNumber(2);
        address.setFloor("3th");
        // address.setIdCityInfo(1);
        entityManager.getTransaction().commit();
        entityManager.close();

        return address;
    }
}
