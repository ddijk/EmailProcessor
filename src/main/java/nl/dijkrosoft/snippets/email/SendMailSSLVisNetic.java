package nl.dijkrosoft.snippets.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSLVisNetic {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "p-9020");
        props.put("mail.smtp.socketFactory.port", "25");
        //     props.put("mail.smtp.socketFactory.class",                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("dickd", "aragon");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmailAdres));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(myEmailAdres));
            message.setSubject("Testing Subject 3");
            message.setText("Hoi Dick");

            System.out.println("About to send");
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String myEmailAdres = "dickd@pearl.eu";
}
