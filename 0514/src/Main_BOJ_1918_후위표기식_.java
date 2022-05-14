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

	static class Op{
		char op;
		int pr;
		
		public Op(char op, int pr) {
			super();
			this.op = op;
			this.pr = pr;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String exp = br.readLine();
		Stack<Op> stack = new Stack<Op>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<exp.length(); i++) {
			char s = exp.charAt(i);
			int pr = check(s);
			
			if(pr == -2) {
				while(!stack.isEmpty()) {
					char tmp = stack.pop().op;
					if(tmp != '(') {
						sb.append(tmp);
					}
				}
				continue;
			}
			if(pr==-1) {
				sb.append(s);
				continue;
			}
			if(pr == 0) {
				stack.push(new Op(s, pr));
				continue;
			}
			if(stack.isEmpty()) {
				stack.push(new Op(s, pr));
			}else {
				Op cur = stack.peek();
				if(cur.pr < pr) {
					stack.push(new Op(s, pr));
				}else {
					while(!stack.isEmpty() && cur.pr >= pr) {
						char tmp = stack.pop().op;
						if(tmp != '(') {
							sb.append(tmp);
						}
					}
					stack.push(new Op(s, pr));
				}
			}
		}	//	end of for
		while(!stack.isEmpty()) {
			sb.append(stack.pop().op);
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
		case '(':
			return 0;
		case ')':
			return -2;
		default:
			return -1;
		}
	}

}
