package StackQueue;
// 确定性 不可逆性
// NICE: less collision & low time complexion
// modulo division 除余法| mid-square 平方取中法| radix transformation基数转换法
// https://site-pictures.oss-eu-west-1.aliyuncs.com/wubbt.png
// 冲突的解决方案
// open hashing: separate chainning https://site-pictures.oss-eu-west-1.aliyuncs.com/ltorz.png 
// Graph: https://site-pictures.oss-eu-west-1.aliyuncs.com/01enh.png 
// closed hashing: open addressing https://site-pictures.oss-eu-west-1.aliyuncs.com/jcxv3.png

public class MyMapChainingHashingImpl {
    // Open Hashing | Chaining 
    private MapListNode[] data;
    private int size;
    private int capacity;
    private static final float LOAD_FACTION = 0.75f;
    
    public MyMapChainingHashingImpl() {
        capacity = 16;
        size = 0;
        data = new MapListNode[capacity];
    }
    public MyMapChainingHashingImpl(int capacity) {
        this.capacity = capacity;
        size = 0;
        data = new MapListNode[capacity];
    }
    public void put(String key, String val) {
        if(key == null) return;
        int index = key.hashCode() % capacity; // 0 - capacity-1
        if (size >= capacity * LOAD_FACTION) {
            doubleSizeAndRehash();
        }
        MapListNode cur = data[index];
        // Traverse ListNode
        while(cur != null) {
            if(cur.pair.key.equals(key)) {
                cur.pair.value = val;
                return; // after modifying ☆
            }
            cur = cur.next;
        }
        MapListNode newNode = new MapListNode(new Pair(key, val));
        // insert between the new and head
        newNode.next = data[index];
        data[index] = newNode;
        size++;
    }
    
   public String get(String key) {
       if(key == null) return null;
       int index = key.hashCode() % capacity;
       MapListNode cur = data[index];
       while(cur != null) {
           if(cur.pair.key.equals(key)) return cur.pair.value;
           cur = cur.next;
       }
       return null; // no elements paired
   }

   public void doubleSizeAndRehash() {
        int newCapacity = this.capacity * 2;
               

   }
}

class MapListNode {
    Pair pair;
    MapListNode next;

    MapListNode(Pair pair) {
        this.pair = pair;
        this.next = null;
    }
}