

public class StackAPITest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		
		
		stack.push("송제영");
		System.out.println(stack);
		stack.push("최도협");
		System.out.println(stack);
		stack.push("이상진");
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
