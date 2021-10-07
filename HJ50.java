package com.chester.nowcoder.level1_simple;

import java.util.*;

/*
四则运算
 */
public class HJ50 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String inputStr = scanner.nextLine();

        String inputStr = "\"3+2*3*4-1\"";
        inputStr = inputStr.substring(1,inputStr.length()-1);
        List<String> suffixExp = infixToSuffixExp(inputStr);
        int result = calculate(suffixExp);
        System.out.println(result);
    }

    /**
     * 四则运算问题，优先使用栈及逆波兰算法
     * 1. 先从中缀符号转为后缀符号
     * 2. 使用后缀符号计算表达式
     */
    private static int calculate(List<String> paramList) {
        Stack<Integer> stack = new Stack<>();
        for (String item : paramList) {
            switch (item) {
                case "/":
                    int divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "-":
                    int minuend = stack.pop();
                    stack.push(stack.pop() - minuend);
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(item));
                    break;
            }
        }
        return stack.pop();
    }

    private static List<String> infixToSuffixExp(String param) {
        param = param.replaceAll("\\{|\\[", "(").replaceAll("}|]", ")");
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        Map<Character, Integer> operatorMap = new HashMap<>();
        operatorMap.put('*', 1);
        operatorMap.put('/', 1);
        operatorMap.put('+', 2);
        operatorMap.put('-', 2);

        List<String> resultList = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        boolean isOperator = operatorMap.containsKey(param.charAt(0));
        for (int i = 0; i < param.length(); i++) {
            char item = param.charAt(i);

            //数字
            if (item >= '0' && item <= '9') {
                StringBuilder sb = new StringBuilder();
                int ii = i;
                while (ii < param.length() && (param.charAt(ii) >= '0' && param.charAt(ii) <= '9')) {
                    sb.append(param.charAt(ii));
                    ii++;
                }
                resultList.add(sb.toString());
                isOperator = false;
                i = --ii;
                continue;
            }

            //括号
            if (stack.empty() || bracketMap.containsValue(item)) {
                stack.push(item);
                continue;
            }
            if (bracketMap.containsKey(item)) {
                while (!stack.peek().equals(bracketMap.get(item))) {
                    resultList.add(String.valueOf(stack.pop()));
                }
                stack.pop();
                continue;
            }

            //运算符
            if (operatorMap.containsKey(item)) {
                if (isOperator && item=='-') {
                    resultList.add("0");
                }
                isOperator = true;
            }
            while (!stack.empty() && operatorMap.containsKey(stack.peek()) && operatorMap.get(stack.peek()) <= operatorMap.get(item)) {
                resultList.add(String.valueOf(stack.pop()));
            }
            stack.push(item);
        }
        while (!stack.empty()) {
            resultList.add(String.valueOf(stack.pop()));
        }
        return resultList;
    }
}


