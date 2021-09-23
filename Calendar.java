package Assignment_1;

public class Calendar {
	static final int MAXEVENTS = 4;
	Event[] events;
	int numEvents;
	
	public Calendar() {
		events = new Event[MAXEVENTS];
		numEvents = 0;
	}
	
	public boolean addEvent(Event e) {
		if (numEvents == MAXEVENTS) {
			return false;
		}
		for (int i = 0; i < events.length; i++) {
			if (events[i] == null) {
				events[i] = e;
				numEvents ++;
				return true;
			}
		}
		return true;
	}
	
	public int findEvent(Event e) {
		for (int i = 0; i < events.length; i++) {
			if (events[i] == null){
				continue;
			}
			if (events[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean removeEvent(Event e) {
		int i = findEvent(e);
		
		if (i == -1) {
			return false;
		}
		
		events[i] = null;
		numEvents--;
		return true;
	}
	
	public void dump() {
		for (int i = 0; i < events.length; i++) {
			if (events[i] == null) {
				continue;
			}
			System.out.println(events[i].toString());
		}
	}
}
