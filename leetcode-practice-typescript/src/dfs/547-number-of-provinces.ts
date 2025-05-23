function findCircleNum(isConnected: number[][]): number {
    const n = isConnected.length;
    const visited: boolean[] = new Array(n).fill(false);
    let count = 0;

    function dfs(city: number) {
        for (let neighbor = 0; neighbor < n; neighbor++) {
            if (isConnected[city][neighbor] === 1 && !visited[neighbor]) {
                visited[neighbor] = true;
                dfs(neighbor);
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            dfs(i);
            count++;
        }
    }

    return count;
}
