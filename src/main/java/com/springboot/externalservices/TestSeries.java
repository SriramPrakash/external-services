package com.springboot.externalservices;

import java.util.Scanner;

public class TestSeries {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        in.nextLine();
        for(int i=0;i<testCases;i++) {
            String[] series = in.nextLine().split(" ");
            int indiaWin = 0;
            int nzWin = 0;
            for(int j=0;j<series.length;j++){
                if(series[j].equals("2")){
                    nzWin++;
                }
                else if(series[j].equals("1")){
                    indiaWin++;
                }
            }
            if(indiaWin>nzWin){
                System.out.println("INDIA");
            }
            else if(nzWin>indiaWin){
                System.out.println("ENGLAND");
            }else{
                System.out.println("DRAW");
            }
        }
    }
}
