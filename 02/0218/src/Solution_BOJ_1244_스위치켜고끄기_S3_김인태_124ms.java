import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 완전탐색, xor 연산 이
 * @author kit938639
 *
 */


public class Solution_BOJ_1244_스위치켜고끄기_S3_김인태_124ms {
	static int[] state;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());	//	스위치 갯수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		state = new int[S+1];	//	1번째부터 사용하기 위해
		for(int i=1; i<=S; i++) {	//	스위치 갯수만큼 반복
			state[i] = Integer.parseInt(st.nextToken());
		}
		int size = state.length-1;	//	스위치 갯수 = 스위치 배열 크기 - 1
		
		int P = Integer.parseInt(br.readLine());	//	학생 수
		
		for(int i=0; i<P; i++) {	//	학생 수만큼 반복
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int command = Integer.parseInt(st.nextToken());
			
			sol(sex, command, size, state);
			
		}
		
		StringBuilder sb = new StringBuilder();
		//	스위치 갯수가 20개 보다 작으면 그냥 출력
		if(size<=20) {
			for(int i=1; i<=size; i++) {
				sb.append(state[i]).append(" ");
			}
		}else {	//	20개 이상이면 20개 일 때 마다 개행 추가
			for(int i=1;i<state.length;i++) {
				if(i%20==0)
					sb.append(state[i]).append("\n");
				else
					sb.append(state[i]).append(" ");
			}
			
		}
		
		System.out.println(sb);
	}	//	end of main
	
	public static void sol(int sex, int command, int size, int[] state) {
		if(sex==1) {	//	남자면
			int end = size/command;		// 스위치 갯수 / 스위치 번호로 나눔
			for(int i=1; i<=end; i++) {	//	배수 갯수 만큼 반복
				int idx = i*command;
				state[idx] = state[idx]^1;		//	xor연산	:	같으면 0, 다르면 1
				//System.out.println(Arrays.toString(state));
			}
		}	//	end of if
		else {		//	여자면
			int right = command+1;
			int left = command-1;
			while(true) {
				//	중심 좌우가 범위를 벗어나지 않고, 값이 동일하다면
				if(0<left && right<=size && state[left]==state[right]) {
					state[left] = state[left]^1;
					state[right] = state[right]^1;
					left--;
					right++;
				}else {
					state[command] = state[command]^1;
					//System.out.println(Arrays.toString(state));
					break;
				}
			}	//	end of while
		}	//	end of else
	}	//	end of sol
}	//	end of class
