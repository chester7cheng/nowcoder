package com.chester.nowcoder.level2_middle;

import java.util.Scanner;

public class HJ21 {


    public static void main(String[] args) {
//        String str = encrypt("YUANzhi1987");
//        System.out.println(str);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = encrypt(scanner.nextLine());
            System.out.println(str);
        }
    }

    /**
     * 大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
     * <p>
     * 数字和其他的符号都不做变换，
     * 渊子把密码中出现的小写字母都变成对应的数字，
     * 而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，
     * z往后移是a哦。
     */
    private static String encrypt(String param) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            char item = param.charAt(i);
            if (item >= 'a' && item <= 'z') {
                switch (item) {
                    case 'a':
                    case 'b':
                    case 'c':
                        item = '2';
                        break;
                    case 'd':
                    case 'e':
                    case 'f':
                        item = '3';
                        break;
                    case 'g':
                    case 'h':
                    case 'i':
                        item = '4';
                        break;
                    case 'j':
                    case 'k':
                    case 'l':
                        item = '5';
                        break;
                    case 'm':
                    case 'n':
                    case 'o':
                        item = '6';
                        break;
                    case 'q':
                    case 'p':
                    case 'r':
                    case 's':
                        item = '7';
                        break;
                    case 't':
                    case 'u':
                    case 'v':
                        item = '8';
                        break;
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                        item = '9';
                        break;
                }
                sb.append(item);
                continue;
            }
            if (item >= 'A' && item <= 'Z') {
                if (item == 'Z') {
                    item = 'a';
                } else {
                    item = (char) (item + 32 + 1);
                }
                sb.append(item);
                continue;
            }
            sb.append(item);
        }
        return sb.toString();
    }
}
