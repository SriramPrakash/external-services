package com.springboot.externalservices;

import java.util.*;
import java.util.stream.Collectors;

public class Roundinh {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        List<Integer> arrayLiterals= new ArrayList<>();
        List<Float> arrayDecimals = new ArrayList<>();
        List<Float> arrayDecimalsCopy = new ArrayList<>();
        Map<Float,Integer> countOfDiffNumbers = new HashMap<>();
        List<Integer> roundedNumbers = new ArrayList<>();
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            float number = in.nextFloat();
            arrayLiterals.add((int) number);
            arrayDecimals.add(number-(int) number);
            if(countOfDiffNumbers.get(number-(int) number) != null){
                countOfDiffNumbers.put(number-(int) number, countOfDiffNumbers.get(number-(int) number)+1);
            }else{
                countOfDiffNumbers.put(number-(int) number,1);
            }
        }
        arrayDecimalsCopy.addAll(arrayDecimals);
        int target = in.nextInt();
        int literalArraySum = arrayLiterals.stream().collect(Collectors.summingInt(Integer::intValue));
        target = target-literalArraySum;
        Collections.sort(arrayDecimals);
        int i=1;
        while(target>0){
            if(countOfDiffNumbers.get(arrayDecimals.get(arrayDecimals.size()-i)) != null){
                target-=1;
                countOfDiffNumbers.put(arrayDecimals.get(arrayDecimals.size()-i),
                        countOfDiffNumbers.get(arrayDecimals.get(arrayDecimals.size()-i))-1);
            }
            i++;
        }

        arrayDecimals.clear();
        for(i=0;i<arrayDecimalsCopy.size();i++){
            float currentVar = countOfDiffNumbers.get(arrayDecimalsCopy.get(i)) > 0 ?
                    0.0F: 1.0F;
            arrayDecimals.add(currentVar);
            countOfDiffNumbers.put(arrayDecimalsCopy.get(i),
                    countOfDiffNumbers.get(arrayDecimalsCopy.get(i))-1);
        }

        for(i=0;i<arrayDecimals.size();i++){
            roundedNumbers.add((int)(arrayDecimals.get(i)+arrayLiterals.get(i)));
        }
        System.out.println(roundedNumbers);
    }
}
