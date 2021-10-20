package com.springboot.externalservices;

import java.util.Scanner;

public class LuckyNum {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for(int i=0;i<testCases;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (a == 7 || b == 7 || c == 7) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
