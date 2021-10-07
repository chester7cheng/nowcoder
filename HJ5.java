package com.chester.nowcoder.level2_middle;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            inputList.add(scanner.nextLine().substring(2));
        }
        for (String item : inputList) {
            System.out.println(Integer.parseInt(item, 16));
        }
    }
}
