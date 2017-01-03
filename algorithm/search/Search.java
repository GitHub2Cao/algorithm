package algorithm.search;

public class Search {
	
	public static void main(String[] args) {
		String arr[] = new String[]{ "B", "C", "D", "E", "F", "G"};
		int set = binarySearchByIte(arr, 0, arr.length - 1, "G");
		System.out.println(set);
		
		//Arrays.binarySearch(a, key)
	}
	
	/**
	 * 递归
	 * @param sorted
	 * @param lo
	 * @param hi
	 * @param target
	 * @return
	 */
	public static <T extends Comparable<? super T>> int binarySearch(T[] sorted, int lo, int hi, T target) {
		if (target == null) {
			throw new NullPointerException("the target is null");
		} 
		
		if (!(target instanceof Comparable)) {
			throw new IllegalArgumentException("the target illegal");
		}
		
		if (hi < lo) {
			if (hi >= sorted.length || hi < 0) {
				return -1;
			}
			return lo;
		}
		
		int mid = (lo + hi) >>> 1;
		
		if (sorted[mid].compareTo(target) > 0) {
			return binarySearch(sorted, lo, mid - 1, target);
		} else if (sorted[mid].compareTo(target) < 0) {
			return binarySearch(sorted, mid + 1, hi, target);
		} else {
			return mid;
		}
	}
	
	/**
	 * 迭代.
	 * @param sorted
	 * @param lo
	 * @param hi
	 * @param target
	 * @return
	 */
	public static <T extends Comparable<? super T>> int binarySearchByIte(T[] sorted, int lo, int hi, T target) {
		while (lo <= hi) {
			int mid = (lo + hi) >>> 1;
			if (sorted[mid].compareTo(target) > 0) {
				hi = mid - 1;
			} else if (sorted[mid].compareTo(target) < 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
}
