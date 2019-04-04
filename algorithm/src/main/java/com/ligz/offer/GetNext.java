package com.ligz.offer;

import com.ligz.datastructure.list.ListNode;

/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * author:ligz
 */
public class GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return pNode;
        if (pNode.right != null) {//如果右节点不为空则返回右边子节点的最左节点
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            while (pNode.next != null) {//如果右节点为空，则向上查找没有被遍历的父节点，父节点的左节点等于的时候即使该节点
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }
}
