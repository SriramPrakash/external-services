package com.springboot.externalservices;

import java.util.Scanner;

public class Heist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int N = in.nextInt();
            in.nextLine();
            String directions = in.nextLine();
            boolean current = false;
            int size = directions.toCharArray().length;
            for(int k=1;k<size;k++){
                if(directions.charAt(k) == directions.charAt(k-1)){
                    System.out.println("YES");
                    current=true;
                    break;
                }
            }
            if(!current){
                System.out.println("NO");
            }

        }
    }
}
