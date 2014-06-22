/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.util.List;

/**
 *
 * @author Dick
 */
public class MessageBodyParser {
    
     static int processContent(String messageBody, List<String> zwemmerFields) {

        int firstEquals = messageBody.indexOf("=");

        if (firstEquals != -1) {
            int firstEnd = messageBody.indexOf("<", firstEquals);
            zwemmerFields.add(messageBody.substring(firstEquals + 2, firstEnd));
            return processContent(messageBody.substring(firstEnd), zwemmerFields);
        }
        return -1 ;

    }
}
