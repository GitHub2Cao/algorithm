package algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("2\\.\\d{1}\\.\\d{1}");
		Matcher matcher = pattern.matcher("ss2.0.3sdf");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		
		
		System.out.println(Arrays.toString("0,1,3,4,5".split(",")));
	}
		
		
		
		
		
		
		
		
		
		
		
//		BST<String> bst = new BST<String>();
//		
//		bst.put("B");
//		bst.put("A");
//		bst.put("G");
//		bst.put("E");
//		bst.put("C");
//		bst.put("D");
//		bst.put("F");
//		bst.put("Z");
//		bst.inOrderTraverse();
//		
//		System.out.println(bst.get("E"));
//		
//		System.out.println(bst.size());
//		System.out.println(bst.min());
//		
//		System.out.println(bst.max());
//		bst.deleteMax();
//		System.out.println(bst.size());
//		bst.inOrderTraverse();
		
		
		
		
		
		
	}


