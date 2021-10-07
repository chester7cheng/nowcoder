package com.chester.nowcoder.level1_simple;

import java.util.Scanner;

public class HJ12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        for(int i=inputStr.length()-1;i>=0;i--){
            System.out.print(inputStr.charAt(i));
        }
    }
}
