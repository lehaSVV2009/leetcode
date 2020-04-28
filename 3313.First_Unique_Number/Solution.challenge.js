// Map, LinkedList, Node
// 

class Node {
    constructor (value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

/**
 * @param {number[]} nums
 */
var FirstUnique = function(nums) {
    this.firstHeadNode = new Node(-1);
    this.firstTailNode = new Node(-1);
    this.head = this.firstHeadNode;
    this.tail = this.firstTailNode;
    this.tail.next = this.head;
    this.head.prev = this.tail;

    this.map = new Map();

    if (Array.isArray(nums)) {
        nums.forEach(number => this.add(number));        
    }
};

/**
 * @return {number}
 */
FirstUnique.prototype.showFirstUnique = function() {
    return this.tail.next === this.head ? -1 : this.tail.next.value;
};

/** 
 * @param {number} value
 * @return {void}
 */
FirstUnique.prototype.add = function(value) {
    if (this.map.has(value)) {
        const node = this.map.get(value);
        if (node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.map.set(value, null);
        }
    } else {
        const node = new Node(value);
        this.map.set(value, node);
        const prev = this.head.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.head;
        this.head.prev = node;
    }
};

/** 
 * Your FirstUnique object will be instantiated and called as such:
 * var obj = new FirstUnique(nums)
 * var param_1 = obj.showFirstUnique()
 * obj.add(value)
 */