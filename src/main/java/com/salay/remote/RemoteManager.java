package com.salay.remote;

import com.salay.model.Ticket;

/**
 * Created by Radek Salay on 6.11.2016.
 */
public interface RemoteManager {

    String saveOnServer(Ticket ticket);
    void nudge();
}
