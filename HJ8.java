package com.chester.nowcoder.level2_middle;

import java.util.*;

public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        Map<Integer, Integer> result = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            String[] inputArray = scanner.nextLine().split(" ");
            int key = Integer.parseInt(inputArray[0]);
            int value = Integer.parseInt(inputArray[1]);
            Integer sum = result.get(key);
            sum = Objects.isNull(sum) ? value : sum + value;
            result.put(key, sum);
        }
        for (Integer key : result.keySet()) {
            System.out.println(key + " " + result.get(key));
        }
    }
}
