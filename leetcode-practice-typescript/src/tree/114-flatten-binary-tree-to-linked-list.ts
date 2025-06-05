import {TreeNode} from "../libs";

function flatten(root: TreeNode | null): void {
    if (root === null) {
        return;
    }
    const list: TreeNode[] = [];

    function dfs(list: TreeNode[], node: TreeNode | null): void {
        if (node === null) {
            return;
        }
        list.push(node);
        dfs(list, node.left);
        dfs(list, node.right);
    }

    dfs(list, root);
    let cur = new TreeNode();
    for (const node of list) {
        cur.left = null;
        cur.right = node;
        cur = node;
    }
}

const root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
flatten(root);
console.log(root);
