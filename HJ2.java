package com.chester.nowcoder.level3_hard;

import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine().toLowerCase();
        String charStr = scanner.nextLine().toLowerCase();

        if(!inputStr.contains(charStr)){
            System.out.println(0);
            return;
        }
        int count = 0;
        while (inputStr.contains(charStr)){
            count++;
            inputStr = inputStr.substring(inputStr.indexOf(charStr)+1);
        }
        System.out.println(count);
    }
}
