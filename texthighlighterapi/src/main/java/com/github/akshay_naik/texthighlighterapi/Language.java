package com.github.akshay_naik.texthighlighterapi;

import java.util.HashMap;

/**
 * Created by akshay on 30/04/17.
 */

 interface Language {
    HashMap<String,String> colorMap= new HashMap<>();
    String getColor(String myToken);
    String defaultColor = "black";
}
