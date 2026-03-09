package co.edu.uniuindio.generics;

import java.util.LinkedHashSet;
import java.util.Set;
public class Main {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet();
		set.add(new String("Chicago"));
		set.add(new String("Boston"));
		set.add(new String("Alabama"));
		set.add(new String("Chicago"));
		System.out.println(set);
	}
}
