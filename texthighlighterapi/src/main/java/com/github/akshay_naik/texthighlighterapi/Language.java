package com.github.akshay_naik.texthighlighterapi;

/**
 * Created by akshay on 30/04/17.
 */

 interface Language {
    String getColor(String myToken);
    String defaultColor = "black";
}
