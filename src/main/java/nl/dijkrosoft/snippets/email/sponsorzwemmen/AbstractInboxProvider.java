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

    private String folder;
    protected Folder inbox;

    public AbstractInboxProvider(String folder) {
        this.folder = folder;
    }

    void getMessages() throws NoSuchProviderException, MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props, null);
        Store store = session.getStore();
        store.connect("imap.xs4all.nl", "spzwemme", "Sponsorzwemmen15");

        inbox = store.getFolder(folder);  // bijv. INBOX/editie2014
        inbox.open(Folder.READ_ONLY);

        processInbox();

    }

    abstract void processInbox();

}
