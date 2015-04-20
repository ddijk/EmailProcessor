/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.email.sponsorzwemmen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dickdijk
 */
public class Java8CollectDistinct {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("aap", "noot", "mies", "noot");

        System.out.println("Aantal in lijst met duplicates:" + myList.stream().collect(Collectors.toList()).size());
        String joined = myList.stream().collect(Collectors.joining(", "));
        System.out.println("joined is " + joined);
        System.out.println("Aantal in lijst zonder duplicates:" + myList.stream().distinct().collect(Collectors.toList()).size());
        String joinedDistinct = myList.stream().distinct().collect(Collectors.joining(", "));
        System.out.println("joined distinct is " + joinedDistinct);
    }
}
