import {TreeNode} from '../libs';

function pathSum(root: TreeNode | null, targetSum: number): number {
    if (root == null) {
        return 0;
    }

    function pathSumWithRoot(root: TreeNode | null, targetSum: number): number {
        if (root == null) {
            return 0;
        }
        let cnt = 0;
        if (targetSum === root.val) {
            cnt++;
        }
        return (
            cnt +
            pathSumWithRoot(root.left, targetSum - root.val) +
            pathSumWithRoot(root.right, targetSum - root.val)
        );
    }

    return (
        pathSumWithRoot(root, targetSum) +
        pathSum(root.left, targetSum) +
        pathSum(root.right, targetSum)
    );
}

pathSum(
    new TreeNode(
        10,
        new TreeNode(
            5,
            new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
            new TreeNode(2, null, new TreeNode(1)),
        ),
        new TreeNode(-3, null, new TreeNode(11)),
    ),
    8,
);
