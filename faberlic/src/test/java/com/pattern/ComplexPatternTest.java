package com.pattern;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class ComplexPatternTest {

	ComplexPattern complex;
	@Before
	public void setUp() throws Exception {
		complex = new ComplexPattern();
	}

	//	@Test
	//	public void testCreatePathAndScanner() {
	//		complex.createPathAndScanner();
	//	}

	@Test
	public void testTryAndCheckRegex(){
		//		complex.tryAndCheckRegexTwoNumbersThoughDefis("АКЦИЯ!!! ДВА ЛЮБЫХ КРЕМА ДЛЯ РУК СЕРИИ PRO РУКИ "
		//				+ "(12185-12188) ВСЕГО ЗА 25 ГРН КАЖДЫЙ: КРЕМ Д/РУК, БАЛЬЗАМ Д/РУК (ПО АКЦИИ)");
//		ArrayList<Integer> list = complex.tryAndCheckRegexTwoNumbersThoughDefis2("АКЦИЯ!!! ДВА ЛЮБЫХ КРЕМА ДЛЯ РУК СЕРИИ PRO РУКИ "
//						+ "(2222-2224) ВСЕГО ЗА 25 ГРН КАЖДЫЙ: КРЕМ Д/РУК, БАЛЬЗАМ Д/РУК (ПО АКЦИИ)");
//		for(int i = 0; i < list.size(); i++){
//			System.out.print(list.get(i) + ", ");
//		}
//		ArrayList<Integer> ss = complex.findingSeparateNumbers("АКЦИЯ!!! ДВА ЛЮБЫХ ПРОДУКТА СЕРИИ СПЕЛАЯ СМОРОДИНА "
//				+ "(2130,2133,2135,2239,2240) ПО СПЕЦИАЛЬНОЙ ЦЕНЕ: БАЛЬЗАМ ДЛЯ ГУБ (ПО АКЦИИ)");
//		for(int i : ss){
//			System.out.println(i);
//		}
		String str = complex.findingArticleAndSetAllArticles("АКЦИЯ!!! ДВА ЛЮБЫХ ПРОДУКТА СЕРИИ СПЕЛАЯ "
				+ "СМОРОДИНА (2130,2133,2135,2239,2240) ПО СПЕЦИАЛЬНОЙ ЦЕНЕ: "
				+ "БАЛЬЗАМ ДЛЯ ГУБ (ПО АКЦИИ) (11111-11115) (3333-3335) test 2016");
		System.out.println(str);
	}


}
