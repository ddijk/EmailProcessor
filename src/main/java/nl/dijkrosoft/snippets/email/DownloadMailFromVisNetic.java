package nl.dijkrosoft.snippets.email;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class DownloadMailFromVisNetic {

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imap");
        props.setProperty("mail.imap.host", imapHost);
        props.setProperty("mail.imap.port", "143");
        props.setProperty("mail.imap.connectiontimeout", "5000");
        props.setProperty("mail.imap.timeout", "5000");
        //     props.setProperty("mail.protocol.ssl.trust", imapHost);
        //      props.setProperty("mail.imaps.ssl.enable", "false");
        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imap");
            System.out.println("About to connect");
            //   store.connect(imapHost, "dickd", "aragon");
            store.connect(imapHost, "jaap", "aragon");
            System.out.println("Connected...");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            final int messageCount = inbox.getMessageCount();
            System.out.println("aantal: " + messageCount);
            for (Message m : inbox.getMessages()) {
                System.out.println("Message subject: " + m.getSubject() + ", from:" + m.getFrom()[0].toString());
            }
            System.out.println("Latest message: " + inbox.getMessage(messageCount).getSubject());
            //   Message msg = inbox.getMessage(1);

            System.out.println("Unread:" + inbox.getUnreadMessageCount());
            Message m = inbox.getMessages()[messageCount - 1];
            System.out.println("Latest?" + m.getSubject());

        } catch (NoSuchProviderException e) {
            e.printStackTrace();

        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }
    private static final String imapHost = "p-9020";
}
