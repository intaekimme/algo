
public class Main_BOJ_15596_정수N개의합_B2 {

	public static void main(String[] args) {
		
	}

	public static long sum(int[] a) {
		long ans = 0;
		int size = a.length;
		for(int i=0; i<size; i++) {
			ans += a[i];
		}
		return ans;
	}
}

