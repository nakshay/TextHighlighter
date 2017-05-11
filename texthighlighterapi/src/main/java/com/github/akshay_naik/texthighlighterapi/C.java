package com.github.akshay_naik.texthighlighterapi;

/**
 * Created by akshay on 30/04/17.
 */

class C implements Language{


    //define all token in lowercase, even though text to be highlighted is in uppercase

    final String[] tokens={"auto","double","int","struct","const","float","short","unsigned","break","else","long","switch","continue","for","signed",
            "void","case","enum","register","typedef","default","goto","sizeof","volatile","char","extern","return","union","do","if","static",
            "while"};

    final String[] operators={"+","-","/","*","%","=","+=","-=","*=","/=",
            "%=","&=","^=","<",">","<=",">=","==","!=","&&","||","!","&","|","~","^","<<",
            ">>","?",":","Sizeof","++","--","&lt;", "&lt;&lt;","printf","scanf"};

    final String[] symbols={"(",")","{","}","[","]", "#include"};

    final String[] comments={"/*", "*/","//"};


    C()
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

