/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.mail.Message;
import javax.mail.MessagingException;

/**
 *
 * @author dickdijk
 */
public class ListAllEmailAddresses extends AbstractInboxProvider {

    public ListAllEmailAddresses(String folder) {
        super(folder);
    }

    @Override
    void processInbox() {
        try {
            List<String> emailAddresses = new ArrayList<>();

            for (Message msg : inbox.getMessages()) {

                List<String> emailBodyFields = new ArrayList<>();
                MessageBodyParser.processContent("" + msg.getContent(), emailBodyFields);
                emailAddresses.add(emailBodyFields.get(4));
                //System.out.println(emailAddresses.get(1) + "," + emailAddresses.get(0) + "," + emailAddresses.get(2) + "," + emailAddresses.get(3) + "," + emailAddresses.get(4));
            }

            System.out.println("Aantal in lijst met duplicates:" + emailAddresses.stream().collect(Collectors.toList()).size());
            System.out.println("Aantal in lijst zonder duplicates:" + emailAddresses.stream().distinct().collect(Collectors.toList()).size());
            System.out.println("All email addresses:" + emailAddresses.stream().distinct().collect(Collectors.joining(", ")));

        } catch (MessagingException | IOException ex) {
            Logger.getLogger(ReadAllMails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws MessagingException {
        ListAllEmailAddresses ram = new ListAllEmailAddresses("inbox/editie2014");
        ram.getMessages();
    }
}
