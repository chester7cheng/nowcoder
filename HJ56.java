package com.chester.nowcoder.level1_simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 完数计算
 */
public class HJ56 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int input = Integer.parseInt(scanner.nextLine());
            int count = 0;
            for (int i = 2; i <= input; i++) {
                if (checkPerfectNumber(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean checkPerfectNumber(int param) {
        List<Integer> trueFactorList = new ArrayList<>();
        for (int i = 1; i < param; i++) {
            if (param % i == 0) {
                trueFactorList.add(i);
            }
        }
        int sum = 0;
        for (Integer item : trueFactorList) {
            sum += item;
        }
        return param == sum;
    }
}
