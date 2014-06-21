 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author dick
 */
public class ReadingMail {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.xs4all.nl", "spzwemme", "Utrechtnovum14");

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
   //   Message msg = inbox.getMessage(inbox.getMessageCount());
//      Address[] in = msg.getFrom();
//      for (Address address : in) {
//	System.out.println("FROM:" + address.toString());
//      }

            for (Message msg : inbox.getMessages()) {

                String[] zwemmer = processContent("" + msg.getContent());
                System.out.println(zwemmer[1] + "," + zwemmer[0] + "," + zwemmer[2] + "," + zwemmer[3] + "," + zwemmer[4]);
            }
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

    static String[] processContent(String messageBody) {

        String[] retVal = new String[5];

        Container c = parseContent(messageBody);
        retVal[0] = c.getFieldValue();

        String fragment = messageBody.substring(c.getEndOfFieldIndex());

        c = parseContent(fragment);
        retVal[1] = c.getFieldValue();
        fragment = fragment.substring(c.getEndOfFieldIndex());

        c = parseContent(fragment);
        retVal[2] = c.getFieldValue();
        fragment = fragment.substring(c.getEndOfFieldIndex());

        c = parseContent(fragment);
        retVal[3] = c.getFieldValue();
        fragment = fragment.substring(c.getEndOfFieldIndex());

        c = parseContent(fragment);
        retVal[4] = c.getFieldValue();

        return retVal;

    }

    static Container parseContent(String input) {

        int firstEquals = input.indexOf("=");
        int firstEnd = input.indexOf("<", firstEquals);

        return new Container(firstEnd, input.substring(firstEquals + 2, firstEnd));
    }
}
