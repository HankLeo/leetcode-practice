function findMinArrowShots(points: number[][]): number {
    points.sort((a, b) => a[1] - b[1]); // 按照右边界从小到大排列
    let arrows = 1;
    let x = points[0][1];
    for (const balloon of points) {
        if (balloon[0] > x) {
            // 如果当前气球的左边界大于上一个箭的右边界，需要再射一箭
            arrows++;
            x = balloon[1]; // 更新箭的右边界
        }
    }
    return arrows;
}

console.log(findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]]))
