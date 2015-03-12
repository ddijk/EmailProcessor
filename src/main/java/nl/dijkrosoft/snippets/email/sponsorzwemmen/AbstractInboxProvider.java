/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.util.Properties;
import javax.mail.Folder;
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
        props.put("mail.store.protocol", "imaps");
        props.put("mail.host", "p-9020");
        //  props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.debug.auth", "true");
        //     mail.debug.auth

        Session session = Session.getInstance(props, null);
        Store store = session.getStore();
        store.connect("imap.xs4all.nl", "spzwemme", "Sponsorzwemmen15");
        //     store.connect("p-9020", "dickd", "aragon");
        inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        processInbox();

    }

    abstract void processInbox();

}
