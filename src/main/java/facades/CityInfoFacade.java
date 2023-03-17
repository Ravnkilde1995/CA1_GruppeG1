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

//    public CityInfo getCityInfoById(int id) {
//        EntityManager em = emf.createEntityManager();
//        CityInfo cityInfo = em.find(CityInfo.class, id);
//        return cityInfo;
//    }
//
//    public CityInfo getCityInfoByCity(String city) {
//        EntityManager em = emf.createEntityManager();
//        CityInfo cityInfo = em.find(CityInfo.class, city);
//        return cityInfo;
//    }
//
//    public CityInfo addCityInfo(int id, String city, int zipCode) {
//        EntityManager em = emf.createEntityManager();
//        CityInfo cityInfo = new CityInfo(id, city, zipCode);
//        em.getTransaction().begin();
//        em.persist(cityInfo);
//        em.getTransaction().commit();
//        em.close();
//
//        return cityInfo;
//    }
//
//    public CityInfo deleteCityInfo(int id) {
//        EntityManager em = emf.createEntityManager();
//        CityInfo cityInfo = em.find(CityInfo.class, id);
//        em.getTransaction().begin();
//        em.remove(cityInfo);
//        em.getTransaction().commit();
//        em.close();
//        return cityInfo;
//    }
//
//    public CityInfo editCityInfo(int id, String city, int zipCode) {
//        EntityManager em = emf.createEntityManager();
//        CityInfo cityInfo = em.find(CityInfo.class, id);
//        cityInfo.setCity(city);
//        em.getTransaction().begin();
//        em.persist(cityInfo);
//        em.getTransaction().commit();
//        em.close();
//        return cityInfo;
//    }

}
