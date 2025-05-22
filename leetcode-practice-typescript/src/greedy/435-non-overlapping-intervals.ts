function eraseOverlapIntervals(intervals: number[][]): number {
    if (intervals.length === 1) {
        return 0;
    }
    // 按照end升序排列
    intervals.sort((a, b) => {
        return a[1] - b[1]
    });

    let cnt = 0;
    let prevEnd = intervals[0][1];
    for (let i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < prevEnd) {
            cnt++;
        } else {
            prevEnd = intervals[i][1];
        }
    }
    return cnt;
}
