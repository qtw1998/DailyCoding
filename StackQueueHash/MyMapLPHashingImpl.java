package StackQueueHash;

public class MyMapLPHashingImpl {
    private Pair[] data;
    private int capacity = 0;

    public MyMapLPHashingImpl() {
        capacity = 16;
        data = new Pair[capacity];
    }
    public MyMapLPHashingImpl(int capacity) {
        this.capacity = capacity;
        data = new Pair[capacity];
    }
    public void put(String key, String val) {
        if(key == null) return;
        
        int index = key.hashCode() % capacity;
        for(int i = 0; i < capacity; i++) { // i: step from the present position
            int cur = (i + index) % capacity; // index % capacity: present position
            if(data[cur] == null) {
                data[cur] = new Pair(key, val); // none: straightly create one Pair
                return;
            } else if(data[cur].key.equals(key)) { // equal: modify
                data[cur].value = val;
                return;
            }
        }
        throw new IllegalStateException("HashMap is already full.");
    }

    public String get(String key) {
        if(key == null) return null;
        int index = key.hashCode() % capacity;
        for(int i = 0; i < capacity; i++) {
            int cur = (index + i) % capacity;
            if(data[cur].key.equals(key)) { 
                return data[cur].value;
            } else if(data[cur] == null) { // if pointer is at null, NO MORE!!
                return null;
            }
        }
        return null;
    }
}