import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2920_음계_B2 {

	private static int[] arr, check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[8];
		for(int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		check = new int[7];
		for(int i=1; i<8; i++) {
			if(arr[i-1] < arr[i]) check[i-1] = 1;
			else check[i-1] = 0;
		}
		
		for(int i=1; i<7; i++) {
			if(check[i-1] != check[i]) {
				System.out.println("mixed");
				break;
			}else {
				if(i==6) {
					if(check[i] == 1) System.out.println("ascending");
					else System.out.println("descending");
				}
			}
		}	//	end of for	
		
	}	//	end of main

}
