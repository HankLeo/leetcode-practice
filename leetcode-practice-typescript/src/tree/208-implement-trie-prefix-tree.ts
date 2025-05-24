class Trie {
    private readonly root: { [key: string]: any };

    constructor() {
        this.root = {};
    }

    insert(word: string): void {
        let node = this.root;
        for (const c of word) {
            if (!node[c]) {
                node[c] = {};
            }
            node = node[c];
        }
        node.isLeaf = true; // 标记为单词结尾
    }

    search(word: string): boolean {
        let node = this.root;
        for (const c of word) {
            if (!node[c]) return false;
            node = node[c];
        }
        return node.isLeaf === true;
    }

    startsWith(prefix: string): boolean {
        let node = this.root;
        for (const c of prefix) {
            if (!node[c]) return false;
            node = node[c];
        }
        return true;
    }
}

const trie = new Trie();
trie.insert("apple");
console.log(trie.search("apple"));   // 返回 True
console.log(trie.search("app"));     // 返回 False
console.log(trie.startsWith("app")); // 返回 True
trie.insert("app");
console.log(trie.search("app"));     // 返回 True
