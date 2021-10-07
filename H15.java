package com.chester.nowcoder.level0_intro;

import java.util.Scanner;

public class H15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        int amount = 0;
        while (data > 0) {
            if ((data & 1) == 1) {
                amount++;
            }
            if (data <= 1) {
                break;
            }
            data = data >>> 1;
        }
        System.out.println(amount);
    }
}
