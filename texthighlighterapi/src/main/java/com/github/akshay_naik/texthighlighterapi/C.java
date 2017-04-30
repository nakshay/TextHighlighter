package com.github.akshay_naik.texthighlighterapi;

import java.util.HashMap;

/**
 * Created by akshay on 30/04/17.
 */

class C implements Language{

    private HashMap<String,String> colorMap= new HashMap<>();

    String[] a={"Awesome","awesome"};
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
        String color=colorMap.get(myToken);

        if(color==null) {
            color=defaultColor;
        }
        return color;
    }
}

