package cn.itcast.domain;

/**
 * 存放业务数据
	 * firstNum、operator、secondNum
	 * 计算结果
	 * result
 * 方法
 *  calculator()
 */
public class Calculator {
	private String firstNum;
	private String operator;
	private String secondNum;
	private String result;
	public String getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Calculator() {
	}
	
	//计算方法
	public void calculator(){
		
		//通过运算符，将firstNum和secondNum处理的结果，存放到result
		System.out.println(this.firstNum);
		System.out.println(this.operator);
		System.out.println(this.secondNum);
		
		
		double first = Double.valueOf(this.firstNum);
		double second = Double.valueOf(this.secondNum);
		char ope = this.operator.charAt(0);
		
		switch (ope) {
			case '+':
				this.result = String.valueOf(first + second);
				break;
			case '-':
				this.result = String.valueOf(first - second);
				break;
			case '*':
				this.result = String.valueOf(first * second);
				
				break;
			case '/':
				this.result = String.valueOf(first / second);
				break;
	
			default:
				throw new RuntimeException("非法操作符");
		}
		
	}
	 

}
