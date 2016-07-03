

public class Person extends E1 {
	private String name="徐张尧";
    private String number="18175136675";//数据域
    String s;

    public String getName() {
    	return name;
    }
    public void setName(String name) {
	    this.name = name;
    }
    public String getNumber() {
	    return number;
    }
    
  //访问方法
    public void setNumber(String number) {
	    this.number = number;
    }
  //toString方法
    public String toString(){
	    return s="Person类："+"姓名为："+getName()+" "+"电话为："+getNumber();
    }
}
