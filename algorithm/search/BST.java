package algorithm.search;

public class BST<T extends Comparable<? super T>> {
	private Node root;
	
	private class Node {
		private T t;
		private Node left;
		private Node right;
		private int count;
		
		public Node(T t, int count) {
			this.t = t;
			this.count = count;
		}
	}
	
	public String toString() {
		
		return null;
	}
	
	public int size() {
		return size(this.root);
	}
	
	private int size(BST<T>.Node r) {
		if (r == null) {
			return 0;
		} else {
			return r.count;
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}
	
	public T get(T t) {
		if (t == null) {
			throw new NullPointerException("the args is null");
		}
		if (!(t instanceof Comparable)) {
			throw new IllegalArgumentException("the args is illegal");
		}
		if (isEmpty()) {
			throw new RuntimeException("no data here");
		}
		
		return get(root, t);
	}
	
	public T min() {
		if (isEmpty()) {
			return null;
		}
		
		Node node = min(this.root);
		return node.t;
	}
	
	public T max() {
		if (isEmpty()) {
			return null;
		}
		
		return max(this.root);
	}
	
	public void deleteMin() {
		root = deleteMin(root);
		System.out.println(root.t);
	}
	
	public void deleteMax() {
		root = deleteMax(root);
		System.out.println(root.t);
	}
	
	private BST<T>.Node deleteMax(BST<T>.Node r) {
		if (r.right == null) {
			return r.left;
		}
		r.right = deleteMax(r.right);
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}

	private BST<T>.Node deleteMin(BST<T>.Node r) {
		if (r.left == null) {
			return r.right;
		}
		r.left = deleteMin(r.left);
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}

	public void delete(T t) {
		this.root = delete(this.root, t); 
	}
	

	private BST<T>.Node delete(BST<T>.Node r, T t) {
		if (r == null) {
			return null;
		}
		
		int cmp = t.compareTo(r.t);
		if (cmp < 0) {
			r.left = delete(r.left, t);
		} else if (cmp > 0) {
			r.right = delete(r.right, t);
		} else {
			if (r.left == null) {
				return r.right;
			}
			if (r.right == null) {
				return r.left;
			}
			Node node = r;
			r = min(r.right); // 最小的那个.
			r.right = deleteMin(r.right);
			r.left = node.left;
		}
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}

	private T max(BST<T>.Node r) {
		if (r.right == null) {
			return r.t;
		}
		return max(r.right);
	}

	private Node min(BST<T>.Node r) {
		if (r.left == null) {
			return r;
		}
		return min(r.left);
	}

	private T get(BST<T>.Node r, T t) {
		if (r == null) {
			return null;
		}
		
		if (t.compareTo(r.t) > 0) {
			return get(r.right, t);
		} else if (t.compareTo(r.t) < 0) {
			return get(r.left, t);
		} else {
			return r.t;
		}
	}
	
	public void put(T t) {
		root = put(root, t);
	}

	private Node put(Node r, T t) {
		if (r == null) {
			return new Node(t, 1);
		}
		
		int cmp = t.compareTo(r.t);
		if (cmp < 0) {
			r.left = put(r.left, t);
		} else if (cmp > 0) {
			r.right = put(r.right, t);
		}
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}
	
	public void inOrderTraverse() {
        inOrderTraverse(this.root);
    }

	private void inOrderTraverse(Node r) {
		if (r == null) {
			return;
		}  
		inOrderTraverse(r.left);
        System.out.print(", " + r.t);
        inOrderTraverse(r.right);
        return;
	}
}
