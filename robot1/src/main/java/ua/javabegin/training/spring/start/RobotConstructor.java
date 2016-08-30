package ua.javabegin.training.spring.start;

import java.awt.Color;

import ua.javagegin.training.spring.impls.sony.SonyHand;
import ua.javagegin.training.spring.impls.sony.SonyHead;
import ua.javagegin.training.spring.impls.toshiba.ToshibaLeg;

public class RobotConstructor {

	public static void main(String[] args) {
		
		SonyHand sonyHand = new SonyHand();
		
		ToshibaLeg toshibaLeg = new ToshibaLeg();
		
		SonyHead sonyHead = new SonyHead();
		
		Robot robot = new Robot(sonyHand, toshibaLeg, sonyHead);
		
		robot.action();

	}

}
