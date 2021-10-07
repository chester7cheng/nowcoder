package com.chester.nowcoder.level3_hard;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        System.out.println(inputArray[inputArray.length-1].length());

    }
}
