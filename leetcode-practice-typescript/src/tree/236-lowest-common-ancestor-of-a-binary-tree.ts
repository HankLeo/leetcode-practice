import {TreeNode} from "../libs";

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
    if (root === null || root === p || root === q) {
        return root;
    }
    const leftRoot = lowestCommonAncestor(root.left, p, q);
    const rightRoot = lowestCommonAncestor(root.right, p, q);
    if (leftRoot && rightRoot) {
        return root;
    } else {
        return leftRoot || rightRoot;
    }
}
