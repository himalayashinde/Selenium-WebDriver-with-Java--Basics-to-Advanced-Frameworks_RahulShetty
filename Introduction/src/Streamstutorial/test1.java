package Streamstutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<String>();

		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Ram");
		names.add("Adam");

		int count = 0;
		System.out.println(names);
		for (String name : names) {

			String actualName = name;

			if (actualName.startsWith("A")) {
		
				count++;
			}

		}	

		System.out.println(count);
		
		//java streams
		
		
		 long counts = names.stream().filter(s->s.startsWith("A")).count();
		 System.out.println(counts);
		 
		 /* 
		 * long count2 = Stream.of("Abhijeet", "Don", "Alekhya", "Ram", "Adam")
		 * .filter(s -> s.startsWith("A")) .count();
		 * 
		 * System.out.println(count2);
		 */
		
		System.out.println("***********************************");
		
		names.stream()
		.filter(s->s.length()>4)
		.forEach(s->System.out.println(s));
		
		System.out.println("***********************************");		
		
		names.stream()
		.filter(s->s.length()>4)
		.limit(1)
		.forEach(s->System.out.println(s));
		
		System.out.println("***********************************");
		//Maps 
		
		System.out.println("Maps");
		
		Stream.of("Abhijeet", "Don", "Alekhya", "Rama", "Adam")
		.filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		System.out.println("***********************************");
		
		Stream.of("Abhijeet", "Don", "Alekhya", "Rama", "Adam")
		.filter(s->s.startsWith("A")).sorted()
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		System.out.println("***********************************");
		
		//Object genericNames;
		String[] genericNames = {"man","women","god"};
		
		 List<String> genNames = Arrays.asList(genericNames);
		 
		  Stream<String> newStream = Stream.concat(names.stream(), genNames.stream());
		 
//		  newStream.sorted().forEach(s->System.out.println(s));
		  
		  boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		  
		  System.out.println(flag);
		  
		  Assert.assertTrue(flag);
		  
		  
		  
	}
}
