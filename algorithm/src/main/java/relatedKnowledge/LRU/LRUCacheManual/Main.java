package relatedKnowledge.LRU.LRUCacheManual;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        LRUCacheManual cache = new LRUCacheManual(6);
        cache.put("a", 1);
        cache.put("b", "two");
        cache.put("c", 'C');
        cache.put("d", '4');
        cache.put("e", 'e');
        cache.put("f", 1.0f);
        System.out.println("原链表为：");
        cache.traversAllNode();

        System.out.println();
        cache.get("c");
        cache.put("g", "gpw");
        System.out.println("相关处理后的链表为：");
        cache.traversAllNode();

        // 检查map中的映射情况是否正确
        System.out.println();
        for (Map.Entry<String, LRUNode> entry : cache.getMap().entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
