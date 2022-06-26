import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 피연산자는 출력
 * 연산자는 스택 확인 후 
 * 들어오는 연산자의 우선순위 > 스택 꼭대기의 연산자의 우선순위 >> push
 * 반대로 
 * 들어오는 연산자의 우선순위 <= 스택 내부가 >> 작아질 때 까지 스택 pop하며 출력
 * 이 때 )는 출력 x
 * @author kit938639
 *
 */
public class Main_BOJ_1918_후위표기식_ {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] exp = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<exp.length; i++) {
			if('A' <= exp[i] && exp[i] <= 'Z') {
				sb.append(exp[i]);
				continue;
			}
			if(exp[i] == '(') {
				stack.push('(');
				continue;
			}
			if(exp[i] == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				if(!stack.isEmpty()) stack.pop();
				continue;
			}
			while(!stack.isEmpty() && check(stack.peek()) >= check(exp[i])) {
				sb.append(stack.pop());
			}
			stack.push(exp[i]);
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}

	private static int check(char s) {
		switch (s) {
		case '*': 
		case '/':
			return 2;			
		case '+':		
		case '-':
			return 1;
		default:
			return 0;
		}
	}

}
