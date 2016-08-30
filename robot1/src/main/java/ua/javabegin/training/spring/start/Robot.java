package ua.javabegin.training.spring.start;

import ua.javabegin.training.spring.interfaces.Hand;
import ua.javabegin.training.spring.interfaces.Head;
import ua.javabegin.training.spring.interfaces.Leg;

public class Robot {
	
	private Hand hand;
	private Leg leg;
	private Head head;
	
	public Robot(Hand hand, Leg leg, Head head){
		super();
		this.hand = hand;
		this.head = head;
		this.leg = leg;
	}
	
	public void action(){
		head.calc();
		hand.catchSomething();
		leg.go();
	}

}
