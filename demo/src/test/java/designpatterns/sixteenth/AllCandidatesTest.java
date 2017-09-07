package designpatterns.sixteenth;

import org.junit.Test;

public class AllCandidatesTest {

	@Test
	public void test() {
		AllCandidates allCand = new AllCandidates();
		while(allCand.ec.hasMoreElements()){
			System.out.println(allCand.ec.nextElement());
		}
	}

}
