package com.chester.nowcoder.nc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 求路径
 */
public class NC34 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] inputArray = scanner.nextLine().split(",");
        String[] inputArray = "3,3".split(",");
        int result = moveToZero(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
        System.out.println(result);
    }

    static Map<String, Integer> tmp = new HashMap<>();

    private static int moveToZero(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m < 1 || n < 1) {
            return 0;
        }
        String key = m + "," + n;
        if (Objects.nonNull(tmp.get(key))) {
            return tmp.get(key);
        }
        int value = moveToZero(m - 1, n) + moveToZero(m, n - 1);
        tmp.put(key, value);
        return value;
    }
}
