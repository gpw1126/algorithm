package scene;

/**
 * @Author:Gpw
 * @Date:2019/10/14
 * @Description:scene.FirstNotRepeatingChar
 * 题目描述：
 *  在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回-1（需要区分大小写）
 *
 * 思考
 *  根据ascii码，A~Z：65~90；a~z：97~122。建立一个长度为58（0 ~ 122-65=57）的哈希表数组，索引为字符ascii码-65，值为出现的次数。
 *  时间复杂度为O(n).
 * @Version:1.0
 */
public class FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str){

        if(str.length() == 0)
            return -1;

        int[] hash = new int[58];
        for(int i = 0;i < str.length();i++)
            hash[(int)str.charAt(i)-65]++;

        for(int i = 0;i < str.length();i++){
            if(hash[(int)str.charAt(i)-65] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "sahfgbaihsgashf";
        System.out.println(FirstNotRepeatingChar(str) + "..." + str.charAt(FirstNotRepeatingChar(str)));
    }
}
