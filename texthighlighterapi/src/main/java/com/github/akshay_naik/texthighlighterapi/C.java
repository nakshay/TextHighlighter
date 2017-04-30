package com.github.akshay_naik.texthighlighterapi;

import java.util.HashMap;

/**
 * Created by akshay on 30/04/17.
 */

class C implements Language{

    private HashMap<String,String> colorMap= new HashMap<>();

    //define all token in lowercase, even though text to be highlighted is in uppercase

    String[] a={"awesome"};
    String[] b={"text"};
    String[] c={"highlighter"};

    C()
    {
        for (String s:a) {
            colorMap.put(s,"green");
        }

        for (String s:b) {
            colorMap.put(s,"blue");
        }

        for (String s:c) {
            colorMap.put(s,"red");
        }
    }

    @Override
    public String getColor(String myToken) {
        String color=colorMap.get(myToken.toLowerCase());

        if(color==null) {
            color=defaultColor;
        }
        return color;
    }
}

