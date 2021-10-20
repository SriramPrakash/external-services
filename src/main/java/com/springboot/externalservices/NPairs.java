package com.springboot.externalservices;

import java.util.*;
import java.util.stream.Collectors;

public class NPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for(int i=0;i<testCases;i++) {
            int lengthOfArray = in.nextInt();
            in.nextLine();
            List<Integer> arr = Arrays.asList(in.nextLine().split("")).stream()
                    .map(Integer::parseInt).collect(Collectors.toList());
            int count = 0;
            for(int j=0;j<lengthOfArray-1;j++){
                for(int k=j+1;k<j+11;k++){
                    if(k<lengthOfArray){
                        if(Math.abs(j-k) == Math.abs(arr.get(j) - arr.get(k))){
                                count+=1;
                        }
                    }

                }
            }
            System.out.println(count);
        }
    }
}
