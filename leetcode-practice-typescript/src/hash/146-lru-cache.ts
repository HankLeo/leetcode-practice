class LRUCache {
    capacity: number;
    map: Map<number, number>;

    constructor(capacity: number) {
        this.capacity = capacity;
        this.map = new Map<number, number>();
    }

    get(key: number): number {
        if (!this.map.has(key)) {
            return -1;
        }

        // 删掉当前再插入一次
        const val = this.map.get(key)!;
        this.map.delete(key);
        this.map.set(key, val);
        return val;
    }

    put(key: number, value: number): void {
        if (this.map.has(key)) {
            // 如果有则先删
            this.map.delete(key);
        } else if (this.map.size >= this.capacity) {
            // 如果已满则删掉最老的
            const eldestKey = this.map.keys().next().value!;
            this.map.delete(eldestKey);
        }
        this.map.set(key, value);
    }
}

const lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
