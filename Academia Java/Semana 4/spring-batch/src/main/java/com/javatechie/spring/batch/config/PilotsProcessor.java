package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Pilots;
import org.springframework.batch.item.ItemProcessor;

public class PilotsProcessor implements ItemProcessor<Pilots,Pilots> {

    @Override
    public Pilots process(Pilots customer) throws Exception {
        
    	/*if(customer.getCountry().equals("China")) {
            return customer;
        }*/
    	
        return customer;
        
    }
}
