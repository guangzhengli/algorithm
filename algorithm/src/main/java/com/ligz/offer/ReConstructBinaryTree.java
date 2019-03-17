package com.ligz.offer;

import com.ligz.datastructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * author:ligz
 */
public class ReConstructBinaryTree {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return binaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * 构建二叉树
     * @param pre   前序数组
     * @param pl    前序数组左边界
     * @param pr    前序数组右边界
     * @param inl   中序数组的左边界
     * @return
     */
    private TreeNode binaryTree(int[] pre, int pl, int pr, int inl) {
        if (pl > pr) return null;

        TreeNode root = new TreeNode(pre[pl]);//按前序遍历的数组确认当前值
        int inIndex = map.get(root.val);//获取在中序遍历的位置，左边为左子树的中序遍历，右边为右子树的中序遍历
        int leftTreeSize = inIndex - inl;//获取左子树的大小
        root.left = binaryTree(pre, pl + 1, pl + leftTreeSize, inl);//左子树的索引在+1位置，右子树的索引在+leftTreeSize+1的位置
        root.right = binaryTree(pre, pl + leftTreeSize + 1, pr, inIndex + 1);//前序数组分两部分 [pl+1, pl + leftTreeSize]和[pl + leftTreeSize, pr].
        return root;
    }
}
