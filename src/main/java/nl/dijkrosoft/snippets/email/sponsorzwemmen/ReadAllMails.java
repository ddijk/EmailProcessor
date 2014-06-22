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
 * @author dick
 */
public class ReadAllMails extends AbstractInboxProvider{

    @Override
    void processInbox() {
        try {
            for (Message msg : inbox.getMessages()) {
                
                List<String> zwemmerFields = new ArrayList<>();
                MessageBodyParser.processContent("" + msg.getContent(), zwemmerFields);
                System.out.println(zwemmerFields.get(1) + "," + zwemmerFields.get(0) + "," + zwemmerFields.get(2) + "," + zwemmerFields.get(3) + "," + zwemmerFields.get(4));
            }
        } catch (MessagingException | IOException ex) {
            Logger.getLogger(ReadAllMails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static void main(String[] args) throws MessagingException {
        ReadAllMails ram = new ReadAllMails();
        ram.getMessages();
    }





}
