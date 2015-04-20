package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class ReadingEmailMultpart {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            // sp zemme Sponsorzwemmen15
            //  store.connect("imap.xs4all.nl", "**user**", "**wachtw**");
            store.connect("imap.xs4all.nl", "spzwemme", "Sponsorzwemmen15");

            Folder inbox = store.getFolder("INBOX");

            Folder editie2014 = inbox.getFolder("editie2014");
            editie2014.open(Folder.READ_ONLY);
            Message msg = editie2014.getMessage(editie2014.getMessageCount());
            System.out.println("Aantal = " + editie2014.getMessageCount());

            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            //    Multipart mp = (Multipart) msg.getContent();
            //   BodyPart bp = mp.getBodyPart(0);
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + msg.getContent());
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

}
