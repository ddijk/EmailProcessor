package nl.dijkrosoft.snippets.email;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class DownloadMailFromVisNeticSSL {

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.host", imapHost);
        props.setProperty("mail.imaps.port", "143");
        props.setProperty("mail.imaps.connectiontimeout", "5000");
        props.setProperty("mail.imaps.timeout", "5000");
        //     props.setProperty("mail.protocol.ssl.trust", imapHost);
        props.setProperty("mail.imaps.ssl.enable", "false");
        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            System.out.println("About to connect");
            store.connect(imapHost, "dickd", "aragon");
            System.out.println("Connected...");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(1);
            System.out.println("Message subject: " + msg.getSubject());

        } catch (NoSuchProviderException e) {
            e.printStackTrace();

        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }
    private static final String imapHost = "p-9020";
}
