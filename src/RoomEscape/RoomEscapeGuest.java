package RoomEscape;

public class RoomEscapeGuest {
	private String name;
	private String date;
	private int count;
	
	public RoomEscapeGuest() {
	}

	public RoomEscapeGuest(String name, String date, int count) {
		this.name = name;
		this.date = date;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
