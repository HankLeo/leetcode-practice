class RecentCounter {
    private readonly EXPIRED: number = 3000;
    private readonly queue: number[];

    constructor() {
        this.queue = [];
    }

    ping(t: number): number {
        const {EXPIRED, queue} = this;
        queue.push(t); // 加入数组尾部
        while (queue.length > 0 && queue[0] < t - EXPIRED) {
            queue.shift() // 移除数组头部
        }
        return queue.length;
    }
}

const recentCounter = new RecentCounter();
console.log(recentCounter.ping(1));
console.log(recentCounter.ping(100));
console.log(recentCounter.ping(3001));
console.log(recentCounter.ping(3002));
