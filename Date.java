package Assignment_1;

public class Date implements Comparable<Date>{
	int year;
	int month;
	int day;


	public Date (int year, int month, int day) throws IllegalArgumentException{
		if(year < 2021 || year > 2080) {
			throw new IllegalArgumentException("Year must be between 2021 and 2080");
		}
		if(month < 1 || month > 12) {
			throw new IllegalArgumentException("Month must be between 1 and 12");
		}
		if(day < 1 || day > 31) {
			throw new IllegalArgumentException("Day must be between 1 and 31");
		}
		this.year = year;
		this.month=month;
		this.day=day;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public String toString() {
		return String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(! (obj instanceof Date)){
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		Date otherDate = (Date) obj;
		boolean areDatesEqual = this.compareTo(otherDate) == 0;
		return areDatesEqual;	
	}

	@Override
	public int compareTo(Date otherDate) {
		if (year == otherDate.year && month == otherDate.month && day == otherDate.day) {
			return 0;
		}
		
		if (year < otherDate.year) {
			return -1;
		}else if (year > otherDate.year) {
			return 1;
		}else if (month < otherDate.month) {
			return -1;
		}else if (month > otherDate.month) {
			return 1;
		} else if (day < otherDate.day) {
			return -1;
		} else {
			return 1;
		}
	}
}
