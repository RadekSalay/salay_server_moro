package com.salay.database;

import com.salay.config.SalayServerMoroApplication;
import com.salay.model.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by Radek Salay on 6.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { SalayServerMoroApplication.class }, loader = AnnotationConfigContextLoader.class)
public class HibernateTest {
    @Autowired
    private HibernateTransactionManager transactionManager;

    @Test
    public void contextLoads() {
        Session session = transactionManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Ticket t = new Ticket();
        t.setFirstName("Moro");
        t.setLastName("System");
        t.setEmail("Moro@system.com");
        session.persist(t);
        tx.commit();
        session.close();
    }

}
