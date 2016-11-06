package com.salay.remote;

import com.salay.model.Ticket;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;

/**
 * Created by Radek Salay on 6.11.2016.
 */
@Service
public class RemoteManagerImpl implements RemoteManager {
    private final Logger log = Logger.getLogger(RemoteManagerImpl.class);

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Override
    public boolean saveOnServer(final Ticket ticket) {
        boolean respond;
        try{
            Session session = transactionManager.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
            session.close();
            respond = true;
            log.info("Ticket was saved."+ticket.toString());
        }catch(Exception e){
            respond = false;
            log.error("Ticket was not saved"+ ticket.toString(),e);
        }
        return respond;
    }

    @Override
    public void nudge() {
    }
}
