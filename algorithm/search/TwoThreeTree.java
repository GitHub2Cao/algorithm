package algorithm.search;

/**
 * 查找树, 平衡. 一个2节点要么没有孩子要么有两个孩子，不能只有一个孩子。一个3节点要么没有孩子要么有3个孩子。
 * @author cgm
 *
 * @param <K>
 */
public class TwoThreeTree<K extends Comparable<? super K>> {
	private Node root;
	private int count;
	
	/**
	 * 二节点、三节点
	 * @author cgm
	 */
	private class Node {
		protected K first;
		protected K second;
		protected Node parent;
		protected Node left;
		protected Node middle;
		protected Node right;
		
		Node (K first) {
			this.first = first;
		}
		
		Node (K first, K second) {
			this.first = first;
			this.second = second;
		}
	}
	
	/**
	 * 四节点，暂时的.
	 * @author cgm
	 */
	private class TempFourNode extends Node {
		protected K third;
		protected Node middle2;
		
		TempFourNode(K first, K second, K third) {
			super(first, second);
			this.third = third;
		}
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean isEmpty() {
		return this.count == 0;
	}
	
	public void put(K k) {
		if (k == null) {
			throw new NullPointerException("the value is null");
		}
		
		if (!(k instanceof Comparable)) {
			throw new IllegalArgumentException("the value must extends Comparable interface");
		}
		
		if (isEmpty()) { // 如果是空树，直接创建。
			root = new Node(k);
			count++;
			return;
		}

		// 找到要插入的位置。
		Node site = findNode(root, k);
		if (site.second == null) { // 插入，直接变成3节点.
			
			if (k.compareTo(site.first) < 0) {
				site = new Node(k, site.first);
			} else if (k.compareTo(site.first) == 0) {
				site.first = k;
			} else {
				site = new Node(site.first, k);
			}
		} else { // 3节点暂时变4节点.
			if (k.compareTo(site.first) == 0) {
				site.first = k;
			}
			if (k.compareTo(site.second) == 0) {
				site.second = k;
			}
			
			TempFourNode tempFourNode = null;
			if (k.compareTo(site.first) < 0) {
				tempFourNode = new TempFourNode(k, site.first, site.second);
			} else if (k.compareTo(site.first) > 0 && k.compareTo(site.second) < 0) {
				tempFourNode = new TempFourNode(site.first, k, site.second);
			} else {
				tempFourNode = new TempFourNode(site.first, site.second, k); 
			}
			put4NodeInTree(site, tempFourNode);
			count++;
		}
	}
	
	/**
	 * 找到要插入点.
	 * @param r 树根.
	 * @param k 要找的值.
	 * @return 要插入的节点.
	 */
	private TwoThreeTree<K>.Node findNode(TwoThreeTree<K>.Node r, K k) {
		if (r.left == null ) { // 没有左子树，只能是自己
			return r;
		}
		
		if (k.compareTo(r.first) == 0) { // 跟自己相等，自己
			return r;
		}

		if (k.compareTo(r.first) < 0) { // 如果比左子树还小，继续递归左子树.
			return findNode(r.left, k);
		}
		
		if (r.second == null) { // 3节点，找中间
			return findNode(r.middle, k);
		}
		
		if (k.compareTo(r.second) == 0) {
			return r;
		}
		
		if (k.compareTo(r.first) > 0 && k.compareTo(r.second) < 0) {
			return findNode(r.middle, k);
		}
		
		return findNode(r.right, k);
	}
	
	private void put4NodeInTree(TwoThreeTree<K>.Node site, TwoThreeTree<K>.TempFourNode tempFourNode) {
		Node splitResult = convert4to2(tempFourNode);
		if (site == root) {
			root = splitResult;
		} else {
			Node parent = site.parent;
			TempFourNode mergeResult = mergeNodes(parent, splitResult);
			if (mergeResult != null) {
				put4NodeInTree(parent, mergeResult);
			}
		}
	}
	
	private TwoThreeTree<K>.TempFourNode mergeNodes(TwoThreeTree<K>.Node treeNode, TwoThreeTree<K>.Node splitResult) {
		TempFourNode newFourNode = null;
		if (treeNode.second == null) {
			if (splitResult.first.compareTo(treeNode.first) < 0) {
				treeNode.second = treeNode.first;
				treeNode.first = splitResult.first;
				
				
				
			} else if (splitResult.first.compareTo(treeNode.first) > 0) {
				treeNode.second = splitResult.first;
				treeNode.right = splitResult.right;
				treeNode.middle = splitResult.left;
			}
		}
		
		
		return null;
	}

	private TwoThreeTree<K>.Node convert4to2(TwoThreeTree<K>.TempFourNode tempFourNode) {
		Node newRoot = new Node(tempFourNode.second);
		Node newLeft = new Node(tempFourNode.first);
		Node newRight = new Node(tempFourNode.third);
		
		newRoot.left = newLeft;
		newRoot.right = newRight;
		
		newLeft.parent = newRoot;
		newRight.parent = newRoot;
		
		newLeft.left = tempFourNode.left;
		if (newLeft.left != null) {
			newLeft.left.parent = newLeft;
		}
		
		newLeft.right = tempFourNode.middle;
		if (newLeft.right != null) {
			newLeft.right.parent = newLeft;
		}
		
		newRight.left = tempFourNode.middle2;
		if (newRight.left != null) {
			newRight.left.parent = newRight;
		}
		
		newRight.right = tempFourNode.right;
		if (newRight.right != null) {
			newRight.right.parent = newRight;
		}
		
		return newRoot;
	}
	
}

