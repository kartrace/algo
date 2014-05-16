package mijiang.test;

import java.util.ArrayList;
import java.util.Collection;

public class GenericsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>();

		// T inferred to be Object
		fromArrayToCollection(oa, co); 

		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		
		Integer[] ia = new Integer[100];

		// T inferred to be String
		fromArrayToCollection(sa, cs);

		// T inferred to be Object
		fromArrayToCollection(sa, co);
		fromArrayToCollection(ia, co);
		
		
		Collection<String> strCo = new ArrayList<String>();
		strCo.add("apple");
		
		Collection<Object> objCo = new ArrayList<Object>();
		objCo.add("apple");
		objCo.add(1);
		objCo.add(new ArrayList<String>().add("b"));
		
		
		

	}
	
	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
	    for (T o : a) {
	        c.add(o); // Correct
	    }
	}
	
	static <T extends Number> T sum(T[] values){
		T[] a = (T[])new Object[100];
		return a[0];
	}

}
