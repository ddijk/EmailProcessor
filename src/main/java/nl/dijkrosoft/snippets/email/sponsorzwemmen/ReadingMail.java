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
      Message msg = inbox.getMessage(inbox.getMessageCount());
      Address[] in = msg.getFrom();
      for (Address address : in) {
	System.out.println("FROM:" + address.toString());
      }
          //  Multipart mp = (Multipart) msg.getContent();
      //  BodyPart bp = mp.getBodyPart(0);
      System.out.println("SENT DATE:" + msg.getSentDate());
      System.out.println("SUBJECT:" + msg.getSubject());
      //  System.out.println("CONTENT:" + bp.getContent());
      System.out.println("type=" + msg.getContentType());
      processContent("" + msg.getContent());
    } catch (Exception mex) {
      mex.printStackTrace();
    }
  }

  static String[] processContent(String content) {

    String[] retVal = new String[5];

    Container c = parseContent(content);
    retVal[0] = c.getContent();

    c = parseContent(content.substring(c.getI()));
    retVal[1] = c.getContent();

    c = parseContent(content.substring(c.getI()));
    retVal[2] = c.getContent();

    c = parseContent(content.substring(c.getI()));
    retVal[3] = c.getContent();

    c = parseContent(content.substring(c.getI()));
    retVal[4] = c.getContent();
    
    return retVal;

  }

  static Container parseContent(String input) {
    int firstEquals = input.indexOf("=");
    int firstEnd = input.indexOf("<", firstEquals);

    return new Container(firstEnd, input.substring(firstEquals + 2, firstEnd));
  }
}
