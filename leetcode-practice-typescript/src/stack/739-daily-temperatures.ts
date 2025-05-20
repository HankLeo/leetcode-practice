function dailyTemperatures(temperatures: number[]): number[] {
    // 单调递减栈
    const stack: number[] = [];
    const res: number[] = new Array(temperatures.length).fill(0);
    for (let curDay = 0; curDay < temperatures.length; curDay++) {
        while (stack.length && temperatures[stack[stack.length - 1]] < temperatures[curDay]) {
            const lastDay = stack.pop() || 0;
            res[lastDay] = curDay - lastDay;
        }
        stack.push(curDay);
    }
    return res;
}
