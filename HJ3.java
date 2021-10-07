package com.chester.nowcoder.level3_hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int length = Integer.parseInt(scanner.nextLine());
            inputList.clear();
            for (int i = 0; i < length; i++) {
                int inputItem = Integer.parseInt(scanner.nextLine());
                if(inputList.contains(inputItem)){
                    continue;
                }
                inputList.add(inputItem);
            }
            Collections.sort(inputList);
            for (int item : inputList) {
                System.out.println(item);
            }
        }
    }
}
