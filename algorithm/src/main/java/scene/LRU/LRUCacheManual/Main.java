package scene.LRU.LRUCacheManual;

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
    }
}
