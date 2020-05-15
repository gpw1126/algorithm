package scene.NOWCODER;

import java.util.Collections;

/**
 * 腾讯编程题
 *
 *  小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连
 * 续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的
 * 字符串，你能帮助他进行解压缩么？
 *
 * 输入描述
 *  输入第一行包含一个字符串s，代表压缩后的字符串。
 *  S的长度<=1000;
 *  S仅包含大写字母、[、]、|;
 *  解压后的字符串长度不超过100000;
 *  压缩递归层数不超过10层;
 * 输出描述
 *  输出一个字符串，代表解压后的字符串。
 *
 * eg：输入HG[3|B[2|CA]]F，输出HGBCACABCACABCACAF
 *  说明：HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 */
public class compressString {

    /**
     * String.replace(char oldChar, char newChar)
     *  用newChar字符替换字符串中出现的所有oldChar字符，并返回替换后的新字符串。
     *
     * String.join()
     *  第一个参数是连接符号，第二个参数是要用此符号串联的列表
     *
     * Collections.nCopies(int n, T o)    public static <T> List<T>
     *  n-- 元素个数  o-- 反复出现的元素
     *
     * @param text
     * @return
     */
    public static String decode(String text) {

        while (text.contains("]")) {
            //找到第一个"]"的索引
            int right = text.indexOf("]");
            //从指定索引开始反向搜索，返回"["在此字符串中最后一次出现处的索引
            int left = text.lastIndexOf("[", right);
            String repeatStr = text.substring(left+1, right);
            String[] split = repeatStr.split("\\|");

            //最后两行的作用说白了就是下面的过程
            //String c = "";
            //int m = Integer.parseInt(split[0]);
            //for(int i=0;i<m;i++) c=c+split[1];
            //text = text.replace("[" + repeatStr + "]",c);
            text = text.replace("[" + repeatStr + "]",
                    String.join("", Collections.nCopies(Integer.parseInt(split[0]), split[1])));
        }
        return text;
    }

    public static void main(String[] args) {
        String text = "HG[3|B[2|CA]]F";
        System.out.println(decode(text));
    }
}
