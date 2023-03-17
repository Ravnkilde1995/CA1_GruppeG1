package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HobbyDTO;
import entities.Hobby;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class HobbyFacade {
    private static HobbyFacade instance;
    private static EntityManagerFactory emf;

    // Private Constructor to ensure Singleton
    private HobbyFacade() {}

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */

    public static HobbyFacade getHobbyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<HobbyDTO> getAllHobbies() {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Hobby> query = em.createQuery("SELECT h FROM Hobby h", Hobby.class);
            List<Hobby> hs = query.getResultList();
            em.close();
        return HobbyDTO.getDtos(hs);
    }

    public HobbyDTO getById(long id) {
        EntityManager em = emf.createEntityManager();
        Hobby hobby = em.find(Hobby.class, id);
        System.out.println("idIsNotNull2: " + id);
        return new HobbyDTO(hobby);
    }

    public HobbyDTO createHobby(HobbyDTO hdto) {
        Hobby hobby = new Hobby(hdto.getId(), hdto.getName(), hdto.getDescription(), hdto.getCategory());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HobbyDTO(hobby);
    }

    // Update Hobby
    public HobbyDTO updateHobby(long id,HobbyDTO hdto) {
        EntityManager em = emf.createEntityManager();
        Hobby hobby = em.find(Hobby.class, id);
        System.out.println("updateHobby: " +hobby);
        System.out.println("idIsNotNull: " + id);
        hobby.setName(hdto.getName());
        hobby.setDescription(hdto.getDescription());
        hobby.setCategory(hdto.getCategory());

        try {
            em.getTransaction().begin();
            em.merge(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HobbyDTO(hobby);
    }


    public long getHobbyCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long hobbyCount = (long) em.createQuery("SELECT COUNT(h) FROM Hobby h").getSingleResult();
            return hobbyCount;
        } finally {
            em.close();
        }
    }



    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        HobbyFacade facade = HobbyFacade.getHobbyFacade(emf);
        HobbyDTO h1 = new HobbyDTO("Fodbold", "Spille fodbold", "Sport");
        HobbyDTO h2 = new HobbyDTO("Basket", "Spille basket", "Sport");
    }


}
