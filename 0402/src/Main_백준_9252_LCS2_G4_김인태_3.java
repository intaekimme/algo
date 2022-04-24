import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9252_LCS2_G4_김인태_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		
		int[][] LCS = new int[arr1.length + 1][arr2.length + 1];
		
		for (int i = 1; i <= arr1.length; i++) {
			for (int j = 1; j <= arr2.length; j++) {
				if (arr1[i - 1] == arr2[j - 1])
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
			}
		}
		
		int len = LCS[arr1.length][arr2.length];
		char[] result = new char[len];
		
		int idx = len - 1;
		int i = arr1.length;
		int j = arr2.length;
		while (true) {
			int cur = LCS[i][j];
			if (cur == 0) break;
			
			if (LCS[i][j - 1] == cur)
				j--;
			else if (LCS[i - 1][j] == cur)
				i--;
			else {
				result[idx--] = arr1[--i];
				j--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(len).append("\n");
		for (int k = 0; k < len; k++) {
			sb.append(result[k]);
		}
		sb.append("\n");
		System.out.print(sb.toString());
	}
}
