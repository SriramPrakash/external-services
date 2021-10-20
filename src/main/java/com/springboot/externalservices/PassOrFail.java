package com.springboot.externalservices;

import java.util.Scanner;

public class PassOrFail {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int numberofQues = in.nextInt();
            int correct = in.nextInt();
            int passMark = in.nextInt();

            if ((correct * 3) +
                    ((numberofQues - correct) * -1) >= passMark) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        }
    }
}
