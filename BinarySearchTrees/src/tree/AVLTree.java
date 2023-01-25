package tree;

/**
 * Self-balancing AVL Tree
 * @author Mark Floryan
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		curNode = super.insert(data, curNode);
		if(curNode != null) {
			curNode.height = newHeight(curNode);
		}
		return balance(curNode);
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		curNode = super.remove(data, curNode);
		if(curNode != null) {
			curNode.height = newHeight(curNode);
		}
		return balance(curNode);
	}
	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		int balanceFactor = balanceFactor(curNode);
		
		if (balanceFactor < -1 && (balanceFactor(curNode.left) <= 0)) {
			curNode = rotateRight(curNode);
		}
		else if (balanceFactor > 1 && balanceFactor(curNode.right) < 0) {
				curNode.right = rotateRight(curNode.right);
				curNode = rotateLeft(curNode);
			}
		else if (balanceFactor > 1 && balanceFactor(curNode.right) >= 0){
				//curNode.left = rotateLeft(curNode.left);
				curNode = rotateLeft(curNode);
			}
		else if (balanceFactor < -1 && balanceFactor(curNode.left) > 0) {
			curNode.left = rotateLeft(curNode.left);
			curNode = rotateRight(curNode);
			
		}
		
		return curNode;	
		
	}
	
	private int newHeight (TreeNode<T> curNode) {
		if(curNode != null) {
			int lcheight = height(curNode.left);
			int rcheight = height(curNode.right);
			if(lcheight > rcheight) return lcheight + 1;
			else return rcheight + 1;
		}
		return 0;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		TreeNode<T> leftchild = curNode.left;
		
		curNode.left = leftchild.right;
		leftchild.right = curNode;
		
		curNode.height = newHeight(curNode);
		newHeight(leftchild);
		
		return leftchild;		
		 
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		TreeNode<T> rightchild = curNode.right;
		
		curNode.right = rightchild.left;
		rightchild.left = curNode;
		
		curNode.height = newHeight(curNode);
		newHeight(rightchild);
		
		return rightchild;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		//TODO: Implement this method
		if(node == null) {
			return 0;
		}
		return height(node.right) - height(node.left);
	}
	
	
}
