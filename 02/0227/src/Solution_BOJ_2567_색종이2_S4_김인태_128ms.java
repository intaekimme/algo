import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 100*100 짜리 map
 * 입력 : 색종이 좌측하단 좌표 (x,y)
 * 과정 : 좌측하단(x,y)부터 (x+10, y+10)만큼 다 1로  채움
 * 입력 받은 만큼 1로 다 채우고
 * 입력좌표를 다시 순회하며
 * 입력으로부터 대각선 1 (x+1=X, y+1=Y) 부터 (X+8, Y+8) 만큼 다 0으로 채움 => 테두리 제외 0으로 채
 * 
 *  마지막에 1의 갯수를 다 더한 것이 둘레의 값
 *  >> 이렇게 했더니 색종이가 겹쳐 있어도 테두리는 0으로 바꾸지 않기에 중복된 값이 들어간다.
 *  
 *  다른 방법을 사용해야 한다.
 *  임의의 어느 한 좌표에서 사방탐색을 한 후 어느 한 곳이라도 0이면 그 좌표는 테두리에 포함된다.
 * @author kit938639
 *
 */


public class Solution_BOJ_2567_색종이2_S4_김인태_128ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[102][102];
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			

//			1로 채움
			for (int r = x; r < x+10 ; r++) {
				for (int c = y; c < y+10; c++) {
					map[r][c] = 1;
				}
			}
			
		}	//	end of for
		
		
//		임의의 어느 한 좌표에서 사방탐색을 한 후 어느 한 곳이라도 0이면 그 좌표는 테두리에 포함된다.
		int ans=0;
		for(int i = 1; i <= 100; i++){
        	for(int j = 1; j <= 100; j++){
        		if(map[i][j] == 0) continue;
        		if(map[i-1][j] == 0) ans++;
        		if(map[i+1][j] == 0) ans++;
        		if(map[i][j-1] == 0) ans++;
        		if(map[i][j+1] == 0) ans++;
        	}
        }
		
		System.out.println(ans);
	}	//	end of main

}	//	end of class


//4
//3 7
//5 2
//15 7
//13 14

//int[] coordX = new int [N];
//int[] coordY = new int [N];


//coordX[i]=x;
//coordY[i]=y;

//		for(int i=0;i<N;i++) {
//		//	테두리 제외 0으로 바꿈
//			int x = coordX[i];
//			int y = coordY[i];
//			for (int r = x+1; r < x+9; r++) {
//				for (int c = y+1; c < y+9; c++) {
//					map[r][c]=0;
//				}
//			}
//		}
//		
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		
//		int ans = 0;
//		Arrays.sort(coordX);
//		Arrays.sort(coordY);
//		
//		System.out.println(Arrays.toString(coordX));
//		System.out.println(Arrays.toString(coordY));
//		
//		int lastX = coordX.length-1;
//		int lastY = coordY.length-1;
//		System.out.println(coordX[0]+","+coordX[lastX]+","+coordY[0]+","+coordY[lastY]);
//		
//		for(int r=coordX[0]; r<=coordX[lastX]+10; r++) {
//			for(int c=coordY[0]; c<=coordY[lastY]+10; c++) {
//				if(map[r][c]==1)	ans++;
//			}
//		}
