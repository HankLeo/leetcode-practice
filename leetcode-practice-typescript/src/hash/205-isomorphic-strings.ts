function isIsomorphic(s: string, t: string): boolean {
    if (s.length !== t.length) {
        return false;
    }
    if (s.length === 1) {
        return s === t;
    }

    const stMapping = new Map<string, string>();
    const tsMapping = new Map<string, string>();
    for (let i = 0; i < s.length; i++) {
        const sChar = s[i];
        const tChar = t[i];
        if (stMapping.has(sChar)) {
            if (tChar !== stMapping.get(sChar)) {
                return false;
            }
        } else if (tsMapping.has(tChar)) {
            // stMapping没有但tsMapping却有
            return false;
        } else {
            stMapping.set(sChar, tChar);
            tsMapping.set(tChar, sChar);
        }
    }
    return true;
}

console.log(isIsomorphic("badc", "baba"));
console.log(isIsomorphic("paper", "title"));
