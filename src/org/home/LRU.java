package org.home;

import java.util.HashMap;
import java.util.Iterator;

public class LRU<K, V> implements Iterable<K> {

    //哨兵节点
    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    //内部双向链表
    private class Node {

        Node pre;
        Node next;
        K k;
        V v;

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    //构造函数
    public LRU(int maxSize) {

        this.maxSize = maxSize;
        //初始化map容量
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }


    //取缓存
    public V get(K key) {

        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        //从原位置删除
        unlink(node);
        //添加到头部
        appendHead(node);

        return node.v;
    }

    //加缓存
    public void put(K key, V value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        //加到map中
        map.put(key, node);
        //加到头部
        appendHead(node);

        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }

    //删除
    private void unlink(Node node) {

        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }

    //加到头部
    private void appendHead(Node node) {
        Node next = head.next;
        node.next = next;
        next.pre = node;
        node.pre = head;
        head.next = node;
    }

    //删除末端节点
    private Node removeTail() {

        Node node = tail.pre;

        Node pre = node.pre;
        tail.pre = pre;
        pre.next = tail;

        node.pre = null;
        node.next = null;

        return node;
    }


    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {
            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }
}

