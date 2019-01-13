package question201;

import org.hibernate.transform.ResultTransformer;

public class Test {
	
	public static void main(String[] args) {
		Node treeNode6 = new Node(6);
		Node treeNode4 = new Node(4);
		Node treeNode5 = new Node(5, null, treeNode6);
		Node treeNode3 = new Node(3, treeNode4, treeNode5);
		Node treeNode2 = new Node(2);
		Node treeNode1 = new Node(1, treeNode2, treeNode3);
		int maxDepth = maxDepth(treeNode1);
		int minDepth = minDepth(treeNode1);
		int numOfNodes = numOfNodes(treeNode1);
		int numOfLeafNodes = numOfLeafNodes(treeNode1);
		System.out.println(maxDepth);
		System.out.println(minDepth);
		System.out.println(numOfNodes);
		System.out.println(numOfLeafNodes);
		preOrder(treeNode1);
	}
	
	// 最大深度
	public static int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int left = maxDepth(node.getLeft());
		int right = maxDepth(node.getRight());
		return Math.max(left, right) + 1;
	}
	
	// 最小深度
	public static int minDepth(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		return Math.min(minDepth(node.getLeft()), minDepth(node.getRight())) + 1;
	}
	
	// 节点数
	public static int numOfNodes(Node node) {
		if (node == null) {
			return 0;
		}
		int left = numOfNodes(node.getLeft());
		int right = numOfNodes(node.getRight());
		return left + right + 1;
	}
	
	// 叶子节点数
	public static int numOfLeafNodes(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		return numOfLeafNodes(node.getLeft()) + numOfLeafNodes(node.getRight());
	}
	
	// 前序遍历（中序和后序类似）
	public static void preOrder(Node node) {
		System.out.println(node.getVal());
		if (node.getLeft() != null) {
			preOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			preOrder(node.getRight());
		}
	}

}

