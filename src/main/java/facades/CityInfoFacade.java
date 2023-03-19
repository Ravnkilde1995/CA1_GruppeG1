package facades;

import entities.CityInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CityInfoFacade {

    private static CityInfoFacade instance;
    private static EntityManagerFactory emf;

    public static CityInfoFacade getCityInfoFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CityInfoFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getCityInfoCount(){
        EntityManager em = getEntityManager();
        try {
            long cityInfoCount = (long) em.createQuery("SELECT COUNT(r) FROM CityInfo r ").getSingleResult();
            System.out.println(cityInfoCount);
            return cityInfoCount;
        } finally {
            em.close();
        }
    }

    public CityInfo getCityInfoById(int id) {
        EntityManager em = emf.createEntityManager();
        CityInfo cityInfo = em.find(CityInfo.class, id);
        return cityInfo;
    }
}
