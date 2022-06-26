import java.util.Scanner;

public class SpaceDivideTest {

	static int white, green;
	static int[][] spaces;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		spaces = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j=0; j<N; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}
		
		
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(green );

	}

	
	public static void cut (int r, int c, int size) {	//	size
		
		// 해당영역의 색상확인
		int sum = 0;
		for(int i = r, rEnd = r+size; i<rEnd ; i++) {
			for(int j = c, cEnd = c+size; j<cEnd; j++) {
				sum += spaces[i][j];
			}
		}
		
		
		if(sum == size*size) {
			green++;
		}else if(sum == 0) {
			white++;
		}else {	//	색상이 섞여 있는 경우
				int half = size / 2;
				cut(r, c, half);
				cut(r, c+half, half);
				cut(r+half, c, half);
				cut(r+half, c+half, half);
		}
	}
	
}
