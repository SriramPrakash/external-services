package com.springboot.externalservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String currentLine = in.nextLine();
            Pattern quotes = Pattern.compile("\"([^\"]+?)\",?|([^,]+),?|,");
            Matcher quotesMatcher = quotes.matcher(currentLine);
            List<String> quotedDetails = new ArrayList<>();
            if(quotesMatcher.groupCount()>0){
                for(int i=1; i<quotesMatcher.groupCount();i++){
                    if(quotesMatcher.group(i).contains("\"")){
                        currentLine = currentLine.replace(quotesMatcher.group(i)
                                ,quotesMatcher.group(i).replace("\"\"","\""));
                        quotedDetails.add(
                                quotesMatcher.group(i).replace("\"\"","\""));
                    }else{
                        currentLine = currentLine.replace(quotesMatcher.group(i),
                                quotesMatcher.group(i).replace(",","#"));
                        quotedDetails.add(quotesMatcher.group(i).replace(",","#"));
                    }
                }
            }
        }
    }
}
