import java.util.Scanner;

public class SubSetBinaryCountingTest {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] input = new int [N];
		
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(input);

	}

	private static void generateSubset(int[] input) {
		int N = input.length;	//	원소 
		for (int flag = 0, caseCount = 1<<N; flag < caseCount; flag++) {
			// flag : 원소들의 선택상태 비트열
			for(int i = 0; i < N; i++) {
				if((flag & 1<<i)!=0) {	//	선책된 원소
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
		}
		
	}

}
