import java.util.Scanner;

public class NQueenBackTrackintTest2 {
	
	static int N,ans;
	static int[] col;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		
		setQueen(1);
		System.out.println(ans);
	}
	
	
	public static void setQueen(int rowNo) {		//	rowNo : 퀸을 두어야하는 현재 행
		
		
		//	기본파트,	퀸을 모두 놓았다면
		if(rowNo > N) {			
			ans++;
			return;
		}
		
		//	1열부터	-	n열까지 퀸을 놓는 시도
		for(int i = 1; i <= N; i++) {	//	유도 파트
			col[rowNo] = i;
			if(isAvailable(rowNo)) {				//	지금까지 놓은게 가능했다면 다음 퀸을 놓는다.
				setQueen(rowNo+1);
			}
		}
	}
	
	public static boolean isAvailable(int rowNo) {	//	매개변수 현재 놓은 퀸
		for(int i=1; i<rowNo;i++) {	//	현재 놓은 퀸부터 이전의 퀸 비교
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo]-col[i])) {		//	내가 놓은 열과 같은 열에 놓은 퀸 || 대각선에 놓인 퀸이면
				return false;
			}
		}
		return true;
	}

	
	
}
