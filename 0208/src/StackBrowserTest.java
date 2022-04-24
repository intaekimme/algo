import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackBrowserTest {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> backward = new Stack<String>();
		Stack<String> forward = new Stack<String>();
		
		String current = "http://www.ssafy.com";
		
		while(true) {
			String input = in.readLine();
			if(input.charAt(0)=='Q')	break;
			
			StringTokenizer st = new StringTokenizer(input);
			
			switch (st.nextToken()) {
			case "V":
				backward.push(current);
				forward.clear();
				current = st.nextToken();
				break;
			case "B":
				if(backward.isEmpty()) {
					System.out.println("Ignore..");
					continue;
				}else {
					forward.push(current);
					current = backward.pop();
				}
				break;
			case "F":
				if(forward.isEmpty()) {
					System.out.println("Ignore..");
					continue;
				}else {
					backward.push(current);
					current = forward.pop();
				}
				
				break;
			}
			System.out.println(current);
		}
				
		
	}	//	end of main

}	// end of class
