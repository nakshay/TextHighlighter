package com.github.akshay_naik.texthighlighterapi;


/**
 * Created by akshay on 30/04/17.
 */

 class Cpp implements Language{


    //define all token in lowercase, even though text to be highlighted is in uppercase

    final String[] operators = {">", "&lt;", "&lt;&lt;", ">>","+","-","++","--","==","="};
    final String[] symbols = {"#include", "//", "{", "}", "(", ")"};
    final String[] comments = {"/*", "*/"};
    final String[] tokens = {"iostream.h", "asm", " auto", " break", " case", " catch", " char", " class", " const",
            " continue", " default", " delete", " do", " double", " else", " enum", " extern", " float",
            " for", " friend", " goto", " if", " inline", " int", " long", " new", " operator",
            " private", " protected", " public", " register", " return", " short",
            " signed", " sizeof", " static", " struct", " switch", " template", " this",
            " throw", " try", " typedef", " union", " unsigned", " virtual", " void", " volatile", " while", "cout", "cin"};

    Cpp()
    {
        for (String token:tokens) {
            colorMap.put(token,"red");
        }

        for (String operator:operators) {
            colorMap.put(operator,"#2C5A2E");
        }
        for (String comment:comments) {
            colorMap.put(comment,"purple");
        }
        for (String symbol: symbols) {
            colorMap.put(symbol,"blue");
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
