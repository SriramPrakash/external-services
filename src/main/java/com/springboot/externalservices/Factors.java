package com.springboot.externalservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Factors {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for(int i=0;i<testCases;i++) {
            int number = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int totalScore = 0;
            List<Integer> primeFactors = sieveOfEratosthenes(number);
            HashMap<Integer,Integer> factorMultiplied = new HashMap<>();
                for(int j = 0;j<primeFactors.size();j++){
                    while(number%primeFactors.get(j)==0){
                        number = number/primeFactors.get(j);
                        if(factorMultiplied.get(primeFactors.get(j)) == null){
                            factorMultiplied.put(primeFactors.get(j),1);
                        }else{
                            factorMultiplied.put(primeFactors.get(j),
                                    factorMultiplied.get(primeFactors.get(j))+1);
                        }
                    }
                }
                    if(a>b){
                        if(factorMultiplied.get(2) != null){
                            totalScore += a*factorMultiplied.get(2);
                            factorMultiplied.remove(2);
                        }
                        totalScore +=b*(factorMultiplied.values().stream()
                                .collect(Collectors.summingInt(Integer::intValue)));

                    }else{
                        if(factorMultiplied.get(2) != null){
                            totalScore +=a;
                            factorMultiplied.remove(2);
                        }
                        totalScore += b*(factorMultiplied.values().stream()
                                .collect(Collectors.summingInt(Integer::intValue)));
                    }
                System.out.println(totalScore);
        }
    }
    static List<Integer> sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        List<Integer> primeFactors = new ArrayList<>();
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                primeFactors.add(i);
        }
        return primeFactors;
    }
}
