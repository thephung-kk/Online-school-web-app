package com.phungnt.schoolwebapplication.service;

import com.phungnt.schoolwebapplication.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {
//    private static Logger log = org.slf4j.LoggerFactory.getLogger(ContactService.class);  → Slf4j annotaion

    private int counter = 0;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    /**
     * Save Contact Details into DB
     *
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
