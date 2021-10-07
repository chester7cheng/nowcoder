package com.chester.nowcoder.level2_middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        ArrayList<Long> resultList = new ArrayList<>();

        findAllPrime(input, resultList);
        Collections.sort(resultList);
        for (long item : resultList) {
            System.out.print(item + " ");
        }
    }

    private static void findAllPrime(long num, ArrayList<Long> resultList) {
        long limit = (long) Math.sqrt(num);
        for (long i = 2; i <= limit; i++) {
            if (num % i != 0 || !isPrime(i)) {
                continue;
            }

            resultList.add(i);
            findAllPrime(num / i, resultList);
            break;
        }
        if (isPrime(num)) {
            resultList.add(num);
        }
    }

    private static boolean isPrime(long num) {
        long limit = (long) Math.sqrt(num);
        for (long i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
