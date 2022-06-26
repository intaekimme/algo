import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test3 {
	
	private static char[] ch;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ch = br.readLine().toCharArray(); 
		func(0);
	}
	
	private static void func(int i) {
		if(i == ch.length) {
			return;
		}
		System.out.print(ch[i]);
		func(i+1);
		System.out.print(ch[i]);
	}
}


// ASADADSA