package com.springboot.externalservices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubTask {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for(int i=0;i<testCases;i++) {
            Integer length = in.nextInt();
            Integer minTc = in.nextInt();
            Integer score = in.nextInt();
            in.nextLine();
            List<String> arr = Arrays.asList(in.nextLine().split(" "));
            int minTcs = 0;
            for(int j=0;j<minTc;j++){
                minTcs+=Integer.parseInt(arr.get(j));
            }
            Integer casesPassed = arr.stream().
                    map($ -> Integer.parseInt($)).
                    collect(Collectors.summingInt(Integer::intValue));
            if(casesPassed == length) {
                System.out.println("100");
            }else if(minTcs >= minTc){
                System.out.println(score);
            }else {
                System.out.println("0");
            }
        }
    }
}
