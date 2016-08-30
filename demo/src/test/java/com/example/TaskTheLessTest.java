package com.example;


import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTheLessTest {

	@Test
	public void checkFindLessDifference() {
		TaskTheLess task = new TaskTheLess();
		int[] aa = {1, 22, 333, 7777777, 4323, 10000, 77};
		assertEquals(task.new MyNumber(1, 22), task.findLessDifference(aa));
	}

}
