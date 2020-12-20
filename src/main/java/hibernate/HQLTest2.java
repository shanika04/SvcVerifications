package hibernate;

import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HQLTest2 {

  public void hqlTest2(String id) {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    Query query = session.createQuery("UPDATE Employee set salary = 100 WHERE id = " + id);
    session.getTransaction().commit();
    session.close();
  }
}