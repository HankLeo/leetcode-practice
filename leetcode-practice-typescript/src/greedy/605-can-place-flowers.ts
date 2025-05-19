function canPlaceFlowers(flowerbed: number[], n: number): boolean {
    if (n === 0) {
        return true;
    }
    for (let i = 0; i < flowerbed.length; i++) {
        const afterZero: boolean = i === 0 || flowerbed[i - 1] === 0;
        const beforeZero: boolean =
            i === flowerbed.length - 1 || flowerbed[i + 1] === 0;
        if (flowerbed[i] === 0 && afterZero && beforeZero) {
            n--;
            flowerbed[i] = 1;
            if (n === 0) {
                return true;
            }
        }
    }
    return false;
}

canPlaceFlowers([1, 0, 0, 0, 1], 1);
