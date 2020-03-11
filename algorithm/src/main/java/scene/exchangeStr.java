package scene;

/**
 * @Author:Gpw
 * @Date:2019/9/22
 * @Description:test
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * @Version:1.0
 **/
public class exchangeStr {
    public static String solution(String str){
        String[] strArr = str.split(" ");
        StringBuffer sb = new StringBuffer("");
        for(int i = 0;i < strArr.length-1;i++){
            sb.append(strArr[i]+"%20");
        }
        sb.append(strArr[strArr.length-1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "We Are Happy haha hei";
        System.out.println(solution(str));
    }
}
