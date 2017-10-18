package com.epam.interview;

public class QuestionSuper {
	private String firstQuestion;

	public QuestionSuper(String firstQuestion) {
		super();
		this.firstQuestion = firstQuestion;
	}
	
	public String someMethod(){
		return super.toString() + " " + firstQuestion;
	}
	
	public String someMethodThis(){
		return this.toString();
	}
	
	public static void main(String[] args) {
		QuestionSuper q = new QuestionSuper("Roman");
		System.out.println(q.someMethod());
		System.out.println(q.someMethodThis());
	}
}
