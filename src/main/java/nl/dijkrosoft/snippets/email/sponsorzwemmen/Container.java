/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.dijkrosoft.snippets.email.sponsorzwemmen;

/**
 *
 * @author dick
 */
public class Container {

  public Container(int i, String content) {
    this.i = i;
    this.content = content;
    System.out.println("i="+i+", "+content);
  }
  
  int i;
  String content;

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  
  
  
}
