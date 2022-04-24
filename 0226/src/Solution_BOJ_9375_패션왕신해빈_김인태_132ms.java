import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_BOJ_9375_패션왕신해빈_김인태_132ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> cloth = new HashMap<>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String dummy = st.nextToken();
				
				String kind = st.nextToken();
				if(cloth.containsKey(kind)) {
					cloth.put(kind, cloth.get(kind)+1);
				}else {
					cloth.put(kind, 1);
				}
			}
			int ans=1;
			for (HashMap.Entry<String, Integer> entry : cloth.entrySet()) {
				ans *= entry.getValue()+1;
			}
			
			sb.append(ans-1).append("\n");
		}
		System.out.println(sb);
	}

}
