package stackLab;

public class ArrayStackTest {

	public static void main(String[] args) {
		ArrayStack<Integer> iStack = new ArrayStack<>();
		for (int i = 0; i < 100; i++) {
			iStack.push(Integer.valueOf(i));
		}
		System.out.println(iStack);
		
		ArrayStack<Character> cStack = new ArrayStack<>();
		for(char c = ' '; c <= '~'; c++) {
			cStack.push(Character.valueOf(c));
		}
		System.out.println(cStack);
		
		while(!iStack.isEmpty()) {
			System.out.println(iStack.pop());
		}
		
		System.out.println("iStack size: " + iStack.getSize());
		
		while(!cStack.isEmpty()) {
			System.out.println(cStack.peek());
			cStack.pop();
		}
	}

}
