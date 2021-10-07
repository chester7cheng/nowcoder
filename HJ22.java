package com.chester.nowcoder.level1_simple;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            int emptyAmount = Integer.parseInt(scanner.nextLine());
            if (emptyAmount == 0) {
                break;
            }
            inputList.add(emptyAmount);
        }
        for(Integer item:inputList){
            int drinkAmount = exchangeDrink(item);
            System.out.println(drinkAmount);
        }
    }

    public static int exchangeDrink(int emptyAmount) {
        if (emptyAmount == 2) {
            return 1;
        }
        if (emptyAmount < 2) {
            return 0;
        }

        int drinkAmount = emptyAmount / 3;
        emptyAmount = drinkAmount + emptyAmount % 3;
        return drinkAmount + exchangeDrink(emptyAmount);

    }
}
