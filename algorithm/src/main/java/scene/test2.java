package scene;

import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2019/8/1
 * @Description: PACKAGE_NAME
 * 给定一个仅由小写字母组成的字符串。现在请找出一个位置，删掉那个字母之后，字符串变成回文。请放心总会有一个合法的解。如果
 * 给定的字符串已经是一个回文串，那么输出-1。
 * 输出描述:
 * 如果可以删去一个字母使它变成回文串，则输出任意一个满足条件的删去字母的位置（下标从0开始）
 * 例如：bcc,我们可以删掉位置0的b字符。
 * 示例1
 * 输入
 * 3
 * aaab
 * baa
 * aaa
 * 输出
 * 3
 * 0
 * -1
 * @Version: 1.0
 */
public class test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = sc.next();
        }
        for(int i = 0; i < n; i++){
            findIndex(str[i]);
        }
    }

    public static void findIndex(String str){
        char[] strCharArr = str.toCharArray();

        int len = str.length();
        int left = 0;
        int right = len - 1;

        while(left <= right && strCharArr[left] == strCharArr[right]){
            left++;
            right--;
        }

        int index = 0;
        if(left > right) index = -1;
        else if(strCharArr[left+1] == strCharArr[right]) index = left;
        else if(strCharArr[left] == strCharArr[right-1]) index = right;

        System.out.println(index);
    }
}