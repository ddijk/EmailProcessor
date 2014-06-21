/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.dijkrosoft.snippets.email.sponsorzwemmen;


import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author dick
 */
public class ReadingMailTest {
  
  String input = "h1>Aanmelding sponsorzwemmen</h1><p><strong>Dank voor de aanmelding. Succes met zwemmen!<br />\n" +
"<br />\n" +
"Het sponsorzwemmen vindt plaats op zaterdag 21 juni, tussen 14 en 16 uur in zwembad Fletiomare.</strong></p><p>Voornaam = Jula</p>\n" +
"<p>Achternaam = Uffing</p>\n" +
"<p>Ik zit in = groep 4</p>\n" +
"<p>School = Drie koningenschool</p>\n" +
"<p>E-mailadres = n.uffing@planet.nl</p>\n";
  
 

  @Test
  public void testMain() {
    
    String[] expected =  new String[] {"Jula","Uffing", "groep 4" ,"Drie koningenschool", "n.uffing@planet.nl" };
    
    String[] actual = ReadingMail.processContent(input);
    
    Assert.assertArrayEquals(expected, actual);
  }
  
}
