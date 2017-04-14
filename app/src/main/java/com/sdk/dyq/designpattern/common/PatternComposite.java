package com.sdk.dyq.designpattern.common;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 组合模式
 * 在处理树形结构问题时方便
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等
 */

public class PatternComposite {
    class TreeNode{
        private String name;
        private TreeNode parent;
        private Vector<TreeNode> children;

        public TreeNode(String name) {
            this.name = name;
        }

        public void add(TreeNode node){
            children.add(node);
        }
        public void remove(TreeNode node){
            children.remove(node);
        }

        public Enumeration<TreeNode> getChildren(){
            return children.elements();
        }
    }
    class Tree{
        private TreeNode root;

        public Tree(String name) {
            this.root = new TreeNode(name);
        }

    }
    public void test(){
        Tree root = new Tree("tree");
        TreeNode n1 = new TreeNode("123");
        TreeNode n2 = new TreeNode("456");
        n1.add(n2);
        root.root.add(n1);

    }
}
