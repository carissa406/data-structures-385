package stackLab;

public class LinkedStackTest {
	
	public static void main(String[] args) {
		
		LinkedStack<Integer> iStack = new LinkedStack<>();
		for (int i = 0; i < 5; i++) {
			iStack.push(Integer.valueOf(i));
		}
		System.out.println(iStack.toString());
		
		System.out.println("Size: " + iStack.getsize());
		
		System.out.println("Peek: " + iStack.peek());
		
		System.out.println("Pop: " + iStack.pop());
		
		System.out.println(iStack);
		
		iStack.clear();
		
		System.out.println("Clear success: " + iStack.isEmpty());
	
	}
}
