function decodeString(s: string): string {
    const strStack: string[] = []; // 字符串栈
    const numStack: number[] = []; // 数字栈
    let curStr: string = '';
    let curNum: number = 0;

    for (const c of s) {
        if (!isNaN(Number(c))) {
            // 是数字
            curNum = 10 * curNum + Number(c);
        } else if (c === '[') {
            // 将当前数字和字符入栈，并重置
            strStack.push(curStr);
            numStack.push(curNum);
            curStr = '';
            curNum = 0;
        } else if (c === ']') {
            // 将字符串和数字出栈并拼接当前字符
            curStr = strStack.pop() + curStr.repeat(numStack.pop() || 0);
        } else {
            // 是字符
            curStr += c;
        }
    }

    // 最终全部出栈
    return curStr;
}
