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

public class TextHighlighter {



    public String defaultColor="black";
    private HashMap<String,String> colorMap= new HashMap<>();

    public TextHighlighter() {}



    public String getHighlightedText(String stringToBeHighlighted)
    {
        String highlightedText="";
        String color="";
        String myToken="";

        StringTokenizer tokenizer=new StringTokenizer(stringToBeHighlighted);

        while (tokenizer.hasMoreTokens()) {

            myToken = tokenizer.nextToken();
            color=getColor(myToken);
            highlightedText += colorTheToken(myToken, color) + " ";
        }

        return highlightedText;
    }

    private String getColor(String myToken) {

        String color=colorMap.get(myToken.toLowerCase());

        if(color==null) {
            color=defaultColor;
        }


        colorTheToken(myToken,color);

        return color;
    }

    private String colorTheToken(String token, String color) {

        return "<font color='"+color+"'>"+token+"</font>";
    }

    public void setColorForTheToken(String token, String color) {

        token=token.trim();
        color=color.trim();
        colorMap.put(token.toLowerCase(),color);
    }

    public String getColorForTheToken(String token)
    {
        token=token.trim();
        String color="";

        color=colorMap.get(token.toLowerCase());

        if(color==null) {
            return defaultColor;
        }
        return color;

    }

}
