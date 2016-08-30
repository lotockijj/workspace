package ru.javabegin.training.spring.impls.conveyor;

import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotConveyor;

public abstract class T1000Conveyor implements RobotConveyor{

	@Override
	public abstract Robot createRobot();
}
