package relatedKnowledge.LRU.LRUCacheManual;

public class LRUNode {

    String key;
    Object value;
    LRUNode prev;
    LRUNode next;

    LRUNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
