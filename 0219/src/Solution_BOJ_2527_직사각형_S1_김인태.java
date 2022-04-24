import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2527_직사각형_S1_김인태 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());		//	첫 번째 직사각형
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());		//	두 번째 직사각형
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if((x1==p2 && y1==q2)||(x2==p1 && y1==q2)||		//	점
					(x2==p1 && y2==q1) || (x1==p2 && y2==q1)) {
				sb.append("c").append("\n");
			}
			else if((x1==p2 && y1!=q2)||(x2==p1 && y1!=q2)||		//	선
					(x2==p1 && y2!=q1) || (x1==p2 && y2!=q1)||
					(x1!=p2 && y1==q2) ||(x2!=p1 && y1==q2)||		
					(x2!=p1 && y2==q1) || (x1!=p2 && y2==q1)) {
				sb.append("b").append("\n");
			}
			else if(x2>p1 || x1>p2 || q1<y2 || q2<y1) {		//	안 겹침
				sb.append("d").append("\n");
			}else {
				sb.append("a").append("\n");		//	겹쳐짐
			}

		}
		System.out.println(sb);
	}

}
