import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_1755_숫자놀이_ {

	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		
//		String[] arr = {"one", "two", "three", "four", "five", 
//				"six", "seven", "eight", "nine", "zero"};
//		
//		Arrays.sort(arr);
//		
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(0, "zero");
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("one", 1);
		map2.put("two", 2);
		map2.put("three", 3);
		map2.put("four", 4);
		map2.put("five", 5);
		map2.put("six", 6);
		map2.put("seven", 7);
		map2.put("eight", 8);
		map2.put("nine", 9);
		map2.put("zero", 0);
		
		
		
		ArrayList<String> arr = new ArrayList<String>();
		for(int i=N; i<=M; i++) {
			if(i<10) {
				arr.add(map.get(i));
			}
			else {
				int q = i/10;
				int r = i%10;
				String tmp = map.get(q) + " " + map.get(r);
				arr.add(tmp);
			}
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0, j=1; i<arr.size(); i++, j++) {
			st = new StringTokenizer(arr.get(i));
			while(st.hasMoreTokens()) {
				sb.append(map2.get(st.nextToken()));					
			}
			if(j<10) {
				sb.append(" ");				
			}else {
				sb.append("\n");
				j=0;
			}
		}
		
		System.out.println(sb);
	}
}
