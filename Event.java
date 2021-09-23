package Assignment_1;

public class Event {
	Date date;
	int start;
	int end;
	String description;
	
	public Event(Date date, int start, int end, String description) throws IllegalArgumentException{
		if(start < 0 || start > 23) {
			throw new IllegalArgumentException("Start time must be between 0 and 23");
		}
		if(end < 0 || end > 23) {
			throw new IllegalArgumentException("End time must be between 0 and 23");
		}
		if(start > end) {
			throw new IllegalArgumentException("Start time must be earlier than end time");
		}
		
		this.date = date;
		this.start = start;
		this.end = end;
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	public String toString() {
		return date.toString() + " " + start + "--" + end + ": " + description;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(! (obj instanceof Event)){
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		Event otherEvent = (Event) obj;
		
		if(this.date.equals(otherEvent.getDate()) && this.start == otherEvent.getStart() && this.end == otherEvent.getEnd() && this.description.compareTo(otherEvent.getDescription()) == 0) {
			return true;
		}
		else return false;
		
	}
}
