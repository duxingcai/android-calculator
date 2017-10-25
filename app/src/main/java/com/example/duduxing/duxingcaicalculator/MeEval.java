package com.example.duduxing.duxingcaicalculator;

/**
 * Created by duduxing on 2017/10/06.
 */

import java.util.ArrayList;
import java.util.Stack;

public class MeEval {

    private final static String ERR_NOT_END_VALID = "The last character of your expression MUST be '#'!";
    private final static String ERR_PARENTHESE_NOT_PAIR = "'(' & ')' should be used in pair!";
    private final static String ERR_CHAR_NOT_SUPPORT = "Not supported character";
    private final static String ERR_OPERATION_NOT_SUPPORTED = "Not supported operation";
    private final static String ERR_OPERATOR_NOT_VALID = " doesn't support double data!";
    private final static String ERR_UNKNOWN = "An unknown error!";

    private static boolean flag_double;

    /*
     * expression must be end with =
     */
    public static String eval(String expression) {

        ArrayList<String> list;
        try {
            list = toSuffixSequence(expression);
            return calculate(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isResultDouble(){
        return flag_double;
    }
//start
public static boolean isfs(){
    return flag_double;
}
    private static String calculate(ArrayList<String> list) throws Exception {
        Stack<String> stack = new Stack<String>();
        for (String s : list) {
            if (isOperator(s)) {
                String d1 = stack.pop();
                String d2 = stack.pop();
                String res = doCalc(d2, d1, s);
                stack.push(res);
            } else
                stack.push(s);
        }

        if (stack.size() == 1)
            return stack.pop();
        else
            throw new Exception(ERR_UNKNOWN);
    }

    private static String doCalc(String d1, String d2, String oper) throws Exception {
        if (oper != null && oper.length() > 1)
            throw new Exception(ERR_OPERATION_NOT_SUPPORTED + ":'" + oper + "'");

        flag_double = isDoubleNeeded(d1, d2, oper);

        //运算符逻辑判断
        switch (oper.charAt(0)) {
            case '+':
                if (flag_double)
                    return Double.toString(Double.parseDouble(d1)
                            + Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1)
                            + Integer.parseInt(d2));
            case '-':
                if (flag_double)
                    return Double.toString(Double.parseDouble(d1)
                            - Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1)
                            - Integer.parseInt(d2));
            case '×':
                if (flag_double)
                    return Double.toString(Double.parseDouble(d1)
                            * Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1)
                            * Integer.parseInt(d2));
            case '÷':
                if (flag_double)
                    return Double.toString(Double.parseDouble(d1)
                            / Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1)
                            / Integer.parseInt(d2));
            case '%':
                if (flag_double)
                    throw new Exception("'%' " + ERR_OPERATOR_NOT_VALID);
                else
                    return Integer.toString(Integer.parseInt(d1)
                            + Integer.parseInt(d2));
            default:
                throw new Exception(ERR_OPERATION_NOT_SUPPORTED + ":'" + oper + "'");
        }
    }

    private static boolean isDoubleNeeded(String d1, String d2, String oper) {
        if (d1.contains(".") || d2.contains("."))
            return true;
        if (oper != null && oper.equals("/")) {
            int left = Integer.parseInt(d1) % Integer.parseInt(d2);
            if (left != 0)
                return true;
        }
        return false;
    }

    private static boolean isOperator(String str) {
        if (str != null
                && (str.equals("+") || str.equals("-") || str.equals("×")
                || str.equals("÷") || str.equals("%")))
            return true;
        return false;
    }

    private static ArrayList<String> toSuffixSequence(String expression)
            throws Exception {

        if (!expression.endsWith("="))
            throw new Exception(ERR_NOT_END_VALID);

        ArrayList<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        stack.push("=");
        char last, ch;
        StringBuffer sb = null;
        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);
            switch (ch) {

                case '+':
                case '-':
                case '×':
                case '÷':
                case '%':
                    last = stack.peek().charAt(0);
                    if (last != '(' && priority(last) >= priority(ch))
                        list.add(stack.pop());
                    stack.push("" + ch);
                    break;
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek().charAt(0) != '(')
                        list.add(stack.pop());
                    if (stack.isEmpty() || stack.size() == 1)
                        throw new Exception(ERR_PARENTHESE_NOT_PAIR);
                    stack.pop();
                    break;
                case '=':
                    while (stack.size() > 1 && stack.peek().charAt(0) != '(')
                        list.add(stack.pop());
                    if (stack.size() > 1)
                        throw new Exception(ERR_PARENTHESE_NOT_PAIR);
                    break;
                default:
                    if (Character.isDigit(ch) || '.' == ch) {
                        sb = new StringBuffer();
                        sb.append(ch);
                        while (Character.isDigit(expression.charAt(i+1)) || expression.charAt(i+1) == '.')
                            sb.append(expression.charAt(++i));

                        list.add(sb.toString());
                        break;
                    } else
                        throw new Exception(ERR_CHAR_NOT_SUPPORT + ":'" + ch + "'");

            }
        }
        return list;
    }

    //算数优先级
    private static int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '×':
            case '÷':
            case '%':
                return 2;
            case '=':
                return 0;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {}
}