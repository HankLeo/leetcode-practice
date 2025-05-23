import {TreeNode} from "../libs";

function maxDepthDFS(root: TreeNode | null): number {
    if (!root) return 0;
    let leftH = maxDepthDFS(root.left);
    let rightH = maxDepthDFS(root.right);
    return Math.max(leftH, rightH) + 1;
}

function maxDepthBFS(root: TreeNode | null): number {
    if (root === null) {
        return 0;
    }
    const queue: TreeNode[] = [];
    queue.push(root);
    let depth = 0;
    while (queue.length !== 0) {
        depth++;
        let cnt = queue.length;
        for (let i = 0; i < cnt; i++) {
            const node = queue.shift()!;
            if (node.left) {
                queue.push(node.left);
            }
            if (node.right) {
                queue.push(node.right);
            }
        }
    }
    return depth;
}

const root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
console.log(maxDepthDFS(root));
console.log(maxDepthBFS(root));
