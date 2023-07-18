import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        HashMap<Integer, String> studentMap = new HashMap<>();

	      
	        for (int i = 1; i <= 5; i++) {
	            System.out.print("Enter roll number: ");
	            int rollNumber = scanner.nextInt();
	            System.out.print("Enter name: ");
	            String name = scanner.next();
	            studentMap.put(rollNumber, name);
	        }

	        System.out.println("\n******Roll No with hash map*****");
	     
	        Iterator<Integer> rollNumberIterator = studentMap.keySet().iterator();
	        while (rollNumberIterator.hasNext()) {
	            System.out.println(rollNumberIterator.next());
	        }

	        System.out.println("\n *******Names with hash map**********");
	      
	        for (String name : studentMap.values()) {
	            System.out.println(name);
	        }

	    }

}
