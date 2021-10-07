package com.chester.nowcoder.level1_simple;

import java.util.Scanner;


public class HJ61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] inputArray = scanner.nextLine().split(" ");
            int result = count(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
            System.out.println(result);
        }

    }

    /**
     * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
     * （用K表示）5，1，1和1，5，1 是同一种分法。
     * 数据范围：0<=m<=10，1<=n<=10。
     */
    private static int count(int apple, int plate) {
        if (apple == 0 || plate == 1) {
            return 1;
        }
        if (plate > apple) {
            return count(apple, apple);
        }
        return count(apple, plate - 1) + count(apple - plate, plate);
    }
}
