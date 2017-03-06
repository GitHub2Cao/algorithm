package algorithm.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class A {
	public B b;
	public A() {
		//this.ca = Calendar.getInstance();
	}

}

class B {
	public A a;
	public B() {
		//this.ca = Calendar.getInstance();
	}
}

public class Main {
	public static void main(String[] args) {
		List<Calendar> list = new ArrayList<>();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
//			Calendar cal = Calendar.getInstance();
//			list.add(cal);
			System.out.println(i);
			
			A a = new A();
			B b = new B();
			a.b = b;
			b.a = a;
			
			
			
		}
		System.out.println(list.size());
		
	}
}
