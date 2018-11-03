class LRUCache {

    int capacity;
    Map<Integer,DLinkedList> map = new HashMap<Integer,DLinkedList>();
    DLinkedList head;
    DLinkedList tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;          
    }
    
    public void deleteNode(DLinkedList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addNodeToHead(DLinkedList node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public int get(int key) {
        if(map.get(key) == null)
            return -1;
        
        DLinkedList node = map.get(key);
        this.deleteNode(node);
        this.addNodeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){ 
            DLinkedList node = map.get(key);
            node.val = value;
            this.deleteNode(node);
            this.addNodeToHead(node);
        }else{
            DLinkedList node = new DLinkedList();
            node.val = value;
            node.key = key;
            map.put(key,node);
            
            if(capacity < map.size()){
                map.remove(tail.prev.key);
                this.deleteNode(tail.prev);
            }
            this.addNodeToHead(node);
        }
        
    }
    
    class DLinkedList{
        int val;
        int key;
        DLinkedList prev;
        DLinkedList next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
