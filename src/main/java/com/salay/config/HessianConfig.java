package com.salay.config;

import com.salay.remote.RemoteManager;
import com.salay.remote.RemoteManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Controller;

/**
 * Created by Radek Salay on 6.11.2016.
 */
@Controller
public class HessianConfig {

    @Bean(name = "/saveTicket.http")
    public HessianServiceExporter hessianServiceExporter(@Autowired RemoteManagerImpl remoteManager){
        HessianServiceExporter bean = new HessianServiceExporter();
        bean.setService(remoteManager);
        bean.setServiceInterface(RemoteManager.class);
        return bean;
    }
}
