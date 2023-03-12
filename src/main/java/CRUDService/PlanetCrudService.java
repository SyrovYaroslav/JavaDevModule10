package CRUDService;

import Entities.Planet;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    public Planet getPlanetById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            return session.get(Planet.class, id);
        }
    }

    public Planet createPlanet(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);

        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
        return planet;
    }

    public void deletePlanetById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            session.remove(planet);
            transaction.commit();
        }
    }

    public void UpdatePlanetById(String id, String newName) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            planet.setName(newName);
            session.merge(planet);
            transaction.commit();
        }
    }

    public List<Planet> getPlanetList() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}
