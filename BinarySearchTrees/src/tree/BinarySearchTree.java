package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, root);
	}
	
	/**
	 * Helper method for inserting recursively
	 * @param data
	 * @param curNode
	 * @return a reference to the new root of the subtree
	 */
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if (curNode == null) {
			return new TreeNode<T>(data);
		}
		else if(data.compareTo(curNode.data) < 0) {
			curNode.left  = insert(data, curNode.left);
		}
		else if(data.compareTo(curNode.data) > 0) {
			curNode.right = insert(data, curNode.right);
		}
		else;
		return curNode;
		
	}

	@Override
	public boolean find(T data) {
		return find(data, root);
	}
	
	private boolean find(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) {
			return false;
		}
		else if(data.compareTo(curNode.data) < 0) {
			return find(data, curNode.left);
		}
		else if(data.compareTo(curNode.data) > 0) {
			return find(data, curNode.right);
		}
		else {
			return true;
		}
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, root);
	}
	
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) {
			return null;
		}
		
		if (data.compareTo(curNode.data) < 0) {
			curNode.left = remove(data, curNode.left);
		}
		else if(data.compareTo(curNode.data) > 0) {
			curNode.right = remove(data, curNode.right);
		}
		else if ((curNode.left == null) && (curNode.right == null)) {
			return null;
		}
		else if (curNode.left == null) {
			return curNode.right;
		}
		else if (curNode.right == null) {
			return curNode.left;
		}
		else {
			TreeNode<T> replacingNode = findMaxNode(curNode.left);
			curNode.data = replacingNode.data;
			curNode.left = remove(replacingNode.data, curNode.left);
		}
		return curNode;
		
	}
	
	/**
	 * Returns the max item in the given subtree
	 */
	public T findMax() {
		return findMax(this.root);
	}
	private T findMax(TreeNode<T> curNode) {
		//TODO: Implement this method
		if (curNode.data != null) {
			return findMax(curNode.right);
		}
		else {
			return curNode.data;
		}
	}
	private TreeNode<T> findMaxNode(TreeNode<T> curNode) {
		if (curNode.data != null) {
			return findMinNode(curNode.right);
		}
		else {
			return curNode;
		}
	}
	
	public T findMin() {
		return findMin(this.root);
	}
	private T findMin(TreeNode<T> curNode) {
		if (curNode.data != null) {
			return findMin(curNode.left);
		}
		else {
			return curNode.data;
		}
	}
	private TreeNode<T> findMinNode(TreeNode<T> curNode) {
		if (curNode.data != null) {
			return findMinNode(curNode.left);
		}
		else {
			return curNode;
		}
	}
	
}
