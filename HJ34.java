package com.chester.nowcoder.level2_middle;

import java.util.*;

public class HJ34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            char[] charArray =  scanner.nextLine().toCharArray();
            Arrays.sort(charArray);
            System.out.println(charArray);
        }
    }
}
