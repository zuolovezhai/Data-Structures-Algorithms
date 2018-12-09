package dataStructures.linearTable.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、表达式求值
 * 2、括号匹配
 * @author Administrator
 * @date 2018年12月7日 下午2:37:35
 * @Description TODO
 */
public class StackAlgo {
	private static Map<String, Integer> operators = new HashMap<String, Integer>();
	
	static {
		operators.put("+", 0);
		operators.put("-", 0);
		operators.put("*", 1);
		operators.put("/", 1);
	}
	
	/**
	 * 表达式求值
	 * @param expression
	 * @return
	 */
	public int evaluatExpression(String expression) {
		LinkStack<Integer> operand = new LinkStack<Integer>();
		LinkStack<String> operator = new LinkStack<String>();
		for (int i = 0; i < expression.length(); i++) {
			char data = expression.charAt(i);
			if (Character.isDigit(data)) {
				operand.push((int) data);
			} else {
				if (operator.getTop() == null) {
					operator.push(String.valueOf(data));
				} else {
					if (compare(String.valueOf(data), operator.getTop().getData()) == 1) {
						operator.push(String.valueOf(data));
					} else {
						int value = compute(operand.pop(), operand.pop(), operator.pop());
						operand.push(value);
					}
				}
			}
		}
		return operand.pop();
	}
	
	/**
	 * 比较两个操作符的优先级
	 * operator1 > operator2 return 1
	 * operator1 = operator2 return 0
	 * operator1 < operator2 return -1
	 * @return
	 */
	private int compare(String operator1, String operator2) {
		if (operators.get(operator1) > operators.get(operator2)) {
			return 1;
		} else if (operators.get(operator1) == operators.get(operator2)) {
			return 0;
		} else {
			return -1;
		}
	}
	
	private int compute(int operand1, int operand2, String type) {
		switch (type) {
		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;
		case "*":
			return operand1 * operand2;
		case "/":
			return operand1 / operand2;
		default:
			throw new RuntimeException("Unknow operator");
		}
	}
	
	public boolean matchBracket(String bracket) {
		LinkStack<String> stack = new LinkStack<String>();
		return false;
	} 
	
	
	public static void main(String[] args) {
		StackAlgo stackAlgo = new StackAlgo();
		System.out.println(stackAlgo.evaluatExpression("3+5*8-6"));
	}

}
