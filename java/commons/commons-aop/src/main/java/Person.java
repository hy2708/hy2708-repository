

public class Person extends E1 {
	private String name="����Ң";
    private String number="18175136675";//������
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
    
  //���ʷ���
    public void setNumber(String number) {
	    this.number = number;
    }
  //toString����
    public String toString(){
	    return s="Person�ࣺ"+"����Ϊ��"+getName()+" "+"�绰Ϊ��"+getNumber();
    }
}
