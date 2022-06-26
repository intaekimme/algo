import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_6808_규영이와인영이의카드게임_김인태 {

	static boolean[] isSelected;
	static boolean[] deck;
	
	static int[] myDeck;
	static int[] pDeck;
	static int[] numbers;
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {	//	n-th testCase
			
			win=0;	lose=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			deck = new boolean[19];
			myDeck = new int[9];		//	9장 카드에 대한 정보	
			
			// 규영이 deck 만듦
			for(int j=0; j<9; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				myDeck[j] = tmp;	//	9장 카드 정보 입력
				deck[tmp] = true; 
			}
			
			//	인영이 deck 만듦
			int idx=0;
			pDeck = new int[9];
			for(int j=1; j<19; j++) {
				if(deck[j] == false)
					pDeck[idx++] = j;
			}
			
//				System.out.println(Arrays.toString(myDeck));
//				System.out.println(Arrays.toString(pDeck));		정상출력 확인
			
			isSelected = new boolean[9];
			numbers = new int[9];
			sol(0,0);
			
			sb.append("#"+tc+" "+win+" "+lose+"\n");
			
		}	//	end of testCase		
		
		System.out.println(sb);
	}	// end of main
	
	
	public static void sol(int cnt, int flag) {
		if(cnt == 9) {
			int myTotal=0;
			int pTotal = 0;
			for(int i=0;i<9;i++) {
				int tmp = myDeck[i] + numbers[i];
				if(myDeck[i] > numbers[i])
					myTotal += tmp;
				else
					pTotal += tmp;
			}
			if(myTotal > pTotal)
				win++;
			else
				lose++;
			
			//System.out.println(Arrays.toString(numbers));
			return;
		}else {
			for(int i=0; i<9; i++) {
//				if(isSelected[i] == true)	continue;
				if((flag & 1<<i) != 0) 	continue;
				numbers[cnt] = pDeck[i];
//				isSelected[i] = true;
				sol(cnt+1, flag |  1<<i);
//				isSelected[i] = false;
			}
		}
	}
	
	
	
	
	

}	// end of class
