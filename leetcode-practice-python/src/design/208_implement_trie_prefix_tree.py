class Trie:

    def __init__(self):
        self.children = [None] * 26
        self.isLeaf = False

    def insert(self, word: str) -> None:
        cur = self
        for c in word:
            index = ord(c) - ord("a")
            if not cur.children[index]:
                cur.children[index] = Trie()
            cur = cur.children[index]
        cur.isLeaf = True

    def search(self, word: str) -> bool:
        cur = self
        for c in word:
            index = ord(c) - ord("a")
            if not cur.children[index]:
                return False
            cur = cur.children[index]
        return cur.isLeaf

    def starts_with(self, prefix: str) -> bool:
        cur = self
        for c in prefix:
            index = ord(c) - ord("a")
            if not cur.children[index]:
                return False
            cur = cur.children[index]
        return True


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))
    print(trie.search("app"))
    print(trie.starts_with("app"))
