package com.springboot.externalservices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();
            String daysInMonth = in.nextLine();
            int maxStreak = 0;
            int numberOfDaysWorked = 0;
            int currentStreak = 0;
            for(char c:daysInMonth.toCharArray()){
                if(c=='1'){
                    currentStreak++;
                    numberOfDaysWorked++;
                }
                if(c=='0'){
                    currentStreak = 0;
                }
                if(maxStreak<=currentStreak){
                    maxStreak=currentStreak;
                }
            }
            System.out.println(numberOfDaysWorked*x+maxStreak*y);

        }
    }
}
