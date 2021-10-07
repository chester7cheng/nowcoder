package com.chester.nowcoder.level2_middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ26 {

    public static void main(String[] args) {
//        String result = sortToString("A Famous Saying: Much Ado About Nothing (2012/8).".toCharArray());
//        System.out.println(result);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String result = sortToString(scanner.nextLine().toCharArray());
            System.out.println(result);
        }
    }

    /**
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 如，输入： Type 输出： epTy
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 如，输入： BabA 输出： aABb
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     * 如，输入： By?e 输出： Be?y
     */
    private static String sortToString(char[] inputCharArray) {
        List<Character> letterList = new ArrayList<>();
        for (int i = 0; i < inputCharArray.length; i++) {
            char item = inputCharArray[i];
            if ((item >= 'A' && item <= 'Z')) {
                item = (char) (item +  32);
            }
            if ((item >= 'a' && item <= 'z')) {
                if (letterList.contains(item)) {
                    continue;
                }
                letterList.add(item);
            }
        }
        Collections.sort(letterList);

        StringBuilder sb = new StringBuilder();
        List<Character> tmpLetterList = sliceSameCharArray(inputCharArray, letterList.remove(0));
        for (int i = 0; i < inputCharArray.length; i++) {
            char item = inputCharArray[i];
            //非字符
            if (!(item >= 'A' && item <= 'Z') && !(item >= 'a' && item <= 'z')) {
                sb.append(item);
                continue;
            }

            sb.append(tmpLetterList.remove(0));
            if (tmpLetterList.size() == 0 && letterList.size() > 0) {
                tmpLetterList = sliceSameCharArray(inputCharArray, letterList.remove(0));
            }
        }
        return sb.toString();
    }

    private static List<Character> sliceSameCharArray(char[] inputList, char currentChar) {
        List<Character> resultList = new ArrayList<>();
        for (char item : inputList) {
            if (item == currentChar || item + 32 == currentChar) {
                resultList.add(item);
            }
        }
        return resultList;
    }
}

