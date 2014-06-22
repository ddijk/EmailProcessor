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
import javax.mail.Message;
import javax.mail.MessagingException;

/**
 *
 * @author Dick
 */
public class ReadOneMail extends AbstractInboxProvider {

    private static final int OLDEST_MESSAGE = 1;

    @Override
    void processInbox() {
        try {
            Message msg = inbox.getMessage(OLDEST_MESSAGE);

            List<String> zwemmerFields = new ArrayList<>();
            MessageBodyParser.processContent("" + msg.getContent(), zwemmerFields);
            System.out.println(zwemmerFields.get(1) + "," + zwemmerFields.get(0) + "," + zwemmerFields.get(2) + "," + zwemmerFields.get(3) + "," + zwemmerFields.get(4));

        } catch (MessagingException | IOException ex) {
            Logger.getLogger(ReadAllMails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws MessagingException {
        ReadOneMail rom = new ReadOneMail();
        rom.getMessages();
    }
}
