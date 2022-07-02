import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1075_토너먼트_S3 {

	
	private static int N, jimin, hansu;
	private static boolean[] player;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		jimin = Integer.parseInt(st.nextToken());
		hansu = Integer.parseInt(st.nextToken());
		
//		player = new boolean[N+1];
//		player[jimin] = player[hansu] = true;
		
		Queue<Integer> tournament = new LinkedList<Integer>();
		Queue<Integer> tmp = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			tournament.add(i);
		}
		
		int cnt = 1;
		
		while(true) {
			if(tournament.size() > 1) {
				int player1 = tournament.poll();
				int player2 = tournament.poll();
				
				if(player1 == jimin && player2 == hansu) {
					break;
				}
				if(player1 == jimin || player1 == hansu) {
					tmp.add(player1);
				}
				if(player2 == jimin || player2 == hansu) {
					tmp.add(player2);
				}
				if(player1 != jimin && player1 != hansu && player2 != jimin && player2 != hansu) {
					tmp.add(player1);
				}
			}else if(tournament.size() == 1) {
				tmp.add(tournament.poll());
			}else {
				while(!tmp.isEmpty()) {
					tournament.add(tmp.poll());
				}
				cnt++;
			}
		}	//	end of while
		
		System.out.println(cnt);
	}

}
