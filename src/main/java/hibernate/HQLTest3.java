package hibernate;

import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HQLTest3 {

    public void hqlTest3(String id, String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String hql = "UPDATE Employee set salary = 100 WHERE id = " + id + " AND name = " + name;
        Query query = session.createQuery(hql);
        session.getTransaction().commit();
        session.close();
    }
}