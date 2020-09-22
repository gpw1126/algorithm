package relatedKnowledge.SlideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Gpw
 * @Date:2020/3/26
 * @Description: LeetCode 3  无重复字符的最长子串  滑动窗口
 */
public class lengthOfLongestSubstringWithoutRepeatedCharacter {

    public static int solution(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                // 有重复，把窗口向后移，也就是将队列左边元素移出
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdecdfg"));
    }
}
