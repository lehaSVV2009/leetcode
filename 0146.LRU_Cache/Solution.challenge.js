// Both put and get mark element as least recently used
// Capacity 0?
// Capacity less than 0?
//
// Solution 1
// Map and Node as Item
// LinkedHashMap?
// LinkedList<Node> queue
// HashMap<Integer, Node> map
// put
//   if key doesn't exist - create node, add to start of queue, add to map, if queue length is greater than capacity - remove last node from queue and map
//   if key exists - change node value, bump node to top (remove + add?)
// get
//   if key doesn't exist - -1
//   if key exists - bump node to top (remove + add?)

// lru.put(1, 1)
// lru.put(2, 2)
// lru.get(1)
// lru.get(1)
// lru.get(1)

var Node = function(key, value, prev, next) {
  this.key = key;
  this.value = value;
  this.prev = prev || null;
  this.next = next || null;
}

/**
* @param {number} capacity
*/
var LRUCache = function(capacity) {
  this.capacity = capacity;
  this.map = new Map();
  this.head = null;
  this.tail = null;
};

/** 
* @param {number} key
* @return {number}
*/
LRUCache.prototype.get = function(key) {
  if (!this.map.has(key)) {
      return -1;
  }
  const node = this.map.get(key);
  this.removeFromRecent(node);
  this.addToRecent(node);
  return node.value;
};

/**
* @param {number} key 
* @param {number} value
* @return {void}
*/
LRUCache.prototype.put = function(key, value) {
  if (!this.map.has(key)) {
      const node = new Node(key, value);
      this.map.set(key, node);
      this.addToRecent(node);
  } else {
      const node = this.map.get(key);
      node.value = value;
      this.removeFromRecent(node);
      this.addToRecent(node);
  }
  if (this.map.size > this.capacity) {
      const node = this.tail;
      this.removeFromRecent(node);
      this.map.delete(node.key);
  }
};

LRUCache.prototype.addToRecent = function(node) {
  if (!this.head) {
      this.head = node;
      this.tail = node;
      return;
  }
  if (this.head === this.tail) {
      this.head = node;
      this.head.prev = this.tail;
      this.tail.next = this.head;
      return;
  }
  node.prev = this.head;
  this.head.next = node;
  this.head = node;
}

LRUCache.prototype.removeFromRecent = function(node) {
  if (!this.head) {
      return;
  }
  if (this.head === this.tail && this.head === node) {
      this.head = null;
      this.tail = null;
      return;
  }
  if (this.tail === node) {
      this.tail.next.prev = null;
      this.tail = this.tail.next;
      return;
  }
  if (this.head === node) {
      this.head.prev.next = null;
      this.head = this.head.prev;
      return;
  }
  const prev = node.prev;
  const next = node.next;
  if (prev) {
      prev.next = next;
  }
  if (next) {
      next.prev = prev;
  }
}

/** 
* Your LRUCache object will be instantiated and called as such:
* var obj = new LRUCache(capacity)
* var param_1 = obj.get(key)
* obj.put(key,value)
*/