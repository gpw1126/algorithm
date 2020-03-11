package scene;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Gpw
 * @Date: 2019/8/2
 * @Description: PACKAGE_NAME
 * 括号配对问题
 * 输入描述:
 * 给定一个字符串S，请检查该字符串的括号是否配对，只含有"[", "]", "(", ")"
 * 输出描述:
 * 配对，返回true
 * 不配对，返回false
 * 输入
 * abcd(])[efg
 * 输出
 * false
 * @Version: 1.0
 */
public class test4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] strCharArr = str.toCharArray();

        Stack stack = new Stack();

        for(int i = 0;i < strCharArr.length;i++){
            if(strCharArr[i] == '(' || strCharArr[i] == '[')
                stack.push(strCharArr[i]);
            else if(strCharArr[i] == ')'){
                if(!stack.empty() && stack.peek().equals('('))
                    stack.pop();
                else {
                    System.out.println(false);
                    return;
                }
            }
            else if(strCharArr[i] == ']'){
                if(!stack.empty() && stack.peek().equals('['))
                    stack.pop();
                else {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(stack.empty());
    }
}
