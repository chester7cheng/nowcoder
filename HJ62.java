package com.chester.nowcoder.level1_simple;

import java.util.Scanner;

public class HJ62 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int input = Integer.parseInt(scanner.nextLine());
            char[] charArray = Integer.toBinaryString(input).toCharArray();
            int count = 0;
            for(char item:charArray){
                if(item == '1'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
