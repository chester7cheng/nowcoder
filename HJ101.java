package com.chester.nowcoder.level0_intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HJ101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int order;

        length = Integer.parseInt(scanner.nextLine());
        String[] dataArray = scanner.nextLine().split(" ");
        for (int i = 0; i < length; i++) {
            arrayList.add(Integer.valueOf(dataArray[i]));
        }
        Collections.sort(arrayList);
        order = scanner.nextInt();

        if (order == 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i).toString());
                if (i < arrayList.size() - 1) {
                    System.out.print(" ");
                }
            }
        } else {
            for (int i = arrayList.size()-1; i >= 0; i--) {
                System.out.print(arrayList.get(i));
                if (i > 0) {
                    System.out.print(" ");
                }
            }
        }
    }
}
