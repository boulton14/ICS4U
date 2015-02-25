public class SimpleDate {

    private int day;

    private int month;

    private int year;

    public SimpleDate(final int day, final int month, final int year)
            throws Exception {
        if (month < 1 || month > 12) {
            throw new Exception("Month out of range");
        }
        if (day < 1 || day > 31) {
            throw new Exception("Day out of range");
        }
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

    public void setDay(final int day) {
        this.day = day;
    }

    public void setMonth(final int month) {
        this.month = month;
    }

    public void setYear(final int year) {
        this.year = year;
    }

}
