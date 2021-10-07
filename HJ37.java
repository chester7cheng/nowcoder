package com.chester.nowcoder.level1_simple;

import java.util.Scanner;

/**
 * 统计每个月兔子的总数
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int month = Integer.parseInt(scanner.nextLine());
            int rabbit1 = 1;
            int rabbit2 = 0;
            int rabbitAdult = 0;
            for (int i = 1; i < month; i++) {
                rabbitAdult = rabbitAdult + rabbit2;
                int rabbitNew = rabbitAdult;
                rabbit2 = rabbit1;
                rabbit1 = rabbitNew;
            }
            System.out.println(rabbit1 + rabbit2 + rabbitAdult);
        }

    }
}
