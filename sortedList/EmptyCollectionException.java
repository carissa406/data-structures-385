package sortedList;

public class EmptyCollectionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmptyCollectionException() {
		super();
	}
	
	public EmptyCollectionException(String msg) {
		super(msg);
	}
}
