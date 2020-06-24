package relatedKnowledge.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap已经实现删除最近最少使用的元素的方法 removeEldestEntry
 * public LinkedHashMap(int initialCapacity,
 *                          float loadFactor,
 *                          boolean accessOrder) {
 *         super(initialCapacity, loadFactor);
 *         this.accessOrder = accessOrder;
 *     }
 * accessOrder属性在其他的构造函数中是默认为false，设为true，就实现了LRU功能
 *
 */
public class LRUCache {

    public static void main(String[] args) {
        int capacity = 3;
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<String, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                // 容量大于capacity 时就删除
                return size() > capacity;
            }
        };
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);

        for (String key : cache.keySet()) {
            System.out.println(key);
        }
    }
}
