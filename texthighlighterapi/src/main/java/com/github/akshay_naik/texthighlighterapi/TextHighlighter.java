/*
 * Copyright 2016 AKSHAY NAIK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

package com.github.akshay_naik.texthighlighterapi;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by akshay on 14/08/16.
 */

public class TextHighlighter implements LibraryConstant.LanguageConstant,LibraryConstant.StyleConstant {

    private String defaultColor;
    private String language;
    private HashMap<String,String> colorMap= new HashMap<>();
    private HashMap<String,String> styleMap=new HashMap<>();

    public void setLanguage(String language)
    {
        this.language=language;
    }


    public String getHighlightedText(String stringToBeHighlighted) {
        StringBuilder highlightedText=new StringBuilder();
        String color="";
        String myToken="";

        Language selectedLanguage=null;

        StringTokenizer tokenizer=new StringTokenizer(stringToBeHighlighted);

        selectedLanguage=selectLanguage(selectedLanguage);

        if(selectedLanguage!=null){
            highlightedText=getHighlightedTextForLanguage(tokenizer,selectedLanguage);
        }
        else {

            while (tokenizer.hasMoreTokens()) {

                myToken = tokenizer.nextToken();
                color = getColor(myToken);
                highlightedText.append(colorTheToken(myToken, color) + " ");
            }
        }


        return new String(highlightedText);
    }

    private Language selectLanguage(Language selectedLanguage) {
        if(language!="" && language!=null){

            switch (language) {
                case C:
                    selectedLanguage= new C();
                    break;
                case CPP:
                    selectedLanguage= new Cpp();
                    break;
                case JAVA:
                    selectedLanguage= new Java();
                    break;
            }
        }
        return selectedLanguage;
    }

    private StringBuilder getHighlightedTextForLanguage(StringTokenizer tokenizer, Language selectedLanguage) {

        StringBuilder highlightedText=new StringBuilder();
        String color="";
        String myToken="";

        while (tokenizer.hasMoreTokens()) {

            myToken = tokenizer.nextToken();
            color = selectedLanguage.getColor(myToken);
            highlightedText.append(colorTheToken(myToken, color) + " ");
        }

        return highlightedText;

    }


    public void setDefaultColor(String color)
    {

        if(color=="" || color == null) {
            defaultColor = "black";
        }
        else {
            defaultColor=color;
        }

    }
    public String getDefaultColor()
    {
        if(defaultColor == "" || defaultColor == null) {
            return defaultColor;
        }
        else {
            return defaultColor;
        }

    }

    private String getColor(String myToken) {

        String color=colorMap.get(myToken.toLowerCase());

        if(color==null) {
            color=defaultColor;
        }
        return color;
    }

    private String colorTheToken(String token, String color) {

        return "<font color='"+color+"'> "+token+" </font>";
    }

    public void setColorForTheToken(String token, String color) {

        token=token.trim();
        color=color.trim();
        colorMap.put(token.toLowerCase(),color);
    }

    public void setColorForTheToken(String[] tokenArray,String color) {

        for (String token:tokenArray) {
            setColorForTheToken(token,color);
        }
    }

    public String[] getColorForTheToken(String[] tokenArray) {

        String[] color=new String[tokenArray.length];

        for(int index=0;index<tokenArray.length;index++) {
            color[index]=getColorForTheToken(tokenArray[index]);
        }

        return color;

    }

    public String getColorForTheToken(String token) {
        token=token.trim();
        String color="";

        color=colorMap.get(token.toLowerCase());

        if(color==null) {
            return defaultColor;
        }
        return color;

    }

    public String getStyledText(String stringToBeStyled)  {
        StringBuilder styledText=new StringBuilder();
        String style="";
        String myToken="";
        StringTokenizer tokenizer=new StringTokenizer(stringToBeStyled);

        while (tokenizer.hasMoreTokens()) {

            myToken=tokenizer.nextToken();
            style=getStyle(myToken);
            styledText.append(styleTheToken(myToken,style)+ " ");
        }
        return new String(styledText);
    }

    public String[] getStyleForTheToken(String[] tokenArray) {

        String[] style=new String[tokenArray.length];
        for(int index=0;index<tokenArray.length;index++) {
            style[index]=getStyleForTheToken(tokenArray[index]);
        }

        return style;
    }

    private String getStyle(String myToken) {

        String style=styleMap.get(myToken.toLowerCase());

        if(style==null) {
            style=NORMAL;
        }

        return style;
    }

    private String styleTheToken(String token,String style) {

        String taggedText=token;

        switch (style) {
            case NORMAL :
                taggedText= token;
                break;

            case BOLD:
                taggedText= "<b> "+token+" </b>";
                break;

            case ITALIC:
                taggedText= "<i> "+token+" </i>";
                break;

            case UNDERLINE:
                taggedText= "<u> "+token+" </u>";
                break;

            case SUPERSCRIPT:
                taggedText= "<sup> "+token+" </sup>";
                break;

            case SUBSCRIPT:
                taggedText= "<sub> "+token+" </sub>";
                break;

            default:
                taggedText=token;

        }
        return taggedText;
    }

    public void setStyleForTheToken(String token,String style) {

        token=token.trim();
        style=style.trim();
        styleMap.put(token.toLowerCase(),style);

    }

    public void setStyleForTheToken(String[] tokenArray,String style) {

        for(String token:tokenArray) {
            setStyleForTheToken(token,style);
        }
    }

    public String getStyleForTheToken(String token) {
        token=token.trim();
        String style="";

        style=styleMap.get(token.toLowerCase());

        if (style==null) {
            return NORMAL;
        }
        return style;
    }

}
