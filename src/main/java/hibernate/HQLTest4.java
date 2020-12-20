package hibernate;

import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HQLTest4 {

    public void hqlTest4(String id, String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String hql = "UPDATE Employee set salary = 100 WHERE id = " + id + " AND name = " + name;
        sink(session,hql);
    }

    public void sink(Session session, String hqlQuery){
        Query query = session.createQuery(hqlQuery);
        session.getTransaction().commit();
        session.close();
    }
}