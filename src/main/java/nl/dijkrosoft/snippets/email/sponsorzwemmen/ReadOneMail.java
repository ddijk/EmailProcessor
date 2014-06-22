/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import static nl.dijkrosoft.snippets.email.sponsorzwemmen.ReadAllMails.processContent;

/**
 *
 * @author Dick
 */
public class ReadOneMail {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.xs4all.nl", "spzwemme", "Utrechtnovum14");

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message msg = inbox.getMessage(84);

            String[] zwemmer = processContent("" + msg.getContent());
            System.out.println(zwemmer[1] + "," + zwemmer[0] + "," + zwemmer[2] + "," + zwemmer[3] + "," + zwemmer[4]);

        } catch (MessagingException mex) {
            System.err.println("Failed. " + mex);
        } catch (IOException mex) {
            System.err.println("Failed. " + mex);
        }
    }
}
