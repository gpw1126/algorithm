package scene.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Gpw
 * @Date:2020/3/26
 * @Description: LeetCode 3  无重复字符的最长子串
 *  优化的滑动窗口，使用 HashMap
 *  如果 s[j] 在 [i, j) 范围内有与 j'重复的字符，不需要逐渐增加 i ，可以直接跳过 [i，j'] 范围内的所有元素，并将 i变为 j' + 1
 */
public class lengthOfLongestSubstringWithoutRepeatedCharacter {

    public static int solution(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0;j < n;j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdecdfg"));
    }
}
