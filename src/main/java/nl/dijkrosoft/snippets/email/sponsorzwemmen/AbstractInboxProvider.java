/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author Dick
 */
public abstract class AbstractInboxProvider {

    protected Folder inbox;


    
    void getMessages() throws NoSuchProviderException, MessagingException {
         Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props, null);
        Store store = session.getStore();
        store.connect("imap.xs4all.nl", "spzwemme", "Utrechtnovum14");

        inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        processInbox();

    }

    abstract void processInbox();

}
