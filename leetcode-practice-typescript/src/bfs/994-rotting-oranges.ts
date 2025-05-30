function orangesRotting(grid: number[][]): number {
    const m = grid.length;
    const n = grid[0].length;
    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const queue: number[][] = [];

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 2) {
                queue.push([j, j]);
            }
        }
    }

    let steps = -1;
    while (queue.length) {
        steps++;
        const size = queue.length;
        for (let _ = 0; _ < size; _++) {
            const pos = queue.shift()!;
            const i = pos[0];
            const j = pos[1];
            for (const d of directions) {
                const ni = i + d[0];
                const nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] === 1) {
                    // 腐烂
                    grid[ni][nj] = 2;
                    queue.push([ni, nj]);
                }
            }
        }
    }

    // 最后检查是否还有新鲜橘子
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) return -1;
        }
    }
    return steps === -1 ? 0 : steps;
}

console.log(orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]));
