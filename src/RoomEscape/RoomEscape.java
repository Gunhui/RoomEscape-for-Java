package RoomEscape;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomEscape {
	public static int Key, Point, checkCount, rspCount = 0;
	private String name;
	private long time = System.currentTimeMillis();
	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String date = dayTime.format(new Date(time));
	private int count;
	private int leftTime;

	public int getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(int leftTime) {
		this.leftTime = leftTime;
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

	public void setTime(String date) {
		this.date = date;
	}

	public int getCount() {
		return 100 + leftTime - rspCount - checkCount;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static int getRspCount() {
		return rspCount;
	}

	public static void setRspCount(int rspCount) {
		RoomEscape.rspCount = rspCount;
	}

	public void setKey() {
		this.Key = 1;
	}

	public static int getCheckCount() {
		return checkCount;
	}

	public static void setCheckCount(int checkCount) {
		RoomEscape.checkCount = checkCount;
	}

	public int getKey() {
		return Key;
	}

	public int getPoint() {
		return Point;
	}

	public void setPoint() {
		this.Point = 1;
	}
}