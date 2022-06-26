import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueAPITest {
	public static void main(String[] args) {
		//ArrayDeque a = new 
		//Deque q = new
		
		Queue<String> queue = new LinkedList<String>();
		
		System.out.println(queue.size()+"//"+queue.isEmpty());
		
		queue.offer("정여명");
		queue.offer("신용하");
		queue.offer("차다은");
		queue.offer("이상진");
		System.out.println(queue.size()+"//"+queue.isEmpty());
		
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());
		
	}
}
