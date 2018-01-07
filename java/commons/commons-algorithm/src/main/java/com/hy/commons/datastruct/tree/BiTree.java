package com.hy.commons.datastruct.tree;


import java.util.*;
import java.io.Serializable;


public class BiTree {

    public int heignt(BiNode root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return 1;
        }
        int fh = heignt(root.getLeftNode());
        int rh = heignt(root.getRightNode());

        return Math.max(fh, rh) + 1;
    }


    public static BiNode createBiTree(String[] arr, int index) {
        if (index > arr.length - 1) {
            return null;
        }
        BiNode node = new BiNode();
        node.setValue(arr[index]);
        node.setRightNode(createBiTree(arr, 2 * index + 2));
        node.setLeftNode(createBiTree(arr, 2 * index + 1));
        return node;
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,#,6,7,#,9";
        String[] arr = str.split(",");
        BiNode tree = createBiTree(arr, 0);
        printTree(tree, 0);

        feiDigui(tree);
        feiDigui2(tree);
        xianxuFeiDigui(tree);
        houxuFeiDigui(tree);
        zhongxuFeiDigui(tree);


    }

    public static void printTree(BiNode root, int level) {
        //String str="1,2,3,4,#,6,7,#,9";
        if (root == null || root.getValue() == null) {
            return;
        }
        String s = "---";
        String pre = "";
        for (int i = 0; i < level; i++) {
            pre = pre + s;
        }
        System.out.println(pre + root.getValue());
        printTree(root.getLeftNode(), level + 1);
        printTree(root.getRightNode(), level + 1);


    }

    public static void feiDigui(BiNode root) {
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            BiNode node = (BiNode) stack.pop();
            System.out.print(node.getValue());

            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());
            }
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());
            }
        }
        System.out.println("");

    }


    public static void feiDigui2(BiNode root) {
        Queue stack = new LinkedList();
        stack.add(root);
        while (!stack.isEmpty()) {
            BiNode node = (BiNode) stack.poll();
            System.out.print(node.getValue());
            if (node.getRightNode() != null) {
                stack.add(node.getRightNode());
            }
            if (node.getLeftNode() != null) {
                stack.add(node.getLeftNode());
            }

        }
        System.out.println("");
    }


    public static void xianxuFeiDigui(BiNode root) {
        Stack nodeStack = new Stack();
        Set<BiNode> visited = new HashSet<BiNode>();//

        nodeStack.push(root);
        visited.add(root);
        System.out.print(root.getValue());

        while (!nodeStack.isEmpty()) {
            BiNode stackHead = (BiNode) nodeStack.peek();
            if (stackHead.getLeftNode() != null && !visited.contains(stackHead.getLeftNode())) {
                stackHead = stackHead.getLeftNode();
                nodeStack.push(stackHead);
                visited.add(stackHead);
                System.out.print(stackHead.getValue());
                continue;

            }
            if (stackHead.getRightNode() != null && !visited.contains(stackHead.getRightNode())) {
                stackHead = stackHead.getRightNode();
                nodeStack.push(stackHead);
                visited.add(stackHead);
                System.out.print(stackHead.getValue());
                continue;
            }
            nodeStack.pop();

        }
        System.out.println("");

    }

    public static void houxuFeiDigui(BiNode root) {
        Stack nodeStack = new Stack();
        Set<BiNode> visited = new HashSet<>();//

        nodeStack.push(root);
        visited.add(root);

        while (!nodeStack.isEmpty()) {
            BiNode stackHead = (BiNode) nodeStack.peek();
            if (stackHead.getLeftNode() != null && !visited.contains(stackHead.getLeftNode())) {
                stackHead = stackHead.getLeftNode();
                nodeStack.push(stackHead);
                visited.add(stackHead);
                //System.out.print(stackHead.getValue());
                continue;

            }
            if (stackHead.getRightNode() != null && !visited.contains(stackHead.getRightNode())) {
                stackHead = stackHead.getRightNode();
                nodeStack.push(stackHead);
                visited.add(stackHead);
                //System.out.print(stackHead.getValue());
                continue;
            }

            System.out.print(stackHead.getValue());
            nodeStack.pop();

        }
        System.out.println("");

    }

    public static void zhongxuFeiDigui(BiNode root) {
        Stack nodeStack = new Stack();
        Set<BiNode> visited = new HashSet<BiNode>();//

        nodeStack.push(root);
        visited.add(root);

        while (!nodeStack.isEmpty()) {
            BiNode stackHead = (BiNode) nodeStack.peek();
            if (stackHead.getLeftNode() != null && !visited.contains(stackHead.getLeftNode())) {
                stackHead = stackHead.getLeftNode();
                nodeStack.push(stackHead);
                visited.add(stackHead);
                continue;

            }
            System.out.print(stackHead.getValue());
            nodeStack.pop();


            if (stackHead.getRightNode() != null && !visited.contains(stackHead.getRightNode())) {
                stackHead = stackHead.getRightNode();
                nodeStack.push(stackHead);
                visited.add(stackHead);
                continue;
            }


        }
        System.out.println("");

    }

}
 class TreeNode implements Serializable {
    private int parentId;
    private int selfId;
    protected String nodeName;
    protected Object obj;
    protected TreeNode parentNode;
    protected List<TreeNode> childList;

    public TreeNode() {
        initChildList();
    }

    public TreeNode(TreeNode parentNode) {
        this.getParentNode();
        initChildList();
    }

    public boolean isLeaf() {
        if (childList == null) {
            return true;
        } else {
            if (childList.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* 插入一个child节点到当前节点中 */
    public void addChildNode(TreeNode treeNode) {
        initChildList();
        childList.add(treeNode);
    }

    public void initChildList() {
        if (childList == null)
            childList = new ArrayList<TreeNode>();
    }

    public boolean isValidTree() {
        return true;
    }

    /* 返回当前节点的父辈节点集合 */
    public List<TreeNode> getElders() {
        List<TreeNode> elderList = new ArrayList<TreeNode>();
        TreeNode parentNode = this.getParentNode();
        if (parentNode == null) {
            return elderList;
        } else {
            elderList.add(parentNode);
            elderList.addAll(parentNode.getElders());
            return elderList;
        }
    }

    /* 返回当前节点的晚辈集合 */
    public List<TreeNode> getJuniors() {
        List<TreeNode> juniorList = new ArrayList<TreeNode>();
        List<TreeNode> childList = this.getChildList();
        if (childList == null) {
            return juniorList;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode junior = childList.get(i);
                juniorList.add(junior);
                juniorList.addAll(junior.getJuniors());
            }
            return juniorList;
        }
    }

    /* 返回当前节点的孩子集合 */
    public List<TreeNode> getChildList() {
        return childList;
    }

    /* 删除节点和它下面的晚辈 */
    public void deleteNode() {
        TreeNode parentNode = this.getParentNode();
        int id = this.getSelfId();

        if (parentNode != null) {
            parentNode.deleteChildNode(id);
        }
    }

    /* 删除当前节点的某个子节点 */
    public void deleteChildNode(int childId) {
        List<TreeNode> childList = this.getChildList();
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            if (child.getSelfId() == childId) {
                childList.remove(i);
                return;
            }
        }
    }

    /* 动态的插入一个新的节点到当前树中 */
    public boolean insertJuniorNode(TreeNode treeNode) {
        int juniorParentId = treeNode.getParentId();
        if (this.parentId == juniorParentId) {
            addChildNode(treeNode);
            return true;
        } else {
            List<TreeNode> childList = this.getChildList();
            int childNumber = childList.size();
            boolean insertFlag;

            for (int i = 0; i < childNumber; i++) {
                TreeNode childNode = childList.get(i);
                insertFlag = childNode.insertJuniorNode(treeNode);
                if (insertFlag == true)
                    return true;
            }
            return false;
        }
    }

    /* 找到一颗树中某个节点 */
    public TreeNode findTreeNodeById(int id) {
        if (this.selfId == id)
            return this;
        if (childList.isEmpty() || childList == null) {
            return null;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode child = childList.get(i);
                TreeNode resultNode = child.findTreeNodeById(id);
                if (resultNode != null) {
                    return resultNode;
                }
            }
            return null;
        }
    }

    /* 遍历一棵树，层次遍历 */
    public void traverse() {
        if (selfId < 0)
            return;
        print(this.selfId);
        if (childList == null || childList.isEmpty())
            return;
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            child.traverse();
        }
    }

    public void print(String content) {
        System.out.println(content);
    }

    public void print(int content) {
        System.out.println(String.valueOf(content));
    }

    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSelfId() {
        return selfId;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}



