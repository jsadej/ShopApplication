/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.produkt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ksiezniczka
 */
public class Matches {

    public void matcherPattern(String id, String name, String price) {
        String pattern1 = "\\d+";
        String pattern2 = "[a-zA-Z]+";
        String pattern3 = "\\d{1,3}(,?\\d{3})*(\\.\\d{1,2})?";
        Pattern PatternID = Pattern.compile(pattern1);
        Pattern PatternName = Pattern.compile(pattern2);
        Pattern PaternPrice = Pattern.compile(pattern3);
        Matcher mid = PatternID.matcher(id);
        Matcher mName = PatternName.matcher(name);
        Matcher mPrice = PaternPrice.matcher(price);
        if (mid.matches() && mName.matches() && mPrice.matches()) {
         
           
        } else {

        }
    }
}

