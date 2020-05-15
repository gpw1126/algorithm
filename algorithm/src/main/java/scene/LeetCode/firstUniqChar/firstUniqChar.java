package scene.LeetCode.firstUniqChar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:Gpw
 * @Date:2020/05/11  剑指offer 50
 *  第一个只出现一次（不重复）的字符
 *
 *  若 map 中 不包含 键(key) c ：则向 map 中添加键值对 (c, True) ，代表字符 c 的数量为 1
 *  若 map 中 包含 键(key) c ：则修改键 c 的键值对为 (c, False) ，代表字符 c 的数量 > 1
 *
 *  空间复杂度 O(N) ： HashMap 需存储 N 个字符的键值对，使用 O(N) 大小的额外空间。
 *  时间复杂度：
 *   方法一 O(2N) ： N 为字符串 s 的长度；需遍历 s 两轮；
 *   方法二 O(N) ：遍历 s 一轮，遍历 map 一轮。
 */
public class firstUniqChar {

    /**
     * 方法一，使用哈希表  hashMap无序
     * @param s
     * @return
     */
    public char firstUniqChar1(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char c : arr)
            map.put(c, !map.containsKey(c));
        for(char c : arr)
            if(map.get(c)) return c;
        return ' ';
    }

    /**
     * 改进方法   LinkedHashMap有序
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        // 用 LinkedHashMap 实现有序哈希表，取值时不需要再次遍历 map
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue())
                return entry.getKey();
        }
        return ' ';
    }
}
