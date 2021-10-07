package com.chester.nowcoder.level4_ext;

import java.util.*;

public class HJ19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> countMap = new LinkedHashMap<>();

        //1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。
        //    最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是”相同“的错误记录。
        //2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
        //3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
        //4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
        while (scanner.hasNextLine()) {
            String[] itemArray = scanner.nextLine().split(" ");
            String fileName = itemArray[0].substring(itemArray[0].lastIndexOf('\\') + 1);
            fileName = fileName.length() > 16 ? fileName.substring(fileName.length() - 16) : fileName;
            String key = fileName + " " + itemArray[1];

            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        String[] keySet = countMap.keySet().toArray(new String[0]);
        for (int i = keySet.length > 8 ? keySet.length - 8 : 0; i < keySet.length; i++) {
                System.out.println(keySet[i] + " " + countMap.get(keySet[i]));
        }
    }
}
