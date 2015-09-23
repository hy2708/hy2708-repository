public class Mydate extends Employee{
	private int year=2001;
	private int month=5;
	private int day=8;
	String s;
	
	public int getYear() {
		return year;
    }
	public void setYear(int year) {
		this.year = year;
    }
	public int getMonth() {
		return month;
    }
	public void setMonth(int month) {
		this.month = month;
    }
    public int getDay() {
	    return day;
    }
    public void setDay(int day) {
	    this.day = day;
    }
  //访问方法
    public String getDate() {
	    return s=getYear()+"年"+getMonth()+"月"+getDay()+"日";
    }

}



