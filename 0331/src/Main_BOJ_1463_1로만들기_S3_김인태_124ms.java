import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_1463_1로만들기_S3_김인태_124ms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] table = new int[n+1];
		
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			if(i%3==0 && table[i/3] + 1 < min) {
				min = table[i/3] + 1;
			}
			if(i%2==0 && table[i/2] + 1 < min) {
				min = table[i/2] + 1;
			}
			if(table[i-1]+1 < min){
				min = table[i-1] + 1;
			}
			table[i] = min;
		}
//		System.out.println(Arrays.toString(table));
		System.out.println(table[n]);
	}

}
