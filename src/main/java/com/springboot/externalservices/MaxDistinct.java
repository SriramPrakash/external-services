package com.springboot.externalservices;

import java.util.*;
import java.util.stream.Collectors;

public class MaxDistinct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = in.nextInt();
            in.nextLine();
            List<Integer> remainderArray = new ArrayList<>();
            List<Integer> originalRemainders = new ArrayList<>();
            List<Integer> windowList = new ArrayList<>();
            List<Integer> arr = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> originalArr = new ArrayList<>();
            originalArr.addAll(arr);
            Collections.sort(arr);
            for(int j=0;j<arr.size();j++){
                if(remainderArray.indexOf(arr.get(j) - 1) == -1){
                    if(arr.get(j) -1 < 0){
                        remainderArray.add(0);
                    }else{
                        remainderArray.add(arr.get(j) -1);
                    }

                    if(remainderArray.indexOf(arr.get(j) -2) == -1){
                        if(arr.get(j) -2 >0){
                            windowList.add(arr.get(j) -2);
                        }
                    }
                }else{
                        if(windowList.isEmpty()){
                            remainderArray.add(0);
                            continue;
                        }
                        Integer prevWindowVal = windowList.get(windowList.size()-1);
                        windowList.remove(windowList.size()-1);
                        windowList.add(prevWindowVal-1);
                        remainderArray.add(prevWindowVal);
                        if(remainderArray.contains(prevWindowVal-1) || prevWindowVal-1 < 0){
                            windowList.remove(windowList.size()-1);
                        }

                }

            }
            for(int k=0;k<originalArr.size();k++){
                originalRemainders.add(remainderArray.get(arr.indexOf(originalArr.get(k))));
                remainderArray.remove(arr.indexOf(originalArr.get(k)));
                arr.remove(arr.indexOf(originalArr.get(k)));
            }
            System.out.println(originalRemainders);
        }
    }
}
