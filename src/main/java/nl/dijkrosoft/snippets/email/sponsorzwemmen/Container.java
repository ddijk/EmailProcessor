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
    this.endOfFieldIndex = i;
    this.fieldValue = content;   
  }
  
  int endOfFieldIndex;
  String fieldValue;

  public int getEndOfFieldIndex() {
    return endOfFieldIndex;
  }

  public void setEndOfFieldIndex(int endOfFieldIndex) {
    this.endOfFieldIndex = endOfFieldIndex;
  }

  public String getFieldValue() {
    return fieldValue;
  }

  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
  }
  
  
  
}
