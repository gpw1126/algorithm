package scene;

import java.util.Scanner;

/**
 * @Author:Gpw
 * @Date:2019/9/21
 * @Description:scene
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节数截取的字符串。但是要保证汉字不被截半个。
 *   例：“人ABC” 4 --> “人AB”   “人ABC们DEF” 6 --> “人ABC”而不是“人ABC+们的半个”
 * @Version:1.0
 **/
public class test6 {

    public static boolean isChinese(char c){
        String s = String.valueOf(c);
        return s.getBytes().length > 1 ? true : false;
    }

    public static String truncateStr(String str,int len){
        if(str == null || str.equals("") || len == 0)
            return "";
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder("");
        //用来记录当前截取字符的长度
        int count = 0;

        for(char cc : charArr){
            if(count < len){
                if(isChinese(cc)){
                    //如果要求截取子串长度只差一个字符，但接下来的字符是中文，则截取结果中不保存这个中文字符
                    if(count+1 == len)
                        return sb.toString();
                    count = count + 2;
                    sb = sb.append(cc);
                }else{
                    count = count + 1;
                    sb = sb.append(cc);
                }
            }else break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要截取的字符串：");
        String str = sc.nextLine();
        System.out.println("请输入截取长度：");
        int len = sc.nextInt();

        System.out.println("结果： " + truncateStr(str,len));
    }
}
