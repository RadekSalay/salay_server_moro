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
    public String saveOnServer(final Ticket ticket) {
        String message;
        try{
            Session session = transactionManager.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
            session.close();
            message = "Ticket was saved."+ticket.toString();
            log.info(message);
        }catch(Exception e){
            message = "Ticket was not saved"+ ticket.toString();
            log.error(message,e);
        }
        return message;
    }

    @Override
    public void nudge() {
        log.info("Client is alive");
    }
}
