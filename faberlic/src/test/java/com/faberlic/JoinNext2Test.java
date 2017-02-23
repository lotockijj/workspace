package com.faberlic;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.apache.commons.io.FileUtils;

public class JoinNext2Test {

	JoinNext2 join; 
	@Before
	public void setUp() throws Exception {
		join = new JoinNext2();
		try {
			join.createPathAndScanner("E:\\Faberlic\\15_2016adapter22.txt");
			join.writeListTestIntoFile("C:\\Users\\Роман Лотоцький\\"
					+ "workspace\\faberlic\\fileForTesting\\2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void testCreatePathAndScanner() {
//		assertEquals(1, join.listGoods.size());
//	}

//	@Test
//	public void testWriteListTestIntoFile() throws IOException{
//		final File tempFile = new File("tempFile.txt");
//		FileUtils.writeStringToFile(tempFile, "hello world");
//		final String s = FileUtils.readFileToString(tempFile);
//		assertEquals("hello world", s);
//		assertTrue(tempFile.exists());
//	}

//	@Test
//	public void testParseAndCreateListOfGoods() {
//		join.parseAndCreateListOfGoods(" 88 0245 СЫВОРОТКА-ХАЙЛАЙТЕР "
//				+ "Д/ЛИЦА AIR STREAM СИЯНИЕ (ПО АКЦИИ) 165 65 61% 48,1 2,14 52,0 2,31");
//		System.out.println(join.currentGoods);
//		System.out.println("Every thing would be good :)");
//	}

	@Test
	public void testWriteDataIntoDataBase(){
		join.writeDataIntoDataBase(join.listGoods);
	}
}
