import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_BOJ_1076_저항_B2_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> val = new HashMap();
		val.put("black", 0);
		val.put("brown", 1);
		val.put("red", 2);
		val.put("orange", 3);
		val.put("yellow", 4);
		val.put("green", 5);
		val.put("blue", 6);
		val.put("violet", 7);
		val.put("grey", 8);
		val.put("white", 9);
		
		Map<String, Integer> mul = new HashMap();
		mul.put("black", 1);
		mul.put("brown", 10);
		mul.put("red", 100);
		mul.put("orange", 1_000);
		mul.put("yellow", 10_000);
		mul.put("green", 100_000);
		mul.put("blue", 1_000_000);
		mul.put("violet", 10_000_000);
		mul.put("grey", 100_000_000);
		mul.put("white", 1_000_000_000);
		
		
		long ans = 0;
		ans += val.get(br.readLine()) * 10;
		ans += val.get(br.readLine());
		ans *= mul.get(br.readLine());
		
		System.out.println(ans);
		
	}

}
