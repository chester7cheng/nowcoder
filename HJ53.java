package com.chester.nowcoder.level1_simple;

import java.util.Scanner;

public class HJ53 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int lineNum = Integer.parseInt(scanner.nextLine());
            int length = computeLength(lineNum);
            int firstEvenIndex = -1;
            for (int i = 0; i < length; i++) {
                if (checkIfEven(lineNum, i)) {
                    firstEvenIndex = i + 1;
                    break;
                }
            }
            System.out.println(firstEvenIndex);
        }

    }

    private static int computeLength(int lineNum) {
        return 1 + 2 * (lineNum - 1);
    }

    private static boolean checkIfEven(int lineNum, int index) {
        if(index==0){
            return false;
        }
        if(index<0){
            return true;
        }
        int length = computeLength(lineNum);
        if(index == length-1){
            return false;
        }
        if(index>(length-1)){
            return true;
        }
        if(lineNum<=2){
            return false;
        }

        int evenCount = 0;
        if (checkIfEven(lineNum - 1, index - 2)) {
            evenCount++;
        }
        if (checkIfEven(lineNum - 1, index - 1)) {
            evenCount++;
        }
        if (checkIfEven(lineNum - 1, index)) {
            evenCount++;
        }
        return evenCount == 1 || evenCount == 3;
    }
}
