function maxArea(height: number[]): number {
    let left = 0;
    let right = height.length - 1;
    let res = Math.min(height[left], height[right]) * (right - left);
    while (left < right) {
        // 哪边小就移动哪边
        if (height[left] > height[right]) {
            const rh = height[right];
            while (left < --right && height[right] <= rh) ;
        } else {
            const lh = height[left];
            while (++left < right && height[left] <= lh) ;
        }
        res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
    }
    return res;
}

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
