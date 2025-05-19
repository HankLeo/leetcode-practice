function reverseVowels(s: string): string {
    const targets = 'AEIOUaeiou';
    const arr = s.split('');
    let left = 0;
    let right = s.length - 1;
    while (left < right) {
        if (!targets.includes(arr[left])) {
            left++;
            continue;
        }
        if (!targets.includes(arr[right])) {
            right--;
            continue;
        }
        [arr[left], arr[right]] = [arr[right], arr[left]];
        left++;
        right--;
    }
    return arr.join('');
}

console.log(reverseVowels('hello'));
