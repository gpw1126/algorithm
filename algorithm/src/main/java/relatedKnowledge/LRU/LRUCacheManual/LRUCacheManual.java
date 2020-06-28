package relatedKnowledge.LRU.LRUCacheManual;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 手动实现LRU
 *
 * 基于 双向链表 + 哈希表组成，其中双向链表由哈希链表节点构成
 * （1）访问节点时，将其从原来位置删除，插入到双向链表头部；
 * （2）更新节点时，先删除原有缓存数据（即原有节点），然后更新map映射，再将更新值作为节点插入链表头；更新后，判断容量是否超过最大内存使用量
 * （3）超过则执行淘汰；淘汰即删除双向链表最后一个节点，同时删除map中的映射
 * （4）LRU实现中有频繁的查找节点并删除，为节省时间（链表查找目标节点需要遍历），使用HashMap保存键-节点映射关系，O(1)的查找+O(1)的删除
 * （5）LRU实现中，要频繁的在头部插入，以及在尾部删除；因此，需要定义head、tail两个节点，方便操作
 */
@Data
public class LRUCacheManual {

    private LRUNode head;
    private LRUNode tail;
    private Map<String, LRUNode> map;
    private int capacity;

    public LRUCacheManual(int capacity) {
        this.capacity = capacity;
        // HashMap初始容量设置为 maxSize * 4/3，即达到最大可用内存时，HashMap也不会自动扩容浪费空间
        this.map = new HashMap<>(capacity * 4 / 3);

        head = new LRUNode("head", 0);
        tail = new LRUNode("tail", 0);
        head.next = tail;
        tail.prev = head;
    }

    // 获取指定数据
    public Object get(String key) {

        // 判断是否存在对应数据
        if (!map.containsKey(key)) {
            return null;
        }

        // 将最新访问的数据移动到链表头
        LRUNode node = map.get(key);
        remove(node);
        addFirst(node);

        return node.value;
    }

    public void put(String key, Object value) {
        // 若存在就数据则删除
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            remove(node);
        }

        // 新结点插入链表头
        LRUNode node = new LRUNode(key, value);
        map.put(key, node);
        addFirst(node);

        // 判断是否需要淘汰数据
        if (map.size() > capacity) {
            LRUNode node1 = removeLast();
            // 结点淘汰后，删除map中的映射
            map.remove(node1.key);
        }
    }

    // 将指定节点置于链表头
    public void addFirst(LRUNode node) {
        LRUNode next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    // 从链表中删除指定结点
    public void remove(LRUNode node) {
        LRUNode prev = node.prev;
        LRUNode next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }

    // 淘汰数据
    public LRUNode removeLast() {
        // 最近最久未使用的结点
        LRUNode node = tail.prev;
        // 淘汰该结点
        remove(node);
        return node;
    }

    // 遍历所有结点
    public void traversAllNode() {
        LRUNode node = head.next;
        while (node != null && node.key != "tail") {
            System.out.println(node.key + "  " + node.value);
            node = node.next;
        }
    }

}
