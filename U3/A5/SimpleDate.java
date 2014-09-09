public class SimpleDate {

	private int day;

	private int month;

	private int year;

	public SimpleDate(int day, int month, int year) throws Exception {
		if (month < 1 || month > 12) {
			throw new Exception("Month out of range");
		}
		if (day < 1 || day > 31) {
			throw new Exception("Day out of range");
		}
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void printDate() {
		System.out.println(month + "/" + day + "/" + year);
	}

}
