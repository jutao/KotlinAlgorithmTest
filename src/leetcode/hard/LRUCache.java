package hard;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/31
 * description：146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * ****************************************
 */

public class LRUCache {
    private LinkedHashMap<Integer, Integer> linkedHashMap;
    private LinkedList<Integer> linkedList;
    private int capacity;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap(capacity);
        linkedList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (key <= 0) {
            return -1;
        }
        Integer integer = linkedHashMap.get(key);
        if (integer == null) {
            return -1;
        }
        linkedList.remove(Integer.valueOf(key));
        linkedList.offer(key);
        return integer;
    }

    public void put(int key, int value) {
        int index = get(key);
        if(index!=-1){
            linkedHashMap.put(key,value);
            return;
        }
        if (linkedHashMap.size() == capacity) {
            Integer pop = linkedList.pop();
            linkedHashMap.remove(pop);
        }
        linkedList.offer(key);
        linkedHashMap.put(key, value);
    }
}
