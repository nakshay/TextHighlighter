package com.github.akshay_naik.texthighlighterapi;

/**
 * Created by akshay on 30/04/17.
 */

class Java implements Language{

    //define all token in lowercase, even though text to be highlighted is in uppercase


    final String[] operators={"+","-","/","*","%","=","+=","-=","*=","/=",
            "%=","&=","^=","<",">","<=",">=","==","!=","&&","||","!","&","|","~","^","<<",
            ">>","?",":","<<=",">>=","++","--","&lt;", "&lt;&lt;","println","print",">>>","<<<"};

    final String[] tokens ={"abstract","assert boolean","break","byte","case","catch","char","class",
            "const","continue","default","do","double","else","enum ","extends","final","finally","float",
            "for","goto","if","implements","import","instanceof","int","interface","long","native","new","package",
            "private","protected","public","return","short","static","strictfp"," super","switch","synchronized",
            "this","throw","throws","transient","try","void","volatile","while"};

    final String[] symbols = {"import", "//", "{", "}", "(", ")"};

    final String[] comments={"/*", "*/","//"};

    Java() {
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
