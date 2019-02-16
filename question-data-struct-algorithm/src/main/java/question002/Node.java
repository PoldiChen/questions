package question002;

public class Node {
	
	private int val;
	private Node left;
	private Node right;
	
	public Node(int val, Node left, Node right) { // 非叶子节点
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public Node(int val) { // 叶子节点
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
