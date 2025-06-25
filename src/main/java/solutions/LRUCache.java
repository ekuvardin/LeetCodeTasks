package solutions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Yandex
 public static void main(String[] args) {

        LRUCache t = new LRUCache(2);
        t.put(2, 1);
        t.put(1, 1);
        t.put(2, 3);
        t.put(4, 1);
        t.get(1);
        t.get(2);
    }
 */
public class LRUCache {
/*
    class LRUCache {

        final LinkedHashMap<Integer, Integer> map;
        final int maxSize;

        public LRUCache(int capacity) {
            maxSize = capacity;
            map = new LinkedHashMap<>(capacity, 0.75f, true) {

                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > maxSize;
                }
            };
        }

        public int get(int key) {
            Integer res = map.get(key);
            return res == null ? -1 : res;
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }*/
/*
    final Map<Integer, ListNode> map;
    final int maxSize;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap<>(capacity);
        head = new ListNode(-1, -1);
        head.isFirst = true;
        tail = new ListNode(-1, -1);
        tail.isLast = true;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        upVoteNode(node);

        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null) {
            node.val = value;
            upVoteNode(node);
        } else {
            if (map.size() == maxSize) {
                remove(tail.prev);
            }

            node = new ListNode(key, value);

            node.next = head.next;
            node.next.prev = node;
            node.prev = head;
            head.next = node;

            map.put(key, node);
        }
    }

    private void upVoteNode(ListNode node){
        ListNode tmpNext = node.next;
        ListNode tmpPrev = node.prev;

        if (head.next != node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;

            tmpPrev.next = tmpNext;
            tmpNext.prev = tmpPrev;
        }
    }

    private void remove(ListNode node) {
        ListNode toBeDeleted = tail.prev;
        map.remove(toBeDeleted.key);

        toBeDeleted.prev.next = tail;
        tail.prev = toBeDeleted.prev;
    }


    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        boolean isLast;
        boolean isFirst;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }*/

    final Map<Integer, ListNode> map;
    final Map<Long, ListNode> treeWeight;
    final int maxSize;
    long currentWeight;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        maxSize = capacity;
        treeWeight = new TreeMap<>();
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        treeWeight.remove(node.weight);

        upVoteNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (currentWeight == Long.MAX_VALUE) {
            rehashValues();
        }

        ListNode node = map.get(key);
        if (node != null) {
            treeWeight.remove(node.weight);
            node.value = value;
            upVoteNode(node);
            return;
        }

        if (map.size() == maxSize) {
            Map.Entry<Long, ListNode> entry = treeWeight.entrySet().iterator().next();
            map.remove(entry.getValue().key);
            treeWeight.remove(entry.getValue().weight);
        }

        node = new ListNode();
        node.key = key;
        node.value = value;
        map.put(key, node);
        upVoteNode(node);
    }

    private void rehashValues() {
        currentWeight = 0;

        for (Map.Entry<Long, ListNode> entry : treeWeight.entrySet()) {
            map.get(entry.getValue().key).weight = currentWeight;
            currentWeight++;
        }

        treeWeight.clear();

        for (Map.Entry<Integer, ListNode> entry : map.entrySet()) {
            treeWeight.put(entry.getValue().weight, entry.getValue());
        }
    }

    private void upVoteNode(ListNode node) {
        node.weight = currentWeight;
        treeWeight.put(node.weight, node);
        currentWeight++;
    }

    static class ListNode {
        int key;
        int value;
        long weight;
    }
}

