package CRUDService;

import Entities.Client;
import org.hibernate.Session;
import Util.HibernateUtil;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {
    public Client getClientById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            return session.get(Client.class, id);
        }
    }

    public Client createClient(String name) {
        Client client = new Client();
        client.setName(name);

        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
        return client;
    }

    public void deleteClientById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            transaction.commit();
        }
    }

    public void UpdateById(int id, String newName) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            client.setName(newName);
            session.merge(client);
            transaction.commit();
        }
    }

    public List<Client> getClientList() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            return session.createQuery("from Client", Client.class).list();
        }
    }
}
