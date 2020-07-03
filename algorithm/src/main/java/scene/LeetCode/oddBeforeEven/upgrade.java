package scene.LeetCode.oddBeforeEven;

/**
 * @Author:Gpw
 * @Date:2020/4/24
 * @Description:scene.LeetCode.oddBeforeEven   腾讯笔试题，要保证相对位置不变
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间，1<=s.length<=1000
 *
 * 解法：如果碰到大写，就插入到字符串的最后面
 */
public class upgrade {

    public static String solution(String s) {
        int len = s.length();
        int end = len - 1;
        char[] a = s.toCharArray();
        //循环里的i不能自增，需要在之后判断完根据情况自增
        for (int i = 0;i <= end;) {
            if (a[i] >= 'A' && a[i] <= 'Z') {
                char temp = a[i];
                //用index保存i是因为之后整体后移时i会变
                int index = i;
                for (int j = i + 1;j < len;j ++) {
                    a[index ++] = a[j];
                }
                a[len - 1] = temp;
                end --;
            }
            else {
                i ++;
            }
        }
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        String s = solution("AkleBiCeilD");
        System.out.println(s);
    }
}
